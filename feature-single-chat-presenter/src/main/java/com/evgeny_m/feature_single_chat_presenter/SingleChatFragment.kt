package com.evgeny_m.feature_single_chat_presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.evgeny_m.feature_single_chat_presenter.databinding.FragmentSingleChatBinding
import com.evgeny_m.navigator_api.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class SingleChatFragment : Fragment() {


    private lateinit var binding: FragmentSingleChatBinding
    private val appNavigator: AppNavigator by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleChatBinding.inflate(layoutInflater)

        appNavigator.navData.observe(viewLifecycleOwner, Observer {
            binding.name.text = it.toString()
        })




        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

}