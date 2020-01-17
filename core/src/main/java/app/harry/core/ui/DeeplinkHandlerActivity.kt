package app.harry.core.ui

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.BaseDeepLinkDelegate
import com.airbnb.deeplinkdispatch.Parser

class DeeplinkHandlerActivity : Activity() {

    companion object {
        private const val Prefix = "app.harry"
        const val AppDeeplinkModule = "${Prefix}.daggerwithdfm.utils.AppDeeplinkModuleLoader"
        const val DetailDeeplinkModule = "${Prefix}.detail.utils.DetailDeeplinkModuleLoader"
    }

    private fun String.loadDeepLinkLoader(): Parser? {
        return try {
            Class.forName(this).newInstance() as? Parser
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkDelegate = BaseDeepLinkDelegate(
            listOfNotNull(
                AppDeeplinkModule.loadDeepLinkLoader(),
                DetailDeeplinkModule.loadDeepLinkLoader()
            )
        )
        deepLinkDelegate.dispatchFrom(this)
        finish()
    }
}