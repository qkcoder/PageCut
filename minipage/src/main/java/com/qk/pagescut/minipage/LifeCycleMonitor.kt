package com.qk.pagescut.minipage

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/8/31
 ** @desc   MiniPage相关生命周期
 **/
interface LifeCycleMonitor {
    open class Stub : LifeCycleMonitor {
        override fun onCreate(obj: Any?) {
        }

        override fun onStart() {
        }

        override fun onResume() {
        }

        override fun onPause() {
        }

        override fun onStop() {
        }

        override fun onDestroy() {
        }
    }

    fun onCreate(obj: Any?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}