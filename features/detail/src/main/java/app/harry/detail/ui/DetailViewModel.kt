package app.harry.detail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.harry.core.ui.BaseViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor() : BaseViewModel() {

    private val _param = MutableLiveData<String>()
    val param: LiveData<String> get() = _param

    fun setParam(param: String?) {
        _param.value = param
    }

}