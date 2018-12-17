package com.paranoid.mao.animationexample.revealhide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paranoid.mao.animationexample.Entry
import com.paranoid.mao.animationexample.EntryAdapter
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.startActivity
import kotlinx.android.synthetic.main.entries_layout.*

class RevealOrHideViewExamplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entries_layout)

        activity_title.text = "Reveal or Hide View Examples"
        val entries = listOf(
            Entry("Cross Fade Animation") { startActivity<CrossFadeExampleActivity>() },
            Entry("Card Flip between Fragments") { startActivity<CardFlipExampleActivity>() }
        )
        recycler_view.adapter = EntryAdapter(entries)
    }
}
