package app.harry.detail.di

import app.harry.core.di.CoreComponent
import app.harry.core.di.module.ViewModelModule
import app.harry.core.utils.annotation.dagger.FeatureScope
import app.harry.detail.ui.DetailActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        DetailActivityBindingModule::class,
        DetailFeatureModule::class
    ]
)
interface DetailFeatureComponent {
    fun inject(detailFeatureInjector: DetailFeatureInjector)
}