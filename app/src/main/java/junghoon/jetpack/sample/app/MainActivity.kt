package junghoon.jetpack.sample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
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

        result_textview.text = db.todoDao().getAll().toString()

        todo_button.setOnClickListener {
            db.todoDao().insert(Todo(todo_edittext.text.toString()))
            result_textview.text = db.todoDao().getAll().toString()
        }
    }
}