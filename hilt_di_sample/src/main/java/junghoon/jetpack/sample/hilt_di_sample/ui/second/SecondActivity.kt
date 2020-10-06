package junghoon.jetpack.sample.hilt_di_sample.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import junghoon.jetpack.sample.hilt_di_sample.R
import junghoon.jetpack.sample.hilt_di_sample.data.MyRepository
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: MyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity","repository hashcode ${repository.hashCode()}")
    }
}