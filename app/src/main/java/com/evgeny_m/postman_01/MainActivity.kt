package com.evgeny_m.postman_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.evgeny_m.navigator_api.AppNavigator
import com.evgeny_m.postman_01.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val appNavigator: AppNavigator by inject()

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationConfig: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        navigationConfig = AppBarConfiguration(setOf(R.menu.navigation_menu), drawerLayout)

        val navView = binding.navView
        navController = findNavController(R.id.nav_content_host)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                it.itemId -> {
                    //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                    drawerLayout.close()
                    true
                }
                else -> false
            }
        }
        initNavigator()
    }

    private fun initNavigator() {
        appNavigator.navigationDestination.observe(this, Observer {
            it?.data?.let { module ->
                navController.navigate(module.getNavigationStartPointResId())
            }
        })
        appNavigator.navigationResDestination.observe(this, Observer {
            it?.data?.let { res ->
                navController.navigate(res)
            }
        })
    }


    override fun onResume() {
        super.onResume()
        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.close()
        } else {
            super.onBackPressed()
        }
    }


}