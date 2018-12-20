package com.paranoid.mao.animationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paranoid.mao.animationexample.motionlayout.MotionLayoutExamplesActivity
import com.paranoid.mao.animationexample.animatedrawable.AnimatedDrawableExampleActivity
import com.paranoid.mao.animationexample.move.ZoomExampleActivity
import com.paranoid.mao.animationexample.revealhide.RevealOrHideViewExamplesActivity
import kotlinx.android.synthetic.main.entries_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entries_layout)

        activity_title.text = "Animation Examples"
        val entries = listOf(
            Entry("Motion Layout Examples") { startActivity<MotionLayoutExamplesActivity>() },
            Entry("Animated Vector Drawable Examples") { startActivity<AnimatedDrawableExampleActivity>() },
            Entry("Reveal or Hide View Examples") { startActivity<RevealOrHideViewExamplesActivity>() },
            Entry("Zoom Example") { startActivity<ZoomExampleActivity>() }
        )
        recycler_view.adapter = EntryAdapter(entries)
    }
}
