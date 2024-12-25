package com.example.recipes.Adapter

import android.view.LayoutInflater
import android.view.View
import com.example.recipes.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.EachCategoryItemBinding
import com.example.recipes.model.Recipe
import com.squareup.picasso.Picasso

class category_adapter(private val list : ArrayList<Recipe>) : RecyclerView.Adapter<category_adapter.categoryViewholder>() {

     lateinit var mylistener : clickOncategory

    interface clickOncategory{
        fun oncategoryclick(position: Int)
    }

    fun setoncategoryclicklistener(listener: clickOncategory){
        mylistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): category_adapter.categoryViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_category_item, parent, false)
        return categoryViewholder(view,mylistener)
    }

    override fun onBindViewHolder(holder: category_adapter.categoryViewholder, position: Int) {
        val current = list[position]
        holder.name.text = current.name
        holder.time.text =  current.prepTimeMinutes.toString()+" min "
        Picasso.get().load(current.image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class categoryViewholder(itemView: View,listener: clickOncategory) : RecyclerView.ViewHolder(itemView) {
        val image = EachCategoryItemBinding.bind(itemView).catagoryitemimage
        val name = EachCategoryItemBinding.bind(itemView).categoryitemname
        val time = EachCategoryItemBinding.bind(itemView).categoryitemtime

        init {
            itemView.setOnClickListener{
                listener.oncategoryclick(adapterPosition)
            }
        }

    }

}