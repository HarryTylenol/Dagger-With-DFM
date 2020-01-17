package app.harry.daggerwithdfm.ui.main

import androidx.lifecycle.ViewModel
import app.harry.core.utils.annotation.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeActivityBindingModule {

    @ContributesAndroidInjector(modules = [HomeViewModelBindingModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @Module
    abstract class HomeViewModelBindingModule {

        @Binds
        @IntoMap
        @ViewModelKey(HomeViewModel::class)
        abstract fun bindMainViewModel(homeViewModel: HomeViewModel): ViewModel

    }

}