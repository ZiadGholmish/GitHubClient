package com.scalablecapitaltask.utils

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by ziadgholmish on 3/1/18.
 */
class DiskIOThreadExecutor : Executor {
    private var mDiskIO: Executor = Executors.newSingleThreadExecutor()
    override fun execute(command: Runnable) {
        mDiskIO.execute(command)
    }
}