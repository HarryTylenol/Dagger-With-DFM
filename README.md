# **Dagger With DFM (Dynamic Feature Module)**

Android AAC, DataBinding, ViewModel, Dagger2, DeepLinkDispatch, Dynamic Feature Module

#### Modules
- core
- app (+ core)
- features
    - detail (+ core, app)

##### Module Injector injection from App.kt
```kotlin
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
```

##### Inject DFM's Module with AppFeatureInjector.kt
```kotlin
class AppFeatureInjector : BaseFeatureInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun inject(app: Application) {
        DaggerAppFeatureComponent.builder()
            .coreComponent((app as App).coreComponent)
            .build()
            .inject(this)
    }

    override fun androidInjector() = androidInjector

}
```

##### Add feature module injector to App.kt in BaseActivity.kt
```kotlin

abstract val featureInjector: BaseFeatureInjector

override fun onCreate(savedInstanceState: Bundle?) {
        SplitCompat.installActivity(this)
        (application as App).addModuleInjector(featureInjector)
        super.onCreate(savedInstanceState)
        // ...
}

```


