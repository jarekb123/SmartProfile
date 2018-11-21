package com.butajlo.smartprofile.rx.task

import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.SingleEmitter

class SingleEmitterSuccessListener<T>(private val emitter: SingleEmitter<T>) : OnSuccessListener<T> {
    override fun onSuccess(result: T) {
        emitter.onSuccess(result)
    }
}