package com.example.pnufest.Fragment

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pnufest.Adapter.MultiViewTypeAdapter
import com.example.pnufest.BoardList_model
import com.example.pnufest.MainActivity
import com.example.pnufest.Model
import com.example.pnufest.R
import kotlin.reflect.KProperty

class YoutubeFragment: Fragment() {

    lateinit var recycler_view : RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_youtube, container, false)

        var list = (activity as MainActivity).target_list
        var list2 = (activity as MainActivity).target_list2
        var list3 = (activity as MainActivity).target_list3

        recycler_view = rootView.findViewById(R.id.youtube_recycler_view1) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(rootView.context, RecyclerView.HORIZONTAL, false)
        recycler_view.adapter = MultiViewTypeAdapter(list)

        recycler_view = rootView.findViewById(R.id.youtube_recycler_view2) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(rootView.context, RecyclerView.HORIZONTAL, false)
        recycler_view.adapter = MultiViewTypeAdapter(list2)

        recycler_view = rootView.findViewById(R.id.youtube_recycler_view3) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(rootView.context, RecyclerView.HORIZONTAL, false)
        recycler_view.adapter = MultiViewTypeAdapter(list3)

        return rootView
    }
}

