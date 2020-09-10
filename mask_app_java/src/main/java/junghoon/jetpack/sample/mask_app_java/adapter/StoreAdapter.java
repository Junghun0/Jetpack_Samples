package junghoon.jetpack.sample.mask_app_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import junghoon.jetpack.sample.mask_app_java.R;
import junghoon.jetpack.sample.mask_app_java.model.Store;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    private List<Store> mItems = new ArrayList<>();
    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        Store store = mItems.get(position);
        holder.mStoreNameTextView.setText(store.getName());
        holder.mAddressTextView.setText(store.getAddr());
//        holder.mDistanceTextView.setText();
        holder.mRemainTextView.setText(store.getRemainStat());
        holder.mCountTextView.setText(store.getStockAt());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateItems(List<Store> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {
        TextView mStoreNameTextView;
        TextView mAddressTextView;
        TextView mDistanceTextView;
        TextView mRemainTextView;
        TextView mCountTextView;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            mStoreNameTextView = itemView.findViewById(R.id.name_textview);
            mAddressTextView = itemView.findViewById(R.id.addr_textview);
            mDistanceTextView = itemView.findViewById(R.id.distance_textview);
            mRemainTextView = itemView.findViewById(R.id.remain_textview);
            mCountTextView = itemView.findViewById(R.id.count_textview);
        }
    }
}
