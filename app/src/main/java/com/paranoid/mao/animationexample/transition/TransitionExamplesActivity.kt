package com.paranoid.mao.animationexample.transition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paranoid.mao.animationexample.Entry
import com.paranoid.mao.animationexample.EntryAdapter
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.startActivity
import kotlinx.android.synthetic.main.entries_layout.*

class TransitionExamplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entries_layout)

        activity_title.text = "Transition Examples"
        val entries = listOf(
            Entry("Place Holder") { startActivity<PlaceHolderExampleActivity>() }
        )
        recycler_view.adapter = EntryAdapter(entries)
    }
}