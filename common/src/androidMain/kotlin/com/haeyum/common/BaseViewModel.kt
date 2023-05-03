package com.haeyum.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewModel actual constructor(): ViewModel() {
    actual val viewModelScope: CoroutineScope
        get() = (this as ViewModel).viewModelScope

    actual open fun destroy() = onCleared()
}