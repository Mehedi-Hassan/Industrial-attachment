package com.example.ia.model

import android.content.res.ColorStateList
import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ia.R

class ColorListAdapter(val colorList: List<Color>, val listener: OnItemClickListener) : RecyclerView.Adapter<ColorListAdapter.viewHolder>() {
    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.colorname)

        val color: CardView = view.findViewById(R.id.white)
    }
    interface OnItemClickListener {
        fun onItemClicked(color: Color)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.colorlist, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentData = colorList[position]
        holder.name.text = currentData.name
        //holder.color.setCardBackgroundColor(Color.parseColor("#ffffff"))
        holder.itemView.setOnClickListener { listener.onItemClicked(currentData) }
    }

    override fun getItemCount(): Int {
        return colorList.size
    }
}

