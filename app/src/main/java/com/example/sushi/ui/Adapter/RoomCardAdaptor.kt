package com.example.sushi.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sushi.databinding.RoomCardBinding
import com.example.sushi.model.CardRoomData

class RoomCardAdaptor: ListAdapter<CardRoomData, RoomCardAdaptor.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RoomCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            textView.text = data.roomName
        }
    }

    class ViewHolder(var binding: RoomCardBinding): RecyclerView.ViewHolder(binding.root)

    class DiffCallback : DiffUtil.ItemCallback<CardRoomData>() {
        override fun areItemsTheSame(oldItem: CardRoomData, newItem: CardRoomData): Boolean {
            return oldItem.roomId == newItem.roomId
        }

        override fun areContentsTheSame(oldItem: CardRoomData, newItem: CardRoomData): Boolean {
            return oldItem == newItem
        }

    }

}