package com.paranoid.mao.animationexample.transition

import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.paranoid.mao.animationexample.R
import kotlinx.android.synthetic.main.activity_place_holder_example.*

class PlaceHolderExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_holder_example)

        button_1.setOnClickListener { clickButton(it) }
        button_2.setOnClickListener { clickButton(it) }
        button_3.setOnClickListener { clickButton(it) }
        button_4.setOnClickListener { clickButton(it) }
    }

    private fun clickButton(target: View) {
        val transition = ChangeBounds().apply {
            duration = 200
            interpolator = OvershootInterpolator()
        }
        TransitionManager.beginDelayedTransition(container, transition)
        placeholder.setContentId(target.id)
    }
}