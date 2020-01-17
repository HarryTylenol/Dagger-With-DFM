package app.harry.daggerwithdfm.ui.main

import android.os.Bundle
import app.harry.core.ui.BaseActivity
import app.harry.core.utils.annotation.AppDeepLink
import app.harry.core.utils.annotation.WebDeepLink
import app.harry.core.utils.misc.Urls
import app.harry.daggerwithdfm.R
import app.harry.daggerwithdfm.databinding.ActvHomeBinding
import app.harry.daggerwithdfm.di.AppFeatureInjector

@WebDeepLink("home")
@AppDeepLink("home")
class HomeActivity : BaseActivity<ActvHomeBinding, HomeViewModel>() {

    override val featureInjector = AppFeatureInjector()

    override val layoutResId: Int = R.layout.actv_home

    override val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.btnDetail.setOnClickListener {
            val param = binding.editTextView.text?.toString() ?: "Empty"
            viewModel.navigateScreen("detail/$param")
        }
        binding.btnDetailWebUrl.setOnClickListener {
            val param = binding.editTextView.text?.toString() ?: "Empty"
            viewModel.navigate("${Urls.WebScheme}detail/$param")
        }
    }

}