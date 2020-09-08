package junghoon.jetpack.sample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import junghoon.jetpack.sample.app.databinding.ActivityMainBinding
import junghoon.jetpack.sample.app.room_library_samples.MainViewModel
import junghoon.jetpack.sample.app.room_library_samples.Todo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    /**
     * version 확인 [ activity-ktx / fragment-ktx ] 추가
     * java 1.8 target 명시 + kotlinOptions 추가
     * */
    // val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
    // private val viewModel by viewModels<MainViewModel>()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}