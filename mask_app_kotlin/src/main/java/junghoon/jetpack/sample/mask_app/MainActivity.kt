package junghoon.jetpack.sample.mask_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import junghoon.jetpack.sample.mask_app.adapter.StoreAdapter
import junghoon.jetpack.sample.mask_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
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

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                adapter.updateItems(it)
            })

            isLoading.observe(this@MainActivity, Observer {
                progressBar2.visibility = if (it) View.VISIBLE else View.GONE
            })
        }
    }
}
