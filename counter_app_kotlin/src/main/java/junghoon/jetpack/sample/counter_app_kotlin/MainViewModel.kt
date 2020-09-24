package junghoon.jetpack.sample.counter_app_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val handle: SavedStateHandle): ViewModel() {
    private var count = handle.get<Int>("count") ?: 0
        set(value) {
            liveDataCount.value = value
            handle.set("count", value)
            field = value
        }

    private var liveDataCount = MutableLiveData<Int>()

    fun increaseCount() {
        count++
    }

    fun decreaseCount() {
        count--
    }

    fun getCountLiveData() : MutableLiveData<Int> {
        return liveDataCount
    }
}