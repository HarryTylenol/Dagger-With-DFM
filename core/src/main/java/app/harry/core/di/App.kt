package app.harry.core.di

import com.google.android.play.core.splitcompat.SplitCompat
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App  : DaggerApplication() {

    val coreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val moduleAndroidInjectors = mutableListOf<DispatchingAndroidInjector<Any>>()

    private val injectedModules = mutableSetOf<BaseFeatureInjector>()

    private val androidInjector = AndroidInjector<Any> { instance ->
        if (dispatchingAndroidInjector.maybeInject(instance)) {
            return@AndroidInjector
        }

        moduleAndroidInjectors.forEach { injector ->
            if (injector.maybeInject(instance)) return@AndroidInjector
        }

        throw IllegalStateException("$instance 의 Injector 를 찾을 수 없습니다.")
    }

    fun addModuleInjector(featureInjector: BaseFeatureInjector) {
        if (injectedModules.contains(featureInjector)) return
        featureInjector.inject(this)
        moduleAndroidInjectors.add(featureInjector.androidInjector())
        injectedModules.add(featureInjector)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun applicationInjector() = coreComponent

    override fun onCreate() {
        super.onCreate()
        SplitCompat.install(this)
        coreComponent.inject(this)
    }

}