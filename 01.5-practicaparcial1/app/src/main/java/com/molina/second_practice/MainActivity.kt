package com.molina.second_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //calling the manager of the fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction() //we begin a transaction (of fragment I guess)

        val fragment = SumFragment.newInstance(2,5)

        fragmentTransaction
            .add(R.id.framelayout_fragment,fragment)
            .commit() //this is for being sure this is the change we wanna do
    }


}