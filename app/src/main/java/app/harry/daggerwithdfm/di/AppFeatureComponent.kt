package app.harry.daggerwithdfm.di

import app.harry.core.di.CoreComponent
import app.harry.core.di.module.ViewModelModule
import app.harry.core.utils.annotation.dagger.FeatureScope
import app.harry.daggerwithdfm.ui.launcher.LauncherActivityBindingModule
import app.harry.daggerwithdfm.ui.main.HomeActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        AndroidInjectionModule::class,
        LauncherActivityBindingModule::class,
        HomeActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface AppFeatureComponent {
    fun inject(appFeatureInjector: AppFeatureInjector)
}