package com.example.basic

import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.animal_list_item.view.*
import java.util.*
import kotlin.collections.ArrayList

//using abstract class, function = rv item click event value pass
 abstract class AnimalAdapter(var items: ArrayList<Animals>, val context: Context) : RecyclerView.Adapter<AnimalAdapter.Myholde>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AnimalAdapter.Myholde {
        return Myholde(LayoutInflater.from(context).
            inflate(R.layout.animal_list_item, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AnimalAdapter.Myholde, position: Int) {
        //holder.tv.text = items.get(position)
        var a = items.get(position)
        holder.tvName.text = a.name
        holder.tvLeg.text = a.leg.toString()

        holder.itemView.setOnClickListener(
            {
                onItemClick(a)
            }
        )
    }

     class Myholde(itemView: View) : ViewHolder(itemView)
    {
        var tvName = itemView.tv_animal_type
        var tvLeg = itemView.tvLeg
    }

     abstract fun onItemClick(itm : Animals)
}


