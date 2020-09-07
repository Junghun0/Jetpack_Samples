package junghoon.jetpack.sample.app.room_library_samples

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo-db"
    ).build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    suspend fun insert(todo: Todo) {
        db.todoDao().insert(todo)
    }
}