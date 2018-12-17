package com.paranoid.mao.animationexample.revealhide

import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import com.paranoid.mao.animationexample.R
import kotlinx.android.synthetic.main.activity_circular_reveal_example.*
import kotlin.math.hypot

class CircularRevealExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_reveal_example)

        toggle_button.setOnClickListener {
            if (image_view.isVisible) {
                circularHide(image_view)
            } else {
                circularReveal(image_view)
            }
        }
    }

    private fun circularReveal(target: View) {
        target.isVisible = true
        target.doOnPreDraw {
            val cx = it.width / 2
            val cy = it.height / 2
            val finalRadius = hypot(cx.toFloat(), cy.toFloat())

            val revealAnim = ViewAnimationUtils.createCircularReveal(target, cx, cy, 0f, finalRadius)
            revealAnim.start()
        }
    }

    private fun circularHide(target: View) {
        val cx = target.width / 2
        val cy = target.height / 2

        val initialRadius = hypot(cx.toFloat(), cy.toFloat())

        ViewAnimationUtils.createCircularReveal(target, cx, cy, initialRadius, 0f).apply {
            addListener(
                onEnd = { target.isVisible = false }
            )
            start()
        }
    }
}