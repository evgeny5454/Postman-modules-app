package com.evgeny_m.feature_auth_presenter

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.evgeny_m.feature_auth_presenter.databinding.FragmentStartAuthBinding
import com.evgeny_m.feature_auth_presenter.utils.AppTextWatcher
import com.evgeny_m.feature_auth_presenter.utils.hideKeyboard
import com.example.feature_auth_data.RepositoryImpl
import com.example.feature_auth_domain.use_case.RegisterByPhoneUseCase
import com.example.feature_auth_domain.use_case.SendCodeUseCase

class StartAuthFragment : Fragment(){

    private lateinit var binding: FragmentStartAuthBinding

    private lateinit var userPhone: String
    private lateinit var verificationCode: String
    lateinit var repositoryImpl: RepositoryImpl

    /*private val registerByPhoneUseCase = RegisterByPhoneUseCase(RepositoryImpl(requireActivity()))
    private val sendCodeUseCase = SendCodeUseCase(RepositoryImpl(requireActivity()))*/



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartAuthBinding.inflate(layoutInflater)
        repositoryImpl = RepositoryImpl(requireActivity())
        binding.phone.addTextChangedListener(AppTextWatcher{
            userPhone = binding.phone.text.toString()

            if (userPhone.length == 12) {
                hideKeyboard()
                showAlertDialog(userPhone)
            }
        })

        binding.code.addTextChangedListener(AppTextWatcher{
            verificationCode = binding.code.text.toString()
            if (verificationCode.length == 4){
                hideKeyboard()
                //sendCodeUseCase.execute(verificationCode)
                repositoryImpl.enterCode(verificationCode)
            }
        })

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showAlertDialog(userPhone: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            binding.phone.focusable = View.NOT_FOCUSABLE
            //registerViewModel.enterPhone(string)
            //registerByPhoneUseCase.execute(userPhone)
            repositoryImpl.registerByPhone(userPhone)
        }
        builder.setNegativeButton("No") { _, _ ->
            //nothing to do
        }
        builder.setTitle("Number is correct?")
        builder.setMessage(userPhone)
        builder.create().show()
    }


}