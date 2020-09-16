package junghoon.jetpack.sample.mask_app_java;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import junghoon.jetpack.sample.mask_app_java.adapter.StoreAdapter;
import junghoon.jetpack.sample.mask_app_java.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                performAction();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {

            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .check();

        performAction();
        viewModel.fetchStoreInfo();
    }

    @SuppressLint("MissingPermission")
    private void performAction() {
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        Log.d("Location","getLatitude: "+location.getLatitude());
                        Log.d("Location","getLongitude: "+location.getLongitude());
                        location.setLatitude(37.188078);
                        location.setLongitude(127.0430);
                        viewModel.location = location;
                        viewModel.fetchStoreInfo();
                    }
                });

        RecyclerView recyclerView = findViewById(R.id.store_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        StoreAdapter adapter = new StoreAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.getItemsLiveData().observe(this, stores -> {
            adapter.updateItems(stores);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("마스크 재고 있는 곳 : "+ stores.size());
            }
        });


        viewModel.isLoading.observe(this, aBoolean -> {
            if (aBoolean) {
                findViewById(R.id.progressBar2).setVisibility(View.VISIBLE);
            } else {
                findViewById(R.id.progressBar2).setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            viewModel.fetchStoreInfo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
