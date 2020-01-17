package app.harry.detail.ui

import android.os.Bundle
import app.harry.core.di.BaseFeatureInjector
import app.harry.core.ui.BaseActivity
import app.harry.core.utils.annotation.AppDeepLink
import app.harry.core.utils.annotation.WebDeepLink
import app.harry.core.utils.ext.intentExtra
import app.harry.detail.R
import app.harry.detail.databinding.ActvDetailBinding
import app.harry.detail.di.DetailFeatureInjector

@WebDeepLink("detail/{param}")
@AppDeepLink("detail/{param}")
class DetailActivity : BaseActivity<ActvDetailBinding, DetailViewModel>() {

    override val featureInjector: BaseFeatureInjector = DetailFeatureInjector()

    override val layoutResId: Int = R.layout.actv_detail

    override val viewModel: DetailViewModel by viewModel()

    private val param by intentExtra<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        supportActionBar?.title = param
        viewModel.setParam(param)
    }

}