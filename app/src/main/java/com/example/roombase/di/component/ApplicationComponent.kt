package com.example.roombase.di.component

import android.app.Application
import com.example.roombase.di.module.data.DataManagerModule
import com.example.roombase.di.module.data.DatabaseModule
import com.example.roombase.di.module.data.RepositoryModule
import com.example.roombase.ui.app.BaseApp
import com.example.roombase.di.module.ui.AppModule
import com.example.roombase.di.module.ui.ControllerBuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * ApplicationComponent
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ControllerBuildersModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        DataManagerModule::class]
)
interface ApplicationComponent {

    /**
     * Method to inject application
     *
     * @param app app instance
     */
    fun inject(app: BaseApp)

    /**
     * Builder instance
     */
    @Component.Builder
    interface Builder {

        /**
         * application
         *
         * @return builder
         */
        @BindsInstance
        fun application(app: Application): Builder

        /**
         * build
         *
         * @return ApplicationComponent
         */
        fun build(): ApplicationComponent
    }
}