package app.harry.daggerwithdfm.di

import android.app.Application
import app.harry.core.di.App
import app.harry.core.di.BaseFeatureInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class AppFeatureInjector : BaseFeatureInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun inject(app: Application) {
        DaggerAppFeatureComponent.builder()
            .coreComponent((app as App).coreComponent)
            .build()
            .inject(this)
    }

    override fun androidInjector() = androidInjector

}