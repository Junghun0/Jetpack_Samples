package junghoon.jetpack.sample.counter_app_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var count = 0
        set(value) {
            liveDataCount.value = value
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