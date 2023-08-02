package com.example.pijetin.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pijetin.data.model.ChatItemModel
import com.example.pijetin.databinding.ChatListViewBinding

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    private  var itemListener: ((ChatItemModel) -> Unit)? = null
    private  val data: MutableList<ChatItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ChatListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], itemListener)
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<ChatItemModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }
    inner class ViewHolder(private val binding: ChatListViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: ChatItemModel, listener: ((ChatItemModel) -> Unit)?){

            binding.root.setOnClickListener{
                listener?.invoke(item)
            }
            with(binding){
                Glide
                    .with(binding.root.context)
                    .load(item.fotopengguna)
                    .into(binding.imgPropil)
                tvNamaChat.text = item.namapengguna
                tvIsiChat.text = item.isichat
                tvWaktu.text = item.waktu
                //tvTerapisHistory.text = item.terapis
            }
        }
    }
}