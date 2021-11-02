package com.example.pnufest.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pnufest.Adapter.MultiViewTypeAdapter
import com.example.pnufest.Fragment.DataListFragmentArgs.Companion.fromBundle
import com.example.pnufest.R


class DataListFragment : Fragment(){
    lateinit var recycler_view : RecyclerView

    val board by lazy {
        fromBundle(requireArguments()).board
    }
    val board_model by lazy {
        fromBundle(requireArguments()).boardData
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_data,container,false)

        var list = board_model.result_list
        val text_view = rootView.findViewById(R.id.board_title) as TextView
        text_view.setText(board.text)


        recycler_view = rootView.findViewById(R.id.board_list_recycler_view) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(rootView.context, RecyclerView.VERTICAL, false)
        recycler_view.adapter = MultiViewTypeAdapter(list)

        return rootView
    }

}