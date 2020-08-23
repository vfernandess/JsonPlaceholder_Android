package com.voidx.jsonplaceholder

import com.voidx.jsonplaceholder.data.dataModule
import com.voidx.jsonplaceholder.feature.featureModule
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.dsl.module

val module = module {

    factory {
        AndroidSchedulers.mainThread()
    }

}

val applicationModule = listOf(module) + dataModule + featureModule