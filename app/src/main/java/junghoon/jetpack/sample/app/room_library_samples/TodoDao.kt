package junghoon.jetpack.sample.app.room_library_samples

import androidx.lifecycle.LiveData
import androidx.room.*
import junghoon.jetpack.sample.app.room_library_samples.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}