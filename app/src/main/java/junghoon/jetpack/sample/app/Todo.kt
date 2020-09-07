package junghoon.jetpack.sample.app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    var title: String
){
    //DB 의 AI
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}