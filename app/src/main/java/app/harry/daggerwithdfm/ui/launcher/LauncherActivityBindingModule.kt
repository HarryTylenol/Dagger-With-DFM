package app.harry.daggerwithdfm.ui.launcher

import androidx.lifecycle.ViewModel
import app.harry.core.utils.annotation.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LauncherActivityBindingModule {

    @ContributesAndroidInjector(modules = [LauncherViewModelBindingModule::class])
    abstract fun contributeLauncherActivity(): LauncherActivity

    @Module
    abstract class LauncherViewModelBindingModule {

        @Binds
        @IntoMap
        @ViewModelKey(LauncherViewModel::class)
        abstract fun bindMainViewModel(homeViewModel: LauncherViewModel): ViewModel

    }

}