package com.example.sushi.poker

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import com.example.sushi.R
import java.lang.NullPointerException

class PokerActivity : AppCompatActivity() {

    private lateinit var cardImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_poker)
        cardImg = findViewById<ImageView>(R.id.cardImg)
        cardImg.setOnClickListener {
            filpAnaimation()
        }
    }

    private fun filpAnaimation() {
        val oa1 = ObjectAnimator.ofFloat(cardImg, "scaleX", 1f,0f)
        val oa2 = ObjectAnimator.ofFloat(cardImg, "scaleX", 0f,1f)

        oa1.interpolator = DecelerateInterpolator()
        oa2.interpolator = AccelerateDecelerateInterpolator()

        oa1.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                if (cardImg.drawable.constantState == resources.getDrawable(R.mipmap.ic_card_background).constantState) {
                    cardImg.setImageResource(R.drawable.ic_launcher_background)
                } else {
                    cardImg.setImageResource(R.mipmap.ic_card_background)
                }
                oa2.start()
            }
        })
        oa1.start()
        oa1.duration = 1000
        oa1.duration = 1000

    }
}