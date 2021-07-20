package com.study.workmanager_sample

import android.content.Context
import android.util.Log
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters

class BackGroundWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val curTime = System.currentTimeMillis()
        Log.e("jhjh"," WorkManager doWorking Now!!-- $curTime")
        return Result.success()
    }
}