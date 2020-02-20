package com.example.basic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import kotlinx.android.synthetic.main.animal_list_item.view.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast

//using interface = rv item click event value pass
class AnimalAdapter2(var items: ArrayList<Animals>, val context: Context, val listener:OnItemClickListener ) : RecyclerView.Adapter<AnimalAdapter2.Myholde>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AnimalAdapter2.Myholde {
        return Myholde(
            LayoutInflater.from(context).
                inflate(R.layout.animal_list_item, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AnimalAdapter2.Myholde, position: Int) {
        //holder.tv.text = items.get(position)
        var a = items.get(position)
        holder.tvName.text = a.name
        holder.tvLeg.text = a.leg.toString()

        holder.itemView.setOnClickListener{
            listener.onItemClicked2(a)

        }

    }


    class Myholde(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var tvName = itemView.tv_animal_type
        var tvLeg = itemView.tvLeg


    }

    interface OnItemClickListener
    {
        fun onItemClicked2(itm:Animals)
    }

}


