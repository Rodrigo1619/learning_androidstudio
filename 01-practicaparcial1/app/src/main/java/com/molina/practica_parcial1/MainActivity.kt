package com.molina.practica_parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //declaring variables
    //counters
    private var ScoreTeamA = 0
    private var ScoreTeamB = 0
   //views
    private lateinit var TeamAScoreTextView: TextView
    private lateinit var TeamBScoreTextView: TextView
    private lateinit var TeamAAddButton: Button
    private lateinit var TeamBAddButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()//we have to call the function
        setupScores()
        addListeners()
    }

    //3-) listeners
    private fun addListeners(){
        TeamAAddButton.setOnClickListener {
            ScoreTeamA++
            //OLDER WAY:TeamAScoreTextView.text = ScoreTeamA.toString() //that's why we did the function setupScores, this way is easier
            updateVisualScores(TeamAScoreTextView, ScoreTeamA)
        }
        TeamBAddButton.setOnClickListener { //but, we can do a function for a better performance and best practices
            ScoreTeamB++
            //OLDER WAY:TeamBScoreTextView.text = ScoreTeamB.toString()
            //NEW WAY
            updateVisualScores(TeamBScoreTextView, ScoreTeamB)
        }
    }
    //4-) updating visual scores
    private fun updateVisualScores(view: TextView, score: Int){
        view.text = score.toString()
    }

    //2-)declaring more functions for setting up the score
    private fun setupScores(){
        /* OLDER WAY, as we had added a new function we just have to call it here
        TeamAScoreTextView.text = TeamAScoreTextView.toString()//we have to parcel into string, because if we use it as a number we're gonna have problems
        TeamBScoreTextView.text = TeamBScoreTextView.toString()*/

        //new way
        updateVisualScores(TeamAScoreTextView, ScoreTeamA)
        updateVisualScores(TeamBScoreTextView, ScoreTeamB)

    }
    //1-)doing bind function
    private fun bind(){
        TeamAScoreTextView = findViewById(R.id.score_team_a_text_view)//don't forget R. 'cause R = Resource
        TeamAAddButton = findViewById(R.id.action_add_one_team_a)
        TeamBScoreTextView = findViewById(R.id.score_team_b_text_view)
        TeamBAddButton = findViewById(R.id.action_add_one_team_b)
    }
}