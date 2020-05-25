package com.gomyschool.view.home

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gomyschool.R
import com.gomyschool.view.home.fragment.*
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        with(main_viewpager) {
            adapter = MainPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) = Unit
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) = Unit

                override fun onPageSelected(position: Int) {
                    main_bottom_navigation.menu.getItem(position).isChecked = true
                }
            })
        }

        main_bottom_navigation.getOrCreateBadge(R.id.action_news).apply {
            backgroundColor = Color.RED
            badgeTextColor = Color.WHITE
            maxCharacterCount = 3
            number = 103
            isVisible = true
        }

        main_bottom_navigation.getOrCreateBadge(R.id.action_attendance).apply {
            backgroundColor = Color.RED
            isVisible = true
        }



        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home ->{
                    main_viewpager.currentItem = 0

                }
                R.id.action_news -> {
                    main_viewpager.currentItem = 1
                }
                R.id.action_attendance -> {
                    main_viewpager.currentItem = 2
                }
                R.id.action_application -> {
                    main_viewpager.currentItem = 3
                }
                R.id.action_profile -> {
                    main_viewpager.currentItem = 4
                }
            }
            true
        }
    }


   inner class MainPagerAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment()
                1 -> NewsFragment()
                2 -> AttendanceFragment()
                3 -> ApplicationFragment()
                else -> ProfileFragment()
            }
        }

        override fun getCount() = 5
    }
}
