package com.example.pijetin.data.adapter

import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pijetin.R
import com.example.pijetin.data.model.AlamatItemModel
import com.example.pijetin.data.model.RiwayatItemModel
import com.example.pijetin.databinding.AlamatRadioGroupBinding
import com.example.pijetin.databinding.HistoryListViewBinding

class AlamatAdapter: RecyclerView.Adapter<AlamatAdapter.ViewHolder>() {
    private var itemListener: ((AlamatItemModel) -> Unit)? = null
    private val data: MutableList<AlamatItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AlamatRadioGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position], itemListener)
    }

    override fun getItemCount(): Int = data.size

    fun submitList(list: List<AlamatItemModel>) {
        val initSize = itemCount
        data.clear()
        notifyItemRangeRemoved(0, initSize)
        data.addAll(list)
        notifyItemRangeInserted(0, data.size)
    }

    inner class ViewHolder(private val binding: AlamatRadioGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(item: AlamatItemModel, listener: ((AlamatItemModel) -> Unit)?) {
//            when (item.status) {
//                "Dijadwalkan" -> {
//                    binding.tvStatusHistory.setTextColor(Color.parseColor("#358F80"))
//                }
//
//                "Dibatalkan" -> {
//                    binding.tvStatusHistory.setTextColor(Color.parseColor("#E21F30"))
//                }
//
//                "Selesai" -> {
//                    binding.tvStatusHistory.setTextColor(Color.parseColor("#85B804"))
//                }
//            }
            binding.root.setOnClickListener {
                listener?.invoke(item)
            }
            with(binding) {
                tvJudulAlamat.text = item.judul
                tvDetilAlamat.text = item.alamat
            }
        }
    }

    fun setOnclickItem(listener: ((AlamatItemModel) -> Unit)?) {
        this.itemListener = listener
    }
}
//    private val context: Context
//    private val arrayList: ArrayList<AlamatItemModel>
//    private var isNewRadioButtonChecked = false
//    private var lastCheckedPosition = -1
//
//
//    init {
//        this.context = context
//        this.arrayList = arrayList
//    }
//
//    override fun onCreateViewHolder (
//        parent: ViewGroup,
//        viewType: Int
//        ): ViewHolder {
//            val layoutInflater = LayoutInflater.from(parent.context)
//            val view = layoutInflater.inflate(R.layout.alamat_radio_group, parent, false)
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            val AlamatItemModel = arrayList[position]
//            holder.itemView.textView.text = AlamatItemModel.name
//
//            if(isNewRadioButtonChecked) {
//                holder.itemView.radioButton.isChecked = AlamatItemModel.isSelected
//            } else {
//                if(holder.adapterPosition == 0) {
//                    holder.itemView.radioButton.isChecked = true
//                    lastCheckedPosition = 0
//                }
//            }
//        }
//
//    override fun getItemCount(): Int {
//        return arrayList.size
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//        init {
//            itemView.radioButton.setOnClickListener { handleRadioButtonChecks(adapterPosition)}
//        }
//    }
//    private fun handleRadioButtonChecks(adapterPosition: Int){
//        isNewRadioButtonChecked = true
//        arrayList[lastCheckedPosition].isSelected = false
//        arrayList[adapterPosition].isSelected = true
//        lastCheckedPosition = adapterPosition
//        notifyDataSetChanged()
//    }
//}
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = items[position]
//        holder.titleTextView.text = item.title
//
//        // Set a tag on the RadioGroup to keep track of the position
//        holder.radioGroup.tag = position
//
//        // Set a listener to capture the selected radio button
//        holder.radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            val itemPosition = group.tag as Int
//            val selectedItem = when (checkedId) {
//                R.id.option1RadioButton -> "Option 1"
//                R.id.option2RadioButton -> "Option 2"
//                // Handle other radio button options as needed
//                else -> ""
//            }
//
//            // Do something with the selected item
//            // Example: items[itemPosition].selectedItem = selectedItem
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
//        val radioGroup: RadioGroup = itemView.findViewById(R.id.radioGroup)
//    }
//}