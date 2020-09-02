package com.qk.pagescut.minipage

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/8/31
 ** @desc   暴露给宿主Activity的MiniPage生命周期监控
 **/
interface IActivityHostLifeCycleMonitor : LifeCycleMonitor {

    open class DefaultActivityHostLifeCycleMonitor : LifeCycleMonitor.Stub(),
        IActivityHostLifeCycleMonitor {
        override fun show(page: MiniPage) {

        }

        override fun dismiss(page: MiniPage) {
        }
    }

    fun show(page: MiniPage)

    fun dismiss(page: MiniPage)

}