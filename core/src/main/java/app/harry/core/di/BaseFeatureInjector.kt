package app.harry.core.di

import android.app.Application
import dagger.android.DispatchingAndroidInjector

interface BaseFeatureInjector {

    fun inject(app: Application)

    fun androidInjector(): DispatchingAndroidInjector<Any>

}