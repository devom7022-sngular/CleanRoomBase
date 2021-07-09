package com.example.roombase.di.module.ui

import com.example.roombase.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ControllerBuildersModule
 */
@Module
abstract class ControllerBuildersModule {

    /**
     * Method to build main activity for inject
     *
     * @return MainActivity
     */
    @ContributesAndroidInjector
    abstract fun buildMainActivity(): MainActivity
}