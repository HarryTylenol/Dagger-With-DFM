package app.harry.detail.di

import android.app.Application
import app.harry.core.di.App
import app.harry.core.di.BaseFeatureInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class DetailFeatureInjector : BaseFeatureInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun inject(app: Application) {
        DaggerDetailFeatureComponent.builder()
            .coreComponent((app as App).coreComponent)
            .build()
            .inject(this)
    }

    override fun androidInjector() = androidInjector

}