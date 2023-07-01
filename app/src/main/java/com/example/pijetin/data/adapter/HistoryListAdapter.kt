package com.example.pijetin.data.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.pijetin.data.model.RiwayatItemModel
import com.example.pijetin.databinding.HistoryListViewBinding

class HistoryListAdapter: RecyclerView.Adapter<HistoryListAdapter.ViewHolder>()
{
    private  var itemListener: ((RiwayatItemModel) -> Unit)? = null
    private  val data: MutableList<RiwayatItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HistoryListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class ViewHolder(private val binding: HistoryListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: RiwayatItemModel, listener: ((RiwayatItemModel) -> Unit)?){
            if(item.status == "Dijadwalkan") {
                binding.tvStatusHistory.setTextColor(Color.parseColor("#358F80"))
            } else if(item.status == "Dibatalkan") {
                binding.tvStatusHistory.setTextColor(Color.parseColor("#E21F30"))
            } else if(item.status == "Selesai") {
                binding.tvStatusHistory.setTextColor(Color.parseColor("#85B804"))
            }
            with(binding){
                tvIdPesananHistory.text = "Id pesanan : ${item.id}"
                tvPaketHistory.text = item.title
                tvDateHistory.text = item.date
                tvStatusHistory.text = item.status
                tvTerapisHistory.text = item.terapis
                root.setOnClickListener {
                    listener?.invoke(item)
                }
            }
        }
    }
    fun setOnclickItem(listener: ((RiwayatItemModel) -> Unit)?){
        this.itemListener = listener
    }
}