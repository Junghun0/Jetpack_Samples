package junghoon.jetpack.sample.mask_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import junghoon.jetpack.sample.mask_app.adapter.StoreAdapter
import junghoon.jetpack.sample.mask_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = StoreAdapter()
        store_recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            this.adapter = adapter
        }
    }
}
