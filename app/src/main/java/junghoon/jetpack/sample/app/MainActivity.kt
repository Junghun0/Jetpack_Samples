package junghoon.jetpack.sample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import junghoon.jetpack.sample.app.room_library_samples.AppDatabase
import junghoon.jetpack.sample.app.room_library_samples.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "todo-db"
        )
            .allowMainThreadQueries()
            .build()

        //Room DB의 값을 observe 하면서 변경이 있을 때마다 화면 갱신
        db.todoDao().getAll().observe(this, Observer {
            result_textview.text = it.toString()
        })

        todo_button.setOnClickListener {
            db.todoDao().insert(
                Todo(
                    todo_edittext.text.toString()
                )
            )
        }
    }
}