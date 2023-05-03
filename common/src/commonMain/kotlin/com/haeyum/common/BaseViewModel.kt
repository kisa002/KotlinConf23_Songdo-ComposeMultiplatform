package com.haeyum.common

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val viewModelScope: CoroutineScope
    open fun destroy()
}