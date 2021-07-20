package com.study.workmanager_sample

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class LifecycleListener(var activityLifecycle: Lifecycle): LifecycleOwner{
    
    override fun getLifecycle(): Lifecycle {
        return activityLifecycle
    }

}