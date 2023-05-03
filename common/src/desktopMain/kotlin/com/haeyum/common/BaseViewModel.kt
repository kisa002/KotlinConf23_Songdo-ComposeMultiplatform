package com.haeyum.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

actual open class BaseViewModel actual constructor() {
    actual val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    actual open fun destroy() = viewModelScope.cancel()
}