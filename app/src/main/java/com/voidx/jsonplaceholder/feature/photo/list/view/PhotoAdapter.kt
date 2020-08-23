package com.voidx.jsonplaceholder.feature.photo.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voidx.jsonplaceholder.databinding.PhotoItemBinding
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO
import com.voidx.jsonplaceholder.view.widget.recyclerview.binding.BindableViewHolder
import com.voidx.jsonplaceholder.view.widget.recyclerview.binding.RecyclerViewBinding

class PhotoAdapter : RecyclerView.Adapter<BindableViewHolder<PhotoItemBinding>>(),
    RecyclerViewBinding.BindableAdapter<List<PhotoDTO>> {

    private var items: MutableList<PhotoDTO> = mutableListOf()

    var onClick: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindableViewHolder<PhotoItemBinding> {
        val binding =
            PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BindableViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BindableViewHolder<PhotoItemBinding>, position: Int) {
        holder.viewDataBinding.photo = items[position]
        holder.onClick = onClick
    }

    override fun setData(data: List<PhotoDTO>?) {
        if (data.isNullOrEmpty()) {
            return
        }

        val startPosition = items.size
        items.addAll(data)

        notifyItemRangeInserted(startPosition, data.size)
    }
}