package junghoon.jetpack.sample.mask_app_java.adapter;

import android.graphics.Color;
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

        String remainStat = "충분";
        String count = "100개 이상";
        int color = Color.GREEN;
        switch (store.getRemainStat()) {
            case "plenty" :
                count = "100개 이상";
                remainStat = "충분";
                color = Color.GREEN;
                break;
            case "some" :
                count = "30개 이상";
                remainStat = "여유";
                color = Color.YELLOW;
                break;
            case "few" :
                count = "2개 이상";
                remainStat = "매진 임박";
                color = Color.RED;
                break;
            case "empty" :
                count = "재고 없음";
                remainStat = "매진";
                color = Color.GRAY;
                break;
        }
        holder.mCountTextView.setText(count);
        holder.mRemainTextView.setText(remainStat);
        holder.mRemainTextView.setTextColor(color);
        holder.mCountTextView.setTextColor(color);
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
