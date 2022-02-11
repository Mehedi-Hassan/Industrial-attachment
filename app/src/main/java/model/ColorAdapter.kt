package model


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ia.R
import android.content.res.ColorStateList
import android.graphics.Color.parseColor

class ColorAdapter(val colorList: List<Color>) : RecyclerView.Adapter<ColorAdapter.viewHolder>() {
    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView = view.findViewById(R.id.id)
        val name: TextView = view.findViewById(R.id.name)
        val year: TextView = view.findViewById(R.id.year)

        val color: CardView = view.findViewById(R.id.color)
        val pantone_value: TextView = view.findViewById(R.id.value)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorAdapter.viewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.colordetails, parent, false)
        return viewHolder(view)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentData = colorList[position]
        holder.id.text = currentData.id.toString()
        holder.name.text = currentData.name
        holder.year.text = currentData.year.toString()
        holder.pantone_value.text = currentData.pantone_value
        holder.color.setCardBackgroundColor(0)
    }


    override fun getItemCount(): Int {
        return colorList.size
    }
}


