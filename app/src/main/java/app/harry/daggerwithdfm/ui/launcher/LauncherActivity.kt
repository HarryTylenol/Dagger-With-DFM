package app.harry.daggerwithdfm.ui.launcher

import android.os.Bundle
import app.harry.core.ui.BaseActivity
import app.harry.daggerwithdfm.R
import app.harry.daggerwithdfm.databinding.ActvLauncherBinding
import app.harry.daggerwithdfm.di.AppFeatureInjector

class LauncherActivity : BaseActivity<ActvLauncherBinding, LauncherViewModel>() {

    override val featureInjector = AppFeatureInjector()

    override val layoutResId: Int = R.layout.actv_launcher

    override val viewModel: LauncherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.endSplash.observe { finish() }
    }

}