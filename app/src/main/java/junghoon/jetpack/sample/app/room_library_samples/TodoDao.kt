package junghoon.jetpack.sample.app.room_library_samples

import androidx.lifecycle.LiveData
import androidx.room.*
import junghoon.jetpack.sample.app.room_library_samples.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}