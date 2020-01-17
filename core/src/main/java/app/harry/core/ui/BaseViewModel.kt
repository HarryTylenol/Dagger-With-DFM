package app.harry.core.ui

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.harry.core.utils.misc.Urls

abstract class BaseViewModel : ViewModel() {

    private val _intentNavigation = MutableLiveData<Intent>()
    val intentNavigation: LiveData<Intent> get() = _intentNavigation

    fun navigate(intent: Intent) {
        _intentNavigation.value = intent
    }

    fun navigate(url: String) {
        _intentNavigation.value = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }

    fun navigateScreen(screenPath: String) {
        navigate("${Urls.AppScheme}$screenPath")
    }


}