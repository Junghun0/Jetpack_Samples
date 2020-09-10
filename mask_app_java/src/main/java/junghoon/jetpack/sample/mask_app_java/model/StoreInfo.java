package junghoon.jetpack.sample.mask_app_java.model;

import com.squareup.moshi.Json;

import java.util.List;

public class StoreInfo {
    @Json(name = "count")
    private int count;
    @Json(name = "stores")
    private List<Store> stores;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
