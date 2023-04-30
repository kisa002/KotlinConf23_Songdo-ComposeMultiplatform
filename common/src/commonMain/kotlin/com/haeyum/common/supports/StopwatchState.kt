package com.haeyum.common.supports

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

enum class StopwatchStateValue {
    START, PAUSE, STOP
}

@Stable
class StopwatchState(initialStateValue: StopwatchStateValue = StopwatchStateValue.STOP, initialTime: Int = 0) {
    private var _stateValue by mutableStateOf(initialStateValue)
    val stateValue
        get() = _stateValue

    private var _time by mutableStateOf(initialTime)
    val time
        get() = _time

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var job: Job? = null

    val formattedTimeString: String
        get() {
            val hour = _time / 3600
            val minute = (_time % 3600) / 60
            val second = _time % 60
            return "%02d:%02d:%02d".format(hour, minute, second)
        }

    fun start() {
        job?.cancel()
        job = coroutineScope.launch {
            while (isActive) {
                delay(1.seconds)
                _time++
            }
        }
        _stateValue = StopwatchStateValue.START
    }

    fun pause() {
        job?.cancel()
        _stateValue = StopwatchStateValue.PAUSE
    }

    fun resume() {
        start()
    }

    fun stop() {
        job?.cancel()
        _stateValue = StopwatchStateValue.STOP
    }

    fun reset() {
        stop()
        _time = 0
    }

    init {
        if (initialStateValue == StopwatchStateValue.START) {
            start()
        }
    }

    companion object {
        val Saver: Saver<StopwatchState, *> = Saver(
            save = { stopwatchState -> stopwatchState.stateValue to stopwatchState.time },
            restore = { stopwatchPair ->
                val (stateValue, time) = stopwatchPair
                StopwatchState(stateValue, time)
            }
        )
    }
}

@Composable
fun rememberStopwatchState(): State<StopwatchState> {
    return rememberSaveable(
        stateSaver = StopwatchState.Saver
    ) {
        mutableStateOf(StopwatchState())
    }
}