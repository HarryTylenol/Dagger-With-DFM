package app.harry.core.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.harry.core.di.App
import app.harry.core.di.BaseFeatureInjector
import app.harry.core.utils.misc.debug
import com.google.android.play.core.splitcompat.SplitCompat
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<Binding : ViewDataBinding, VM : BaseViewModel> :
    DaggerAppCompatActivity() {

    abstract val featureInjector: BaseFeatureInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract val layoutResId: Int

    abstract val viewModel: VM

    inline fun <reified T : BaseViewModel> viewModel() = viewModels<T> { viewModelFactory }

    val binding: Binding by lazy { DataBindingUtil.setContentView<Binding>(this, layoutResId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        SplitCompat.installActivity(this)
        (application as App).addModuleInjector(featureInjector)
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        binding.lifecycleOwner = this
        viewModel.intentNavigation.observe {
            debug("Navigate ${it.data}")
            startActivity(it)
        }
    }

    fun <T> LiveData<T>.observe(block: (T) -> Unit) = observe(this@BaseActivity, Observer {
        block(it)
    })

}