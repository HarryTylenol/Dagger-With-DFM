package app.harry.core.di.module

import android.content.Context
import app.harry.core.di.App
import app.harry.core.utils.misc.SplitInstallUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: App) = app.applicationContext

    @Provides
    @Singleton
    fun provideSplitInstall(context: Context) = SplitInstallUtil(context)

}