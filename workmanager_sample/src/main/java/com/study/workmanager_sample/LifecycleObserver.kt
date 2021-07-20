package com.study.workmanager_sample

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LifecycleObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun startBackgroundWork() {
        Log.i("jhjh"," onPause() Event")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun endBackgroundWork() {
        Log.i("jhjh"," onResume() Event")
    }

}