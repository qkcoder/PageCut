package com.qk.pagescutsample

import android.app.Application

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/9/2
 ** @desc   业务Application
 **/
class PageCutApp : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

//        Fresco.initialize(this)
//        FLog.setMinimumLoggingLevel(FLog.VERBOSE)
    }

    companion object {
        lateinit var INSTANCE: PageCutApp
            private set
    }
}