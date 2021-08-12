package com.example.myapp4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DataAdapter(private var dataList:List<DataModel>,private val context: Context):RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        holder.titleTextView.text = dataModel.title

        Picasso
            .get()
            .load(dataModel.thumbnailUrl)
            .into(holder.imageView)
    }

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var titleTextView: TextView
        lateinit var imageView: ImageView

        init {

            titleTextView = itemView.findViewById(R.id.textView)
            imageView = itemView.findViewById(R.id.imageView)

        }
    }
}
