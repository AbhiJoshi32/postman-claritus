package com.claritusconsulting.postman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.claritusconsulting.postman.data.Request
import com.claritusconsulting.postman.db.RequestDao
import com.claritusconsulting.postman.ui.adapters.PostPagerAdapter
import com.claritusconsulting.postman.ui.history.HistoryFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
