package junghoon.jetpack.sample.counter_app_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getCountLiveData().observe(this, Observer {
            counter_text.text = "$it"
        })

        add_button.setOnClickListener {
            viewModel.increaseCount()
        }

        minus_button.setOnClickListener {
            viewModel.decreaseCount()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", viewModel.getCountLiveData().value!!)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.getCountLiveData().value = savedInstanceState.getInt("count")
    }
}
