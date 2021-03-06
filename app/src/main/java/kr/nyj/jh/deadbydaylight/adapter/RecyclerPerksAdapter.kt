package kr.nyj.jh.deadbydaylight.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.nyj.jh.deadbydaylight.R
import kr.nyj.jh.deadbydaylight.model.Perks
import kr.nyj.jh.deadbydaylight.model.Survivors

class RecyclerPerksAdapter(private val list: ArrayList<Perks>) : RecyclerView.Adapter<RecyclerPerksAdapter.RecycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val resourceId = R.layout.recycler_item
        val view = inflater.inflate(resourceId, parent, false)
        return RecycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val perks = list[position]

        holder.tvName.text = perks.name
        Glide.with(holder.itemView).load(perks.icon).into(holder.imgIcon)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class RecycleViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val imgIcon: ImageView = view.findViewById(R.id.img_icon)
    }
}