package com.voidx.jsonplaceholder.feature.post.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voidx.jsonplaceholder.databinding.CommentItemBinding
import com.voidx.jsonplaceholder.feature.post.model.CommentDTO
import com.voidx.jsonplaceholder.view.widget.recyclerview.binding.BindableViewHolder
import com.voidx.jsonplaceholder.view.widget.recyclerview.binding.RecyclerViewBinding

class CommentAdapter : RecyclerView.Adapter<BindableViewHolder<CommentItemBinding>>(),
    RecyclerViewBinding.BindableAdapter<List<CommentDTO>> {

    private var items: List<CommentDTO> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindableViewHolder<CommentItemBinding> {
        val binding =
            CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BindableViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BindableViewHolder<CommentItemBinding>, position: Int) {
        holder.viewDataBinding.comment = items.elementAtOrNull(position)
    }

    override fun setData(data: List<CommentDTO>?) {
        items = data ?: emptyList()
        notifyDataSetChanged()
    }
}