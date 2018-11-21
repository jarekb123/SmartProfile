package com.butajlo.smartprofile.rx.task

import com.google.android.gms.tasks.Task
import io.reactivex.Single

fun <R> Task<R>.toSingle(): Single<R> =
        Single.create {
            val successListener = SingleEmitterSuccessListener<R>(it)
            this.addOnSuccessListener(successListener)
        }