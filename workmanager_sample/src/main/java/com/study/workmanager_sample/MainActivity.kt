package com.study.workmanager_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity: AppCompatActivity() {
    private lateinit var saveRequest: PeriodicWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveRequest =
            PeriodicWorkRequestBuilder<BackGroundWorker>(5, TimeUnit.SECONDS)
                .build()

        val comebackRequest = OneTimeWorkRequest.Builder(BackGroundWorker::class.java).build()
    }

    override fun onPause() {
        super.onPause()
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork("work",ExistingPeriodicWorkPolicy.KEEP , saveRequest)
        Log.d("jhjh"," onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("jhjh"," onStop()")
    }
}