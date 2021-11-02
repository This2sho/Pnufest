package com.example.pnufest.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pnufest.Model
import com.example.pnufest.Adapter.MultiViewTypeAdapter
import com.example.pnufest.R

class HomeFragment : Fragment(){
    lateinit var recycler_view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val list = mutableListOf<Model>().apply {
            add(Model(Model.SUMNAIL_TYPE, "학생 지원 시스템", R.drawable.student_support, null, "1", null))
            add(Model(Model.SUMNAIL_TYPE, "정보 컴퓨터 공학부", R.drawable.information_computer, null, "2", null))
        }

        recycler_view = rootView.findViewById(R.id.recycler_view1) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(rootView.context, RecyclerView.HORIZONTAL, false)
        recycler_view.adapter = MultiViewTypeAdapter(list)


        val list2 = mutableListOf<Model>().apply {
            add(Model(Model.SUMNAIL_TYPE, "채용 게시판", R.drawable.intern, null, "3", null))
            add(Model(Model.SUMNAIL_TYPE, "부산 정보 산업 진흥원", R.drawable.information_industry, null, "4", null))
        }

        recycler_view = rootView.findViewById(R.id.recycler_view2) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(rootView.context, RecyclerView.HORIZONTAL, false)
        recycler_view.adapter = MultiViewTypeAdapter(list2)
        return rootView
    }
}