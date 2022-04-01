package com.evgeny_m.postman_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.evgeny_m.feature_contacts_api.FeatureContactsDestination
import com.evgeny_m.feature_settings_api.FeatureSettingsDestination
import com.evgeny_m.navigator_api.AppNavigator
import com.evgeny_m.postman_01.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val appNavigator: AppNavigator by inject()


    private lateinit var binding: ActivityMainBinding
    private lateinit var navigationConfig: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Postman_01)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        navigationConfig = AppBarConfiguration(setOf(R.menu.navigation_menu), drawerLayout)

        val navView = binding.navView
        navController = findNavController(R.id.nav_content_host)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            drawerLayout.close()
            when (it.itemId) {
                R.id.contactsFragment -> {
                    appNavigator.navigateTo(FeatureContactsDestination::class.java)
                    true
                }
                R.id.settingsFragment ->{
                    appNavigator.navigateTo(FeatureSettingsDestination::class.java)
                    true
                }
                else -> false
            }
        }
        initNavigator()
    }

    private fun initNavigator() {
        appNavigator.navigationDestination.observe(this, {
            it?.data?.let { module ->
                navController.navigate(module.getNavigationStartPointResId())
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        })
        appNavigator.navigationResDestination.observe(this, {
            it?.data?.let { res ->
                navController.navigate(res)
            }
        })
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.close()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        lateinit var drawerLayout: DrawerLayout
    }
}