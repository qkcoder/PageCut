package com.qk.pagescut.minipage

/**
 ** @author qkcoder
 ** @email  qkcoder@aliyun.com
 ** @date   2020/8/31
 ** @desc   生命周期注册者，监控MiniPage生命周期
 **/
interface ILifeCycleProvider {

    fun registerLifeCycleMonitor(lifeCycleMonitor: LifeCycleMonitor?)

    fun unregisterLifeCycleMonitor(lifeCycleMonitor: LifeCycleMonitor?)

}