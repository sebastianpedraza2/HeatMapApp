package com.example.pruebatecnicasebastianpedraza.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnicasebastianpedraza.core.BaseViewHolder
import com.example.pruebatecnicasebastianpedraza.databinding.AttributeRvItemBinding

//RecyclerView that uses the list of attributes and sets an OnclickListener for each item
class HomeAttributesAdapter(
    private val attributesList: List<String>,
    private val onAttributeClickListener: OnAttributeClickListener,
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    interface OnAttributeClickListener {
        fun onAttributeClick(item: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = AttributeRvItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val data = attributesList[position]
        when (holder) {
            is PostViewHolder -> holder.bind(data)
        }
        holder.itemView.setOnClickListener {
            onAttributeClickListener.onAttributeClick(data)
        }
    }

    override fun getItemCount(): Int = attributesList.size

    private inner class PostViewHolder(
        val binding: AttributeRvItemBinding,
    ) : BaseViewHolder<String>(binding.root) {
        override fun bind(item: String) {
            binding.attributeName.text = item
        }

    }

}