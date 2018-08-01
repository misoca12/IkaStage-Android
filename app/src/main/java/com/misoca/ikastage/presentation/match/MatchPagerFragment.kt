package com.misoca.ikastage.presentation.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.misoca.ikastage.databinding.MatchPagerFragmentBinding
import dagger.android.support.DaggerFragment // Supportを入れないとv4のFragmentが使われないので注意

class MatchPagerFragment : DaggerFragment() {

    private lateinit var binding: MatchPagerFragmentBinding
    // ViewPager内の各Fragmentで呼び出すAPIのパスを配列で定義
    private val matches = arrayOf("regular", "gachi", "league")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        MatchPagerFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewPager.adapter = MatchPagerAdapter(matches, childFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MatchPagerFragment()
    }
}
