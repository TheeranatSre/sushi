package com.example.sushi.ui.main

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import com.example.sushi.R
import com.example.sushi.databinding.PokerRoomFragmentBinding

class PokerRoomFragment : Fragment() {

    private lateinit var viewModel: PokerRoomViewModel
    private lateinit var binding: PokerRoomFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[PokerRoomViewModel::class.java]
        val fragmentBinding = PokerRoomFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        binding.cardImg.setOnClickListener {
            val cardImg = binding.cardImg
            val oa1 = ObjectAnimator.ofFloat(cardImg, "scaleX", 1f,0f)
            val oa2 = ObjectAnimator.ofFloat(cardImg, "scaleX", 0f,1f)

            oa1.interpolator = DecelerateInterpolator()
            oa2.interpolator = AccelerateDecelerateInterpolator()

            oa1.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    if (cardImg.drawable.constantState == resources.getDrawable(R.drawable.ic_card_background).constantState) {
                        cardImg.setImageResource(R.drawable.ic_launcher_background)
                    } else {
                        cardImg.setImageResource(R.drawable.ic_card_background)
                    }
                    oa2.start()
                }
            })
            oa1.start()
            oa1.duration = 1000
            oa1.duration = 1000
        }

        return binding.root
    }
}