package com.example.presentation.view

import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.utils.ErrorType
import com.example.domain.utils.ScreenState
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentManNameBinding
import com.example.presentation.viewmodel.MainViewModel

class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun clickNextBtn(view: View) {
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "fd6fa482b6msh9d51805e067530fp13b47ejsn4543fcd61bdd",
            binding.manNameEt.text.toString(),
            mainViewModel.womanNameResult
        )
    }

    private fun observeViewModel() {
        mainViewModel.apiCallEvent.observe(this) {
            binding.progressBar.visibility = View.INVISIBLE
            when (it) {
                ScreenState.LOADING -> this.findNavController()
                    .navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortToastMessage("예기치 못한 오류가 발생하였습니다.")
            }
        }
    }

    private fun toastErrorMsg() {
        when (mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> shortToastMessage("네트워크 오류가 발생하였습니다.")
            ErrorType.UNKNOWN -> shortToastMessage("예기치 못한 오류가 발생하였습니다.")
            ErrorType.SESSION_EXPIRED -> shortToastMessage("세션이 만료되었습니다.")
            ErrorType.TIMEOUT -> shortToastMessage("연결 시간이 초과되었습니다.")
        }
    }

}