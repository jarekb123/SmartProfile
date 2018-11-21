package com.butajlo.smartprofile.rx.task

import com.nhaarman.mockitokotlin2.*
import io.reactivex.SingleEmitter
import org.junit.Test

class SingleEmitterSuccessListenerTest {

    val emitter = mock<SingleEmitter<Any>>()

    val listener = SingleEmitterSuccessListener(emitter)

    @Test
    fun onSuccess_ShouldCallOnSuccess() {
        listener.onSuccess(RESULT)

        verify(emitter).onSuccess(RESULT)
        then(emitter).should(never()).onError(any())
    }

    companion object {
        private const val RESULT = "RESULT"
    }

}