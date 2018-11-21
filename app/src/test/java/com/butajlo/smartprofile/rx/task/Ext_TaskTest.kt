package com.butajlo.smartprofile.rx.task

import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.then
import org.junit.Test

class Ext_TaskTest {

    private val task = mock<Task<Unit>>()

    @Test
    fun toSingle_ShouldCreateSingleTask() {
        val captor = argumentCaptor<OnSuccessListener<Unit>>()

        task.toSingle().subscribe()

        then(task).should().addOnSuccessListener(captor.capture())
        assert(captor.lastValue is SingleEmitterSuccessListener)
    }

}