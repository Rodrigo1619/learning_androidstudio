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
        setupScores(savedInstanceState) //we have to add save instance state as a parameter
        addListeners()
    }
    //5-) we use this for saving information when we turn around the phone
    //there is 2 save instance state, we will use the one that has one parameter
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_TEAM_A, ScoreTeamA)
        outState.putInt(KEY_TEAM_B, ScoreTeamB)
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
    private fun setupScores(savedInstanceState: Bundle?) {
        /* OLDER WAY, as we had added a new function we just have to call it here
        TeamAScoreTextView.text = TeamAScoreTextView.toString()//we have to parcel into string, because if we use it as a number we're gonna have problems
        TeamBScoreTextView.text = TeamBScoreTextView.toString()*/

        //new way
        //we have to create the save instance   don't forget "?" in saveinstancestate.let
        savedInstanceState?.let { bundle -> // let it??s similar like an if
            ScoreTeamA = bundle.getInt(KEY_TEAM_A, 0)
            ScoreTeamB = bundle.getInt(KEY_TEAM_B, 0)
        }
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

    //companion object is a static function
    companion object {
        //global variables for the function
        private const val KEY_TEAM_A = "ScoreTeamA"
        private const val KEY_TEAM_B = "ScoreTeamB"
    }
}