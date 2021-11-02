package com.example.pnufest.Adapter

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pnufest.BoardList_model
import com.example.pnufest.Fragment.HomeFragmentDirections
import com.example.pnufest.Model
import com.example.pnufest.R


class MultiViewTypeAdapter(private val list: MutableList<Model>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var totalTypes = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            Model.SUMNAIL_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.sumnail_type, parent, false)
                SumnailTypeViewHolder(view)
            }
            Model.BOARD_LIST_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.board_list_type, parent, false)
                BoardListTypeViewHolder(view)
            }
            Model.YOUTUBE_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.youtube_type, parent, false)
                YoutubeTypeViewHolder(view)
            }

            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun getItemCount(): Int {
        return totalTypes
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("MultiViewTypeAdapter", "Hi, onBindViewHolder")
        val obj = list[position]
        when (obj.type) {
            Model.SUMNAIL_TYPE -> {
                (holder as SumnailTypeViewHolder).txtType.text = obj.text
                holder.image.setImageResource(obj.data)
                var target = BoardList_model(obj.board_type!!)
                holder.itemView.setOnClickListener {
                    val direction =
                        HomeFragmentDirections.actionHomeFragmentToDataListFragment(obj, target)
                    holder.itemView.findNavController().navigate(direction)
                    }
            }
            Model.BOARD_LIST_TYPE -> {
                (holder as BoardListTypeViewHolder).listtitle.text = obj.text
                holder.date.text = obj.date
                holder.itemView.setOnClickListener {
                    //눌렀을때 해당 url 사이트로
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse(obj.url))
                    startActivity(holder.itemView.context,intent,null)
                }
            }
            Model.YOUTUBE_TYPE -> {
                (holder as YoutubeTypeViewHolder).txtType.text = obj.text

                // url 받아서 youtube image 받아오는거 새로 정의 해야됨!!
                val url_id = obj.url!!.substring(obj.url!!.lastIndexOf("/")+1)
                val image_url = "https://img.youtube.com/vi/"+ url_id+ "/" + "default.jpg"
                Glide.with(holder.itemView.context).load(image_url).into(holder.image)
                holder.itemView.setOnClickListener {
                    //눌렀을때 해당 url 사이트로
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse(obj.url))
                    startActivity(holder.itemView.context,intent,null)
                }
            }
        }
    }

    // 여기서 받는 position은 데이터의 index다.
    override fun getItemViewType(position: Int): Int {
        Log.d("MultiViewTypeAdapter", "Hi, getItemViewType")
        return list[position].type
    }

    inner class SumnailTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.sumnail_name)
        val image: ImageView = itemView.findViewById(R.id.sumnail_image)
    }

    inner class BoardListTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listtitle: TextView = itemView.findViewById(R.id.board_name)
        val date: TextView = itemView.findViewById(R.id.board_date)
    }

    inner class YoutubeTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtType: TextView = itemView.findViewById(R.id.youtube_name)
        val image: ImageView = itemView.findViewById(R.id.youtube_image)
    }
}

