package com.ahkam.start.module.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ahkam.start.R
import com.ahkam.start.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    private val SPLASH_DISPLAY_LENGTH = 3000.toLong();

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_splash_screen,
            container,
            false
        )

        Handler().postDelayed({
            this.findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)

        }, SPLASH_DISPLAY_LENGTH)


        return binding.root
    }


}
