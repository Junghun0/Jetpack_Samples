package com.study.workmanager_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity: AppCompatActivity() {
    private lateinit var saveRequest: PeriodicWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startWorkManagerBtn).setOnClickListener {
            WorkManager.getInstance(applicationContext).enqueue(saveRequest)
        }

        saveRequest =
            PeriodicWorkRequestBuilder<BackGroundWorker>(15, TimeUnit.MINUTES)
                .build()

        val comebackRequest = OneTimeWorkRequest.Builder(BackGroundWorker::class.java).build()
        val observer = LifecycleObserver()

        val lifecycleOwner = LifecycleListener(activityLifecycle = lifecycle)

        lifecycleOwner.lifecycle.addObserver(observer)

    }

    override fun onPause() {
        super.onPause()
//        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork("work",ExistingPeriodicWorkPolicy.KEEP , saveRequest)
        Log.d("jhjh"," onPause()")
    }



    override fun onStop() {
        super.onStop()
        Log.d("jhjh"," onStop()")
    }
}