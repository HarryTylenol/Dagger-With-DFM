package app.harry.core.utils.annotation

import app.harry.core.utils.misc.Urls
import com.airbnb.deeplinkdispatch.DeepLinkSpec

@DeepLinkSpec(prefix = [Urls.WebScheme])
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class WebDeepLink(vararg val value: String)