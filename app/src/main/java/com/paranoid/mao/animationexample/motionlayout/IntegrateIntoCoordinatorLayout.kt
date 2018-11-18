package com.paranoid.mao.animationexample.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.longText
import kotlinx.android.synthetic.main.scrollable_content.*

class IntegrateIntoCoordinatorLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motionlayout_collapsible_toolbar)

        content.text = longText
    }
}
