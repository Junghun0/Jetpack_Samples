package com.study.workmanager_sample

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.work.*
import java.util.concurrent.TimeUnit

class LifecycleObserver(var context: Context, var startTime: Long) : LifecycleObserver {
    private val saveRequest = lazy {
            OneTimeWorkRequestBuilder<BackGroundWorker>()
                .setInputData(workData)
                .build()
    }
    private var workData: Data = workDataOf("startTime" to startTime)

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun startBackgroundWork() {
        Log.i("jhjh"," onPause() Event")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun endBackgroundWork() {
        Log.i("jhjh"," onResume() Event")
    }

}