package com.fishing.paging_sample_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fishing.paging_sample_app.ui.SearchRepositoriesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: SearchRepositoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
    }
}