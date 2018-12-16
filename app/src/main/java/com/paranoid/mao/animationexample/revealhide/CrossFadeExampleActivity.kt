package com.paranoid.mao.animationexample.revealhide

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.longText
import kotlinx.android.synthetic.main.activity_cross_fade_example.*

class CrossFadeExampleActivity : AppCompatActivity() {

    private val animationDuration: Int by lazy { resources.getInteger(android.R.integer.config_mediumAnimTime) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cross_fade_example)

        content_container.isVisible = false
        content.text = longText

        toggle_button.setOnClickListener { crossFade() }
    }

    private fun crossFade() {
        content_container.apply {
            alpha = 0f
            isVisible = true

            animate().alpha(1f)
                .setDuration(animationDuration.toLong())
                .setListener(null)
        }

        loading_spinner.animate()
            .alpha(0f)
            .setDuration(animationDuration.toLong())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    loading_spinner.isVisible = false
                }
            })
    }
}
