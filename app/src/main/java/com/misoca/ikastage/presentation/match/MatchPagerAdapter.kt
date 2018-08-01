package com.misoca.ikastage.presentation.match

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MatchPagerAdapter(val matches: Array<String>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MatchFragment.newInstance(matches[position])
    }

    override fun getCount(): Int {
        return matches.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return matches[position]
    }

}