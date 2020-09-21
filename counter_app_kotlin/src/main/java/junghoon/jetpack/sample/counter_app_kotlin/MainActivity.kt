package junghoon.jetpack.sample.counter_app_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        add_button.setOnClickListener {
            count++
            counter_text.text = "$count"
        }

        minus_button.setOnClickListener {
            count--
            counter_text.text = "$count"
        }
    }
}
