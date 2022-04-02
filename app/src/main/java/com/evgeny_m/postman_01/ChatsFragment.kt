package com.evgeny_m.postman_01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.evgeny_m.app_data_module.FirebaseAuthImpl
import com.evgeny_m.feature_auth_api.FeatureAuthDestination
import com.evgeny_m.feature_single_chat_api.FeatureSingleChatDestination
import com.evgeny_m.navigator_api.AppNavigator
import com.evgeny_m.postman_01.MainActivity.Companion.drawerLayout
import com.evgeny_m.postman_01.databinding.FragmentChatsBinding
import org.koin.android.ext.android.inject

class ChatsFragment : Fragment() {

    private val appNavigator: AppNavigator by inject()

    private lateinit var binding: FragmentChatsBinding

    private val auth = FirebaseAuthImpl()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if(auth.auth()) {
            binding = FragmentChatsBinding.inflate(layoutInflater)



            binding.btn.setOnClickListener {
                appNavigator.navigateTo(FeatureSingleChatDestination::class.java,"Имя пользователя")
            }
            binding.root
        } else {
            appNavigator.navigateTo(FeatureAuthDestination::class.java)
            null
        }
    }

    override fun onResume() {
        super.onResume()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}