package com.paranoid.mao.animationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paranoid.mao.animationexample.motionlayout.MotionLayoutExamplesActivity
import com.paranoid.mao.animationexample.animatedrawable.AnimatedDrawableExampleActivity
import kotlinx.android.synthetic.main.entries_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entries_layout)

        activity_title.text = "Animation Examples"
        val entries = listOf(
            Entry("MotionLayout Examples") { startActivity<MotionLayoutExamplesActivity>() },
            Entry("AnimatedVectorDrawable Examples") { startActivity<AnimatedDrawableExampleActivity>() }
        )
        recycler_view.adapter = EntryAdapter(entries)
    }
}
