package com.haeyum.common

import com.haeyum.common.supports.StopwatchUtil

class AppViewModel(private val stopwatchUtil: StopwatchUtil = StopwatchUtil()) : BaseViewModel() {
    val stopwatchState = stopwatchUtil.state
    val formattedTimeString = stopwatchUtil.formattedTimeString

    fun start() = stopwatchUtil.start()
    fun pause() = stopwatchUtil.pause()
    fun resume() = stopwatchUtil.resume()
    fun reset() = stopwatchUtil.reset()

    override fun destroy() {
        super.destroy()
        stopwatchUtil.destroy()
    }
}