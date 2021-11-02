package com.example.pnufest

import android.content.ContentValues
import android.os.Parcelable
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.parcelize.Parcelize

@Parcelize
data class BoardList_model(var board_type : String) : Parcelable  {

    var ref1 = FirebaseDatabase.getInstance().getReference()
    var board_list = mutableListOf<Model>(Model(Model.BOARD_LIST_TYPE,"init",0,null,null,null))
    var youtube_list = mutableListOf<Model>(Model(Model.YOUTUBE_TYPE,"init",0,null,null,null))
    fun get_Data(board_type : String): MutableList<Model> {
        board_list.remove(board_list[0])
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                if(!board_type.equals("")) {
                    for (d in dataSnapshot.children) {
                        for (a in d.children) {
                            if (a.key.equals("num") && a.value!!.equals(board_type)) {
                                var rate = d.child("rate").value
                                var title = d.child("title").value
                                var link = d.child("link").value
                                board_list.add(Model(Model.BOARD_LIST_TYPE, title as String, 0, rate as String, board_type, link as String))
                            }
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        ref1.child("board").addValueEventListener(postListener)
        return board_list
    }

    fun get_Youtube_Data(youtube_board_type : String): MutableList<Model> {
        youtube_list.clear()
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                for (d in dataSnapshot.children) {
                    for (a in d.children) {
                        if (a.key.equals("num") && a.value!!.equals(youtube_board_type)) {
                            var title = d.child("title").value
                            var url = d.child("url").value
                            youtube_list.add(Model(Model.YOUTUBE_TYPE, title as String, 0, null, youtube_board_type, url as String))
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }

        ref1.child("youtube").addValueEventListener(postListener)
        return youtube_list
    }

    var result_list = get_Data(board_type)

}