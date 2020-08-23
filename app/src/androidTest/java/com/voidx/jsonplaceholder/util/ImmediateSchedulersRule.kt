package com.voidx.jsonplaceholder.util

import com.squareup.rx2.idler.Rx2Idler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ImmediateSchedulersRule: TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setInitIoSchedulerHandler(Rx2Idler.create("Rxjava 2.0 Io Scheduler"))
                RxJavaPlugins.setInitComputationSchedulerHandler(Rx2Idler.create("Rxjava 2.0 computation Scheduler"))
                RxJavaPlugins.setInitNewThreadSchedulerHandler(Rx2Idler.create("Rxjava 2.0 new thread Scheduler"))
                RxJavaPlugins.setInitSingleSchedulerHandler(Rx2Idler.create("Rxjava 2.0 single scheduler Scheduler"))
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(Rx2Idler.create("rxjava 2.0 mainscheduler"))
                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }
}