package junghoon.jetpack.sample.app.room_library_samples

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}