package com.fishing.paging_sample_app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchRepositoriesViewModel : ViewModel() {

    private val queryLiveData = MutableLiveData<String>()

    fun searchRepo(queryString: String) {
        queryLiveData.postValue(queryString)
    }
}