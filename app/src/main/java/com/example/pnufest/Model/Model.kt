package com.example.pnufest

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Model(val type: Int = 0, var text: String, val data: Int = 0, var date:String?, var board_type: String?, var url:String?) : Parcelable {

    companion object {
        const val SUMNAIL_TYPE = 0
        const val BOARD_LIST_TYPE = 1
        const val YOUTUBE_TYPE = 2
    }

}