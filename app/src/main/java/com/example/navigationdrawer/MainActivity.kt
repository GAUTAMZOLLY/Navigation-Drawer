package com.example.navigationdrawer

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
      private   lateinit var   binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding  =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


          setSupportActionBar(binding.toolBarId)

          binding.navView.setNavigationItemSelectedListener(this)
          val toggle  =  ActionBarDrawerToggle(this , binding.drawerLayoutId ,
                 binding.toolBarId ,  R.string.open_nav , R.string.close_nav)
          binding.drawerLayoutId.addDrawerListener(toggle)
        toggle.syncState()


          if (savedInstanceState ==  null) {
                supportFragmentManager.beginTransaction() .replace(R.id.fragment_container ,  HomeFragmen()).commit()
                binding.navView.setCheckedItem(R.id.nav_home)
          }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId) {
             R.id.nav_home ->  {
                   supportFragmentManager.beginTransaction().replace(R.id.fragment_container ,
                       HomeFragmen()).commit()
             }

           R.id.nav_about ->  {
                 supportFragmentManager.beginTransaction().replace(R.id.fragment_container ,
                    AboutFragment()).commit()
           }

           R.id.nav_share  ->  {
                 supportFragmentManager.beginTransaction().replace(R.id.fragment_container
                   ,  hareFragment()).commit()
           }

           R.id.nav_setting  ->  {
                 supportFragmentManager.beginTransaction().replace(R.id.fragment_container ,
                     SettingsFragment()).commit()
           }

       }

        binding.drawerLayoutId.closeDrawer(GravityCompat.START)
        return true

    }

    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.drawerLayoutId.isDrawerOpen(GravityCompat.START))  {
                binding.drawerLayoutId.closeDrawer(GravityCompat.START)
          }  else {
               onBackPressedDispatcher.onBackPressed()
          }
    }

}