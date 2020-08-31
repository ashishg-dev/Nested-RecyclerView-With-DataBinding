package com.devashish.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devashish.nestedrecyclerview.R
import com.devashish.nestedrecyclerview.databinding.LsvTeamBinding
import com.devashish.nestedrecyclerview.model.TeamModel

class TeamAdapter(private val data: List<TeamModel>) :
    RecyclerView.Adapter<TeamAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val dataBinding: LsvTeamBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(item: TeamModel, playerAdapter: PlayerAdapter) {
            dataBinding.playerAdapter = playerAdapter
            dataBinding.teamDetails = item
            dataBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: LsvTeamBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.lsv_team, parent, false
        )

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position], PlayerAdapter(data[position].players))
    }

    override fun getItemCount(): Int {
        return data.size
    }

}