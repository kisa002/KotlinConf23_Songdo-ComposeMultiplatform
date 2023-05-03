package com.haeyum.common.supports

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

enum class StopwatchState {
    START, PAUSE, STOP
}

class StopwatchUtil {
    private val _state = MutableStateFlow<StopwatchState>(StopwatchState.STOP)
    val state = _state.asStateFlow()

    private val _time = MutableStateFlow(0)
    val time = _time.asStateFlow()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var job: Job? = null

    val formattedTimeString = time.map {
        val hour = time.value / 3600
        val minute = (time.value % 3600) / 60
        val second = time.value % 60
        "%02d:%02d:%02d".format(hour, minute, second)
    }.stateIn(coroutineScope, SharingStarted.WhileSubscribed(), "00:00:00")

    fun start() {
        job?.cancel()
        job = coroutineScope.launch {
            while (isActive) {
                delay(1.seconds)
                _time.value++
            }
        }
        _state.value = StopwatchState.START
    }

    fun pause() {
        job?.cancel()
        _state.value = StopwatchState.PAUSE
    }

    fun resume() {
        start()
    }

    private fun stop() {
        job?.cancel()
        _state.value = StopwatchState.STOP
    }

    fun reset() {
        stop()
        _time.value = 0
    }

    fun destroy() {
        job?.cancel()
        coroutineScope.cancel()
    }
}