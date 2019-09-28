package com.padc.batch9.assignment8.activity


import android.os.Bundle
import android.util.Log
import androidx.core.view.size
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.padc.batch9.assignment8.R
import com.padc.batch9.assignment8.adapter.MyViewPagerAdapter
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.delegate.MovieDataDelegate
import com.padc.batch9.assignment8.fragment.CinemaFragment
import com.padc.batch9.assignment8.fragment.ComingSoonFragment
import com.padc.batch9.assignment8.fragment.NowShowingFragment
import com.padc.batch9.assignment8.util.FunUtil
import kotlinx.android.synthetic.main.activity_main.*

class MovieActivity : BaseActivity(), MovieDataDelegate {

    val tag:String = "MovieActivity"
    var movieVos: List<MovieVo> = ArrayList<MovieVo>()
    var movieTabLayout: TabLayout? = null
    var movieViewPager: ViewPager? = null

    override fun getMovieListFromHost(): List<MovieVo> {
        return movieVos
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(tag, "onCreate")
        FunUtil.setStatusBarColor(this, R.color.colorPrimary)
        movieTabLayout = findViewById<TabLayout>(R.id.tabLayout)
        movieViewPager = findViewById<ViewPager>(R.id.viewpager)

        model.getMovie({ it -> movieVos = it
            getMovieListFromHost()
            bindData()},
            {Snackbar.make(rootView, it, Snackbar.LENGTH_LONG).show()})
    }

    fun bindData() {
        Log.i(tag, "bindData${movieVos.size}")
        movieViewPager?.let { setupViewPager(it) }
        Log.i(tag, "viewpager="+viewpager.size)
        movieTabLayout?.setupWithViewPager(movieViewPager)
        selectFirstTab()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var viewPagerAdapter = MyViewPagerAdapter(supportFragmentManager)
        Log.i(tag, "Adaper Size=${viewPagerAdapter.count}")
        viewPager.adapter = viewPagerAdapter
    }

    private fun selectFirstTab() {
        movieViewPager?.setCurrentItem(0)
        movieTabLayout?.getTabAt(0)?.select()
    }
}
