package io.ansor.al.huda.data.store

import io.ansor.al.huda.common.architecture.BaseStore
import io.ansor.al.huda.domain.model.Language
import javax.inject.Inject

class AppLanguageStore @Inject constructor() : BaseStore<Language>(Language::class.java)