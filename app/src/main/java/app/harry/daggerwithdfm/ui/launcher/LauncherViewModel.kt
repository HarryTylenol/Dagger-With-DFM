package app.harry.daggerwithdfm.ui.launcher

import androidx.lifecycle.liveData
import app.harry.core.ui.BaseViewModel
import app.harry.core.utils.misc.Urls
import kotlinx.coroutines.delay
import javax.inject.Inject

class LauncherViewModel @Inject constructor() : BaseViewModel() {

    val endSplash = liveData {
        delay(1000)
        navigateScreen("home")
        emit(Unit)
    }

}