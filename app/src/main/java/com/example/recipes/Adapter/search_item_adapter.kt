package com.example.recipes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.recipes.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.EachSearchItemBinding
import com.example.recipes.model.Recipe
import com.squareup.picasso.Picasso

class search_item_adapter(private val context: Context) : RecyclerView.Adapter<search_item_adapter.search_item_viewholder>() {

    lateinit var mylistener : setOnRecipeclicklistener

    interface setOnRecipeclicklistener{
        fun seteachRecipe(position: Int)
    }

    fun setOnRecipeclicklistener(listener: setOnRecipeclicklistener){
        mylistener = listener
    }

    val allrecipes = ArrayList<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): search_item_adapter.search_item_viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_search_item,parent,false)
        return search_item_viewholder(view,mylistener)
    }

    override fun onBindViewHolder(holder: search_item_adapter.search_item_viewholder, position: Int) {
        val current = allrecipes[position]
        holder.name.text = current.name
        Picasso.get().load(current.image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return allrecipes.size
    }

    class search_item_viewholder(itemView: View,listener: setOnRecipeclicklistener) : RecyclerView.ViewHolder(itemView) {

        val image = EachSearchItemBinding.bind(itemView).itemimage
        val name = EachSearchItemBinding.bind(itemView).itemname

        init {
            itemView.setOnClickListener{
                listener.seteachRecipe(adapterPosition)
            }
        }

    }
}