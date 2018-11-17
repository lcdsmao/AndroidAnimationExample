package com.paranoid.mao.animationexample.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paranoid.mao.animationexample.Entry
import com.paranoid.mao.animationexample.EntryAdapter
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.startActivity
import kotlinx.android.synthetic.main.entries_layout.*

class MotionLayoutExamplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entries_layout)

        activity_title.text = "MotionLayout Examples"
        val entries = listOf(
            Entry("Simple Swipe") {
                startActivity<SimpleSwipeActivity>()
            },
            Entry("Swipe With Interpolated") {
                startActivity<SwipeWithInterpolatedActivity>()
            },
            Entry("Swipe With KeyFrame") {
                startActivity<SwipeWithKeyFrameActivity>()
            }
        )
        recycler_view.adapter = EntryAdapter(entries)
    }
}
