package com.example.pijetin.data.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pijetin.data.model.RiwayatItemModel
import com.example.pijetin.databinding.HistoryListViewBinding
import com.example.pijetin.databinding.RecentListViewBinding

class RecentAdapter: RecyclerView.Adapter<RecentAdapter.ViewHolder>() {
    private  var itemListener: ((RiwayatItemModel) -> Unit)? = null
    private  val data: MutableList<RiwayatItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecentListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], itemListener)
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<RiwayatItemModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: RecentListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: RiwayatItemModel, listener: ((RiwayatItemModel) -> Unit)?){
            if(item.status == "Dijadwalkan") {
                binding.tvStatus.setTextColor(Color.parseColor("#358F80"))
            } else if(item.status == "Dibatalkan") {
                binding.tvStatus.setTextColor(Color.parseColor("#E21F30"))
            } else if(item.status == "Selesai") {
                binding.tvStatus.setTextColor(Color.parseColor("#85B804"))
            }
            with(binding){
                tvTittle.text = item.title
                tvStatus.text = item.status
                tvTherapist.text = item.terapis
            }
        }
    }
    fun setOnclickItem(listener: ((RiwayatItemModel) -> Unit)?){
        this.itemListener = listener
    }
}