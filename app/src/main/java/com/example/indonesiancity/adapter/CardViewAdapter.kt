package com.example.indonesiancity.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.indonesiancity.data.City
import com.example.indonesiancity.R
import com.example.indonesiancity.activity.DetailActivity


@Suppress("DEPRECATION")
class CardViewAdapter(private val listCity: ArrayList<City>) :
    RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_city, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val city = listCity[position]

        Glide.with(holder.itemView.context)
            .load(city.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = city.name
        holder.tvDetail.text = city.detail

        holder.iconFavorite.setOnClickListener {
            holder.iconFavorite.setImageResource(R.drawable.ic_favorite_click)
            Toast.makeText(
                holder.itemView.context,
                "Favorite " + listCity[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()

        }

        holder.iconShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share " + listCity[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
            val whatsappIntent = Intent(Intent.ACTION_SEND)
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.type = "text/plain"
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, listCity[holder.adapterPosition].name)
            holder.iconShare.context.startActivity(whatsappIntent)


//            val sharingIntent = Intent(Intent.ACTION_SEND)
//            sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
//            sharingIntent.type = "image/*"
//            sharingIntent.putExtra(Intent.EXTRA_STREAM, listCity[holder.absoluteAdapterPosition].photo)
//            holder.iconShare.context.startActivity(Intent.createChooser(sharingIntent, "Share Image Using"))
        }

        holder.itemView.setOnClickListener {
            val moveIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            moveIntent.putExtra("image_url", listCity[holder.adapterPosition].photo)
            moveIntent.putExtra("text_name", listCity[holder.adapterPosition].name)
            moveIntent.putExtra("text_detail", listCity[holder.adapterPosition].detail)
            holder.itemView.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int {
        return listCity.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var iconFavorite: ImageView = itemView.findViewById(R.id.ic_favorite)
        var iconShare: ImageView = itemView.findViewById(R.id.ic_share)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
    }


}