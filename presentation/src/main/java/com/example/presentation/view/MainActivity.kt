package com.example.presentation.view

import android.widget.Toast
import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()
    private var mBackWait:Long = 0

    override fun init() {
    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - mBackWait >=2000 ) {
            mBackWait = System.currentTimeMillis()
            Toast.makeText(this, "두 번 누를 시 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
            finish() //액티비티 종료
        }
    }
}