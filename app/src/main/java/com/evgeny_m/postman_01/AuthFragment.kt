package com.evgeny_m.postman_01

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evgeny_m.app_data_module.FirebaseAuthImpl
import com.evgeny_m.feature_auth_presenter.utils.AppTextWatcher
import com.evgeny_m.feature_auth_presenter.utils.hideKeyboard
import com.evgeny_m.postman_01.databinding.FragmentAuthBinding


class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    private lateinit var userPhone: String
    private lateinit var verificationCode: String
    lateinit var firebaseAuth: FirebaseAuthImpl


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuthImpl(requireActivity())
        binding.phone.addTextChangedListener(AppTextWatcher{
            userPhone = binding.phone.text.toString()

            if (userPhone.length == 12) {
                hideKeyboard()
                showAlertDialog(userPhone)
            }
        })

        binding.code.addTextChangedListener(AppTextWatcher{
            verificationCode = binding.code.text.toString()
            if (verificationCode.length == 6){
                hideKeyboard()
                //sendCodeUseCase.execute(verificationCode)
                firebaseAuth.sendCode(verificationCode)
            }
        })

        return binding.root
    }

    private fun showAlertDialog(userPhone: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            //binding.phone.focusable = View.NOT_FOCUSABLE
            //registerViewModel.enterPhone(string)
            //registerByPhoneUseCase.execute(userPhone)
            firebaseAuth.registerByPhone(userPhone)
        }
        builder.setNegativeButton("No") { _, _ ->
            //nothing to do
        }
        builder.setTitle("Number is correct?")
        builder.setMessage(userPhone)
        builder.create().show()
    }
}