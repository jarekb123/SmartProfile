package com.butajlo.smartprofile.common

import android.os.Build
import java.lang.reflect.Field
import java.lang.reflect.Modifier


fun stubFinalStatic(field: Field, newValue: Any) {
    field.isAccessible = true

    val modifiersField = Field::class.java.getDeclaredField("modifiers")
    modifiersField.isAccessible = true
    modifiersField.setInt(field, field.modifiers and Modifier.FINAL.inv())

    field.set(null, newValue)
}

fun stubBuildSdkVersion(sdkVersion: Int) {
    stubFinalStatic(Build.VERSION::class.java.getField("SDK_INT"), sdkVersion)
}