package junghoon.jetpack.sample.mask_app_java.viewmodel;

import android.location.Location;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import junghoon.jetpack.sample.mask_app_java.LocationDistance;
import junghoon.jetpack.sample.mask_app_java.model.Store;
import junghoon.jetpack.sample.mask_app_java.model.StoreInfo;
import junghoon.jetpack.sample.mask_app_java.repository.MaskService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainViewModel extends ViewModel {
    public static final String TAG = MainViewModel.class.getSimpleName();

    private MutableLiveData<List<Store>> itemsLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public Location location;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private MaskService service = retrofit.create(MaskService.class);

    public MainViewModel() {
        fetchStoreInfo();
    }

    public void fetchStoreInfo() {
        isLoading.setValue(true);
        service.fetchStoreInfo(location.getLatitude(), location.getLongitude()).enqueue(new Callback<StoreInfo>() {
            @Override
            public void onResponse(Call<StoreInfo> call, Response<StoreInfo> response) {

                List<Store> items = response.body().getStores()
                        .stream()
                        .filter(item -> item.getRemainStat() != null)
                        .filter(item -> !item.getRemainStat().equals("empty"))
                        .collect(Collectors.toList());

                for (Store store: items) {
                    double distance = LocationDistance.distance(location.getLatitude(), location.getLongitude(), store.getLat(), store.getLng(), "k");
                    store.setDistance(distance);
                }

                Collections.sort(items);
                itemsLiveData.postValue(items);
                isLoading.postValue(false);
            }

            @Override
            public void onFailure(Call<StoreInfo> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                itemsLiveData.setValue(Collections.emptyList());
                isLoading.postValue(false);
            }
        });
    }

    public MutableLiveData<List<Store>> getItemsLiveData() {
        return itemsLiveData;
    }

    public void setItemsLiveData(MutableLiveData<List<Store>> itemsLiveData) {
        this.itemsLiveData = itemsLiveData;
    }
}
