package app.harry.detail.ui

import androidx.lifecycle.ViewModel
import app.harry.core.utils.annotation.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class DetailActivityBindingModule {

    @ContributesAndroidInjector(modules = [DetailViewModelBindingModule::class])
    abstract fun contributeDetailActivity(): DetailActivity

    @Module
    abstract class DetailViewModelBindingModule {

        @Binds
        @IntoMap
        @ViewModelKey(DetailViewModel::class)
        abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    }

}