package com.example.testdogs.core.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testdogs.databinding.ItemDogBinding
import com.example.testdogs.domain.model.DogList
import com.example.testdogs.utils.DEFAULT_BREED
import com.example.testdogs.utils.getListByBreed

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.DogViewHolder>() {
    var listDog:List<String> = listOf()

    fun setDogList(dog: DogList){
        listDog = getListByBreed(DEFAULT_BREED, dog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val itemDog = listDog[position]
        holder.bind(itemDog)
    }

    override fun getItemCount(): Int= listDog.size


    class DogViewHolder(val binding: ItemDogBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(itemDog:String){
            val imgUri =itemDog.toUri().buildUpon().scheme("https").build()
            Glide.with(binding.root)
                .load(imgUri)
                .apply(RequestOptions())
                .into(binding.dogImage)
            binding.executePendingBindings()
        }
    }
}