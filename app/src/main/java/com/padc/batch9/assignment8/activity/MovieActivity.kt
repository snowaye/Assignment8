package com.padc.batch9.assignment8.activity


import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.padc.batch9.assignment8.R
import com.padc.batch9.assignment8.adapter.MyViewPagerAdapter
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.delegate.MovieDataDelegate
import com.padc.batch9.assignment8.fragment.NowShowingFragment

class MovieActivity : BaseActivity(), MovieDataDelegate {

    override fun getMovieListFromHost(): List<MovieVo> {

    }

    val viewPagerAdapter:MyViewPagerAdapter= MyViewPagerAdapter(fragmentManager = supportFragmentManager)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupViewPager(viewPager: ViewPager) {

        viewPagerAdapter.addFragment(NowShowingFragment(), resources.getString(R.string.label_now_showing))
        viewPagerAdapter.addFragment(NowShowingFragment(), resources.getString(R.string.label_cinema))
        viewPagerAdapter.addFragment(NowShowingFragment(), resources.getString(R.string.label_coming_soon))
        viewPager.setAdapter(viewPagerAdapter)
    }
}
