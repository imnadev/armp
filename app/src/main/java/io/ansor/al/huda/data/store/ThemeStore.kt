package io.ansor.al.huda.data.store

import io.ansor.al.huda.common.architecture.BaseStore
import javax.inject.Inject

class ThemeStore @Inject constructor() : BaseStore<Boolean>(Boolean::class.java)