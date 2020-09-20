package junghoon.jetpack.sample.mask_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import junghoon.jetpack.sample.mask_app.model.Store
import junghoon.jetpack.sample.mask_app.repository.MaskService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Store>>()
    val isLoading = MutableLiveData<Boolean>()

    private var service: MaskService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        service = retrofit.create(MaskService::class.java)
        fetchStoreInfo()
    }

    private fun fetchStoreInfo() {
        isLoading.value = true

        viewModelScope.launch {
            val storeInfo = service.fetchStoreInfo(381.23,123.223)
            itemLiveData.value = storeInfo.stores
            isLoading.value = false
        }
    }

}