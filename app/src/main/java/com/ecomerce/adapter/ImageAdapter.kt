package com.ecomerce.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecomerce.R
import com.ecomerce.model.Image

class ImageAdapter(
        private val context: Context,
        private val images: List<Image>,
        private val listener: ((Image) -> Unit)? = null
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageSrc = view.findViewById<ImageView>(R.id.MiliaderIv)
        val title = view.findViewById<TextView>(R.id.NamaTv)
        val desc = view.findViewById<TextView>(R.id.HobiTv)
        val desc1 = view.findViewById<TextView>(R.id.KekayaanTv)

        fun bindView(image: Image, listener: ((Image) -> Unit)? = null) {
            imageSrc.setImageResource(image.imageSrc)
            title.text = image.imageId.toString()
            desc.text = image.imageDesc
            desc1.text = image.imageDesc1
            itemView.setOnClickListener {
                if (listener != null) {
                    listener(image)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main1, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        if (listener != null) {
            holder.bindView(images[position], listener)
        }else{
            holder.bindView(images[position])
        }
    }
}