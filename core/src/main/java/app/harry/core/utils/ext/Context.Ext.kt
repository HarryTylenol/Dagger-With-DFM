package app.harry.core.utils.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import java.io.Serializable
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified Act : Activity> Context.activityIntent(
    extras: Map<String, Any> = mapOf(),
    block: Intent.() -> Intent = { this }
): Intent {
    return Intent(this, Act::class.java)
        .apply {
            extras.forEach { (key, value) ->
                when (value) {
                    is String -> putExtra(key, value)
                    is Int -> putExtra(key, value)
                    is Long -> putExtra(key, value)
                    is Double -> putExtra(key, value)
                    is Boolean -> putExtra(key, value)
                    is Serializable -> putExtra(key, value)
                    is Parcelable -> putExtra(key, value)
                }

            }
        }
        .run(block)
}

inline fun <reified Act : Activity> Fragment.activityIntent(
    extras: Map<String, Any> = mapOf(),
    block: Intent.() -> Intent = { this }
): Intent {
    return requireContext().activityIntent<Act>(extras, block)
}

fun <T> intentExtra(name: String? = null) = object : ReadOnlyProperty<Activity, T?> {
    override fun getValue(thisRef: Activity, property: KProperty<*>): T? {
        return thisRef.intent.extras?.get(name ?: property.name) as? T
    }
}