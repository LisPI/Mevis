package com.epam.android.swimmer.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.epam.android.swimmer.data.db.Cat
import com.epam.android.swimmer.databinding.HolderImageBinding

class ImageAdapter : ListAdapter<Cat, ImageAdapter.ImageHolder>(CatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderImageBinding.inflate(inflater, parent, false)
        return ImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(getItem(holder.adapterPosition))
    }

    class ImageHolder(
        private val binding: HolderImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Cat) {
            binding.imageView.load(item.url)
        }
    }

    class CatDiffCallback : DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }
}