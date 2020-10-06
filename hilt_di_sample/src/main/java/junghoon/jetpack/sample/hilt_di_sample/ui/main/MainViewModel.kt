package junghoon.jetpack.sample.hilt_di_sample.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import junghoon.jetpack.sample.hilt_di_sample.data.MyRepository

class MainViewModel  @ViewModelInject constructor(
    private val repository: MyRepository
): ViewModel() {

    fun getRepositoryHash() = repository.toString()
}