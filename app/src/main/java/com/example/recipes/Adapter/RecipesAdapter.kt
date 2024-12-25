package com.example.recipes.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipes.R
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.EachRecipesItemBinding
import com.example.recipes.model.Recipe
import com.squareup.picasso.Picasso

class RecipesAdapter(val list: List<Recipe>) : RecyclerView.Adapter<RecipesAdapter.RecipesViewholder>() {

    lateinit var mylistener : setOnRecipeclicklistener

    interface setOnRecipeclicklistener{
        fun seteachRecipe(position: Int)
    }

    fun setOnRecipeclicklistener(listener: setOnRecipeclicklistener){
        mylistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesAdapter.RecipesViewholder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.each_recipes_item,parent,false)
        return RecipesViewholder(item,mylistener)
    }

    override fun onBindViewHolder(holder: RecipesAdapter.RecipesViewholder, position: Int) {
        val current = list[position]

        holder.name.text = current.name
        holder.time.text = current.cookTimeMinutes.toString()+" min "
        Picasso.get().load(current.image).into(holder.image)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class RecipesViewholder(itemView: View,listener: setOnRecipeclicklistener) : RecyclerView.ViewHolder(itemView) {
        val image = EachRecipesItemBinding.bind(itemView).itemImage
        val name = EachRecipesItemBinding.bind(itemView).itemName
        val time = EachRecipesItemBinding.bind(itemView).itemDuration

        init {
            itemView.setOnClickListener{
                listener.seteachRecipe(adapterPosition)
            }
        }

    }


}