package app.harry.core.di

import android.content.Context
import app.harry.core.di.module.CoreModule
import app.harry.core.di.module.ViewModelModule
import app.harry.core.utils.misc.SplitInstallUtil
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        CoreModule::class,
        ViewModelModule::class
    ]
)
interface CoreComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): CoreComponent
    }


    fun provideApplicationContext(): Context
    fun provideSplitInstallUtil(): SplitInstallUtil

}