package junghoon.jetpack.sample.mask_app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import junghoon.jetpack.sample.mask_app.R
import junghoon.jetpack.sample.mask_app.databinding.StoreItemBinding
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
        holder.binding.store = mItems[position]

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
    val binding = StoreItemBinding.bind(itemView)
}

@BindingAdapter("remainStat")
fun setRemainStat(textView: TextView, store: Store) = when (store.remain_stat) {
    "plenty" -> textView.text = "충분"
    "some" -> textView.text = "여유"
    "few" -> textView.text = "매진 임박"
    else -> textView.text = "재고 없음"
}

@BindingAdapter("count")
fun setCount(textView: TextView, store: Store) = when (store.remain_stat) {
    "plenty" -> textView.text = "100개 이상"
    "some" -> textView.text = "30개 이상"
    "few" -> textView.text = "2개 이상"
    else -> textView.text = "재고 없음"
}

@BindingAdapter("color")
fun setColor(textView: TextView, store: Store) = when (store.remain_stat) {
    "plenty" -> textView.setTextColor(Color.GREEN)
    "some" -> textView.setTextColor(Color.YELLOW)
    "few" -> textView.setTextColor(Color.RED)
    else -> textView.setTextColor(Color.GRAY)
}


