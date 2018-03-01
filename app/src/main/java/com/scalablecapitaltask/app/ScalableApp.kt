package com.scalablecapitaltask.app

import android.app.Application
import android.content.Context

/**
 * Created by ziadgholmish on 2/26/18.
 */
class ScalableApp : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
    
}