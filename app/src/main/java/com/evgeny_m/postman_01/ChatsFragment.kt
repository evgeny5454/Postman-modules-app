package com.evgeny_m.postman_01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.evgeny_m.app_data_module.FirebaseAuthImpl
import com.evgeny_m.feature_auth_api.FeatureAuthDestination
import com.evgeny_m.navigator_api.AppNavigator
import com.evgeny_m.postman_01.MainActivity.Companion.drawerLayout
import com.evgeny_m.postman_01.databinding.FragmentChatsBinding
import org.koin.android.ext.android.inject

class ChatsFragment : Fragment() {

    private val appNavigator: AppNavigator by inject()

    private lateinit var binding: FragmentChatsBinding


    //private val auth = FirebaseAuthImpl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }
}
