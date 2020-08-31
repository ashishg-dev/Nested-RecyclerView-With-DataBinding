package com.devashish.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devashish.nestedrecyclerview.R
import com.devashish.nestedrecyclerview.databinding.LsvPlayersBinding
import com.devashish.nestedrecyclerview.model.PlayersModel

class PlayerAdapter(private val data: List<PlayersModel>) :
    RecyclerView.Adapter<PlayerAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val dataBinding: LsvPlayersBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(item: PlayersModel) {
            dataBinding.playerDetails = item
            dataBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: LsvPlayersBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.lsv_players, parent, false
        )

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}