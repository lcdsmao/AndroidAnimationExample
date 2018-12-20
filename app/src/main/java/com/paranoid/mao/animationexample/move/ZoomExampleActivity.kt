package com.paranoid.mao.animationexample.move

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Point
import android.graphics.Rect
import android.graphics.RectF
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.view.isVisible
import com.paranoid.mao.animationexample.R
import kotlinx.android.synthetic.main.activity_zoom_example.*

class ZoomExampleActivity : AppCompatActivity() {

    private var animator: Animator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_example)

        thumb_button.setOnClickListener {
            zoomImageFromThumb(it, R.drawable.sample_background)
        }
    }

    private fun zoomImageFromThumb(thumbView: View, imageResId: Int) {
        animator?.cancel()

        expanded_image.setImageResource(imageResId)

        val startBoundsInt = Rect()
        val finalBoundsInt = Rect()
        val globalOffset = Point()

        thumbView.getGlobalVisibleRect(startBoundsInt)
        container.getGlobalVisibleRect(finalBoundsInt, globalOffset)
        startBoundsInt.offset(-globalOffset.x, -globalOffset.y)
        finalBoundsInt.offset(-globalOffset.x, -globalOffset.y)

        val startBounds = RectF(startBoundsInt)
        val finalBounds = RectF(finalBoundsInt)

        val startScale: Float
        if (finalBounds.width() / finalBounds.height() > startBounds.width() / startBounds.height()) {
            startScale = startBounds.height() / finalBounds.height()
            val startWidth = startScale * finalBounds.height()
            val deltaWidth = (startWidth - startBounds.width()) / 2
            startBounds.left -= deltaWidth
            startBounds.right += deltaWidth
        } else {
            startScale = startBounds.width() / finalBounds.width()
            val startHeight = startScale * finalBounds.height()
            val deltaHeight = (startHeight - startBounds.height()) / 2
            startBounds.top -= deltaHeight
            startBounds.bottom += deltaHeight
        }

        thumbView.alpha = 0f
        expanded_image.isVisible = true

        expanded_image.pivotX = 0f
        expanded_image.pivotY = 0f

        val xHolder = PropertyValuesHolder.ofFloat(View.X, startBounds.left, finalBounds.left)
        val yHolder = PropertyValuesHolder.ofFloat(View.Y, startBounds.top, finalBounds.top)
        val scaleXHolder = PropertyValuesHolder.ofFloat(View.SCALE_X, startScale, 1f)
        val scaleYHolder = PropertyValuesHolder.ofFloat(View.SCALE_Y, startScale, 1f)

        animator = ObjectAnimator.ofPropertyValuesHolder(
            expanded_image,
            xHolder, yHolder, scaleXHolder, scaleYHolder
        ).apply {
            duration = 200
            interpolator = DecelerateInterpolator()
            addListener(
                onEnd = { animator = null },
                onCancel = { animator = null }
            )
            start()
        }

        expanded_image.setOnClickListener {
            animator?.cancel()

            val xHolderB = PropertyValuesHolder.ofFloat(View.X, startBounds.left)
            val yHolderB = PropertyValuesHolder.ofFloat(View.Y, startBounds.top)
            val scaleXHolderB = PropertyValuesHolder.ofFloat(View.SCALE_X, startScale)
            val scaleYHolderB = PropertyValuesHolder.ofFloat(View.SCALE_Y, startScale)

            animator = ObjectAnimator.ofPropertyValuesHolder(
                expanded_image,
                xHolderB, yHolderB, scaleXHolderB, scaleYHolderB
            ).apply {
                duration = 200
                interpolator = DecelerateInterpolator()
                addListener(
                    onEnd = {
                        thumbView.alpha = 1f
                        expanded_image.isVisible = false
                        animator = null
                    },
                    onCancel = {
                        thumbView.alpha = 1f
                        expanded_image.isVisible = false
                        animator = null
                    }
                )
                start()
            }
        }
    }
}