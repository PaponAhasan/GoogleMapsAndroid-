package com.example.mapview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mapview.models.UserMaps

class MapsAdapter(private val userMaps: List<UserMaps>, private val onCLickListener: OnCLickListener):
    RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "MapsAdapter"
    }

    interface OnCLickListener{
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(userMap: UserMaps) {
            val text = itemView.findViewById<TextView>(android.R.id.text1)
            text.text = userMap.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener {
            onCLickListener.onItemClick(position)
        }
        holder.bind(userMap)
    }

    override fun getItemCount() = userMaps.size
}