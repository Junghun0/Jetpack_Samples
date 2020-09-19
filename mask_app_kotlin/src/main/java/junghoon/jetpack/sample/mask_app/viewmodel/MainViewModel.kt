package junghoon.jetpack.sample.mask_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import junghoon.jetpack.sample.mask_app.model.Store
import junghoon.jetpack.sample.mask_app.repository.MaskService
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
    }



}