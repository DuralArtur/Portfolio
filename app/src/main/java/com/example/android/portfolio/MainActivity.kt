package com.example.android.portfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myViewPager.adapter = TabsAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(myViewPager)
    }


    class TabsAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
        override fun getCount(): Int {return 3}
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return ProjectsFragment()
                1 -> return BioFragment()
                2 -> return ContactFragment()
                else -> return ProjectsFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence {
            when(position) {
                0 -> return "Projects"
                1 -> return "Biography"
                2 -> return "Contact"
                else -> return ""
            }
        }
    }
}
