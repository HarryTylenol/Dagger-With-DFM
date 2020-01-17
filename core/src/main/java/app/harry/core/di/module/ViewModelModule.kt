package app.harry.core.di.module

import androidx.lifecycle.ViewModelProvider
import app.harry.core.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory : DaggerViewModelFactory) : ViewModelProvider.Factory

}