package app.harry.core.utils.misc

import android.util.Log

fun debugWithTag(tag: Any?, message: Any?) {
    Log.d(tag.toString(), message.toString())
}

fun Any.debug(message: Any?) = debugWithTag(this::class.java.simpleName, message)