package com.example.roombase.ui.app

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.example.roombase.di.component.AppInjector
import com.example.roombase.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Base app
 *
 * @since 24-07-2019
 */
class BaseApp : MultiDexApplication(), HasActivityInjector {

    /**
     * Activity injector instance
     */
    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Activity>

    /**
     * onCreate
     */
    override fun onCreate() {
        super.onCreate()

        // Dagger config
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)
        AppInjector.init(this)
        appInstance = this
    }

    companion object {

        /**
         * Application object
         */
        var appInstance: BaseApp? = null
    }

    /**
     * androidInjector
     *
     * @return AndroidInjector<Activity>
     */
    override fun activityInjector(): AndroidInjector<Activity> = mAndroidInjector

}