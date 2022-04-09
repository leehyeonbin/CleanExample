package com.example.presentation.view


import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding
import com.example.presentation.viewmodel.MainViewModel

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        initResult()
    }

    private fun initResult () {
        binding.scoreTv.text = mainViewModel.apiCallResult.percentage.toString()
        when(mainViewModel.apiCallResult.percentage) {
            in 0..20 -> setMessageText("조금 힘들어보이네요...")
            in 21..40 -> setMessageText("노력해보면 가능할지도..?")
            in 41..70 -> setMessageText("기대 해볼만 하겠는데요?!")
            in 71..90 -> setMessageText("오...일단 축하드려요")
            in 91..99 -> setMessageText("와우... 믿기지 않는군요!!")
            100 -> setMessageText("천생연분이네요!! 축하드립니다!!")
            else -> setMessageText("?")
        }
    }

    private fun setMessageText(msg : String) {
        binding.mentTv.text = msg
    }

    fun clickMainBtn (view : View){
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }

}