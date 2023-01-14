package com.minjae.highthon.core.modifier

internal inline fun <T> T.runIf(condition: Boolean, run: T.() -> T) = if (condition) {
    run()
} else this
