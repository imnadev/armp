package io.ansor.al.huda.common.architecture

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class BaseStore<T>(
    private val classOfT: Class<T>
) {

    @Inject
    lateinit var dataStore: DataStore<Preferences>

    private val gson = Gson()

    private val key = stringPreferencesKey(this.javaClass.name)

    suspend fun set(data: T) {
        dataStore.edit {
            it[key] = gson.toJson(data)
        }
    }

    suspend fun clear() {
        dataStore.edit { it.remove(key) }
    }

    suspend fun get() = getFlow().firstOrNull()

    suspend fun get(default: T) = get() ?: default

    fun getFlow(default: T) = getFlow().map { it ?: default }

    fun getFlow() = dataStore.data.map { it[key] }.distinctUntilChanged().map {
        try {
            gson.fromJson(it, classOfT)
        } catch (e: Exception) {
            null
        }
    }
}