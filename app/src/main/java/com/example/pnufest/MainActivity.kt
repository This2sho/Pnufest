package com.example.pnufest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pnufest.Fragment.YoutubeFragment
import com.example.pnufest.databinding.ActivityMainBinding
import com.example.pnufest.R


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val target_list = BoardList_model("").get_Youtube_Data("공부 동기부여")
    val target_list2 = BoardList_model("").get_Youtube_Data("취업 팁")
    val target_list3 = BoardList_model("").get_Youtube_Data("코딩테스트")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initNavigation()

    }
    private fun initNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        binding.tlAcMainBottomMenu.setupWithNavController(navController)
        // 위와 같은 2번째 방법
//        NavigationUI.setupWithNavController(
//            main_bottom_navigation,
//            findNavController(R.id.main_nav_host)
//        )
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    companion object {
        const val TAG = "MainActivityTag"
    }



}