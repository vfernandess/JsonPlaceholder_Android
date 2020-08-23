package com.voidx.jsonplaceholder.feature.home

import androidx.navigation.NavController
import org.koin.dsl.module

val homeFeatureModule = module {

    factory { (navigation: NavController) ->
        HomeCoordinator(navigation)
    }

}