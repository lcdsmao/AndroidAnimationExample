package com.paranoid.mao.animationexample.animatedrawable

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paranoid.mao.animationexample.R
import kotlinx.android.synthetic.main.activity_animate_drawable_example.*

class AnimatedDrawableExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate_drawable_example)

        anim_vector.setOnClickListener {
            (anim_vector.drawable as AnimatedVectorDrawable).start()
        }
        anim_vector_single_xml.setOnClickListener {
            (anim_vector_single_xml.drawable as AnimatedVectorDrawable).start()
        }
    }
}
