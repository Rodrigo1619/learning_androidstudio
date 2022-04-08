package com.molina.second_practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class GreetingFragment: Fragment() {

    //we have to know the lifecycle we need, so that is going to be onCreateView
    //as well we need to create the xml archive

    //we have already create the layout and also put in the hello world, now for connecting the fragment to this archive we'll use
    //inflater, container and savedInstanceState.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState) this was the original, now we put
        return inflater.inflate(R.layout.fragment_greeting,container,false)
    }
}