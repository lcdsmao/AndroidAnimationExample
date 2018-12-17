package com.paranoid.mao.animationexample.revealhide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.longText
import kotlinx.android.synthetic.main.activity_card_flip_example.*
import kotlinx.android.synthetic.main.fragment_card_front.view.*

class CardFlipExampleActivity : AppCompatActivity() {

    private var isShowingBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_flip_example)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CardFrontFragment(), CardFrontFragment::class.java.name)
                .commit()
        }

        toggle_button.setOnClickListener { flipCard() }
    }

    private fun flipCard() {
        if (isShowingBack) {
            supportFragmentManager.popBackStack()
            isShowingBack = false
            return
        }

        isShowingBack = true

        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_right_in,
                R.animator.card_flip_right_out,
                R.animator.card_flip_left_in,
                R.animator.card_flip_left_out
            )
            .replace(R.id.container, CardBackFragment())
            .addToBackStack(null)
            .commit()
    }

    class CardFrontFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.fragment_card_front, container, false).apply {
            text2.text = longText
        }

    }

    class CardBackFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.fragment_card_back, container, false)

    }
}