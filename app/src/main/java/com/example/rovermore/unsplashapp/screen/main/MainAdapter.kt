package com.example.rovermore.unsplashapp.screen.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rovermore.unsplashapp.R
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_photo.view.*

class MainAdapter
    (var context: Context,
     var photoList: MutableList<PhotoFromList>?,
     var itemClicked: OnItemClicked
): RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    lateinit var currentPhoto: PhotoFromList

    interface OnItemClicked {
        fun itemClicked(photo: PhotoFromList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(photoList.isNullOrEmpty()){
            return 0
        }
        return photoList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(!photoList.isNullOrEmpty()) {
            holder.bindView(photoList!![position])
        }
    }

    inner class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener  {

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            itemClicked.itemClicked(currentPhoto)
        }

        fun bindView(selectedPhoto: PhotoFromList) {
            currentPhoto = selectedPhoto

            Picasso.with(context)
                .load(selectedPhoto.photoUrls.small)
                .fit().centerCrop()
                .into(view.chromeImageView)
        }
    }

    fun updateRepositoriesList(photoList: MutableList<PhotoFromList>?){
        this.photoList = photoList
        notifyDataSetChanged()
    }

    fun clearMainAdapter() {
        photoList?.run {
            photoList!!.clear()
            photoList = null
            notifyDataSetChanged()
        }
    }

}