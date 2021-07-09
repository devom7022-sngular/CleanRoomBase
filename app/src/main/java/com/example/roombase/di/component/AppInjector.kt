package com.example.roombase.di.component

import android.app.Application

class AppInjector {

    companion object {

        /**
         * Method to init configuration
         */
        fun init(app: Application) {
            app.registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksImpl())
        }
    }
}