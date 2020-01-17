package app.harry.core.utils.misc

import android.content.Context
import com.google.android.play.core.splitinstall.*
import java.util.*

class SplitInstallUtil(context: Context) {

    private var splitInstallManager: SplitInstallManager =
        SplitInstallManagerFactory.create(context)

    fun installModule(moduleName: String, block: (Throwable?) -> Unit) {
        if (!splitInstallManager.installedModules.contains(moduleName)) {
            splitInstallManager
                .startInstall(
                    SplitInstallRequest.newBuilder()
                        .addModule(moduleName)
                        .build()
                ).addOnCompleteListener { block(it.exception) }
        } else block(null)
    }

    fun installLanguage(languageCode: String, block: (Throwable?) -> Unit) {
        if (!splitInstallManager.installedLanguages.contains(languageCode)) {
            splitInstallManager
                .startInstall(
                    SplitInstallRequest.newBuilder()
                        .addLanguage(Locale(languageCode))
                        .build()
                ).addOnCompleteListener { block(it.exception) }
        } else block(null)
    }

}