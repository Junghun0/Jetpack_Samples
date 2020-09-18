package junghoon.jetpack.sample.mask_app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import junghoon.jetpack.sample.mask_app.R
import junghoon.jetpack.sample.mask_app.model.Store
import java.util.*

class StoreAdapter : RecyclerView.Adapter<StoreViewHolder>() {
    private var mItems: List<Store> =
        ArrayList<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.store_item, parent, false)
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val store: Store = mItems[position]
        holder.mStoreNameTextView.text = store.name
        holder.mAddressTextView.text = store.addr
        var remainStat = "충분"
        var count = "100개 이상"
        var color = Color.GREEN
        when (store.remain_stat) {
            "plenty" -> {
                count = "100개 이상"
                remainStat = "충분"
                color = Color.GREEN
            }
            "some" -> {
                count = "30개 이상"
                remainStat = "여유"
                color = Color.YELLOW
            }
            "few" -> {
                count = "2개 이상"
                remainStat = "매진 임박"
                color = Color.RED
            }
            "empty" -> {
                count = "재고 없음"
                remainStat = "매진"
                color = Color.GRAY
            }
        }
        holder.mCountTextView.text = count
        holder.mRemainTextView.text = remainStat
        holder.mRemainTextView.setTextColor(color)
        holder.mCountTextView.setTextColor(color)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateItems(items: List<Store>) {
        mItems = items
        notifyDataSetChanged()
    }
}


class StoreViewHolder(itemView: View) : ViewHolder(itemView) {
    var mStoreNameTextView: TextView
    var mAddressTextView: TextView
    var mDistanceTextView: TextView
    var mRemainTextView: TextView
    var mCountTextView: TextView

    init {
        mStoreNameTextView = itemView.findViewById(R.id.name_textview)
        mAddressTextView = itemView.findViewById(R.id.addr_textview)
        mDistanceTextView = itemView.findViewById(R.id.distance_textview)
        mRemainTextView = itemView.findViewById(R.id.remain_textview)
        mCountTextView = itemView.findViewById(R.id.count_textview)
    }
}
