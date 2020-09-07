package junghoon.jetpack.sample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
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
        setContentView(R.layout.activity_main)

        //Room DB의 값을 observe 하면서 변경이 있을 때마다 화면 갱신
        viewModel.getAll().observe(this, Observer {
            result_textview.text = it.toString()
        })

        todo_button.setOnClickListener {
            //백그라운드 스레드로 동작시킴 .allowMainThreadQueries() 제거
            lifecycleScope.launch(Dispatchers.IO) {
                //viewModel 안에서 insert() 앞에 suspend 키워드를 붙여 코루틴 스코프안에서만 동작하도록 설정
                viewModel.insert(
                    Todo(
                        todo_edittext.text.toString()
                    )
                )
            }
        }
    }
}