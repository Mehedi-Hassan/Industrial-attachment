
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.model.Color

import com.google.android.material.card.MaterialCardView

class ColorListAdapter(val colorList: List<Color>, val listener: OnItemClickListener) : RecyclerView.Adapter<ColorListAdapter.viewHolder>() {
    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.colorname)

        val color: MaterialCardView = view.findViewById(R.id.white)
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
        holder.color.setBackgroundColor(android.graphics.Color.parseColor(currentData.color))
        holder.itemView.setOnClickListener { listener.onItemClicked(currentData) }
    }

    override fun getItemCount(): Int {
        return colorList.size
    }
}

