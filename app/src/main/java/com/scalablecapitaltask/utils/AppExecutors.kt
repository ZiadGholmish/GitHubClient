package com.scalablecapitaltask.utils

import android.os.Handler
import android.os.Looper
import android.support.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by ziadgholmish on 3/1/18.
 */
class AppExecutors() {

    private val THREAD_COUNT = 3
    val diskIO: Executor = DiskIOThreadExecutor()
    val networkIO: Executor = Executors.newFixedThreadPool(THREAD_COUNT)
    val mainThread: Executor = MainThreadExecutor()

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }


}