package com.molina.practica_parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {

    //variables
    //data
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    //view
    private lateinit var scoreTeamATextView: TextView
    private lateinit var scoreTeamBTextView: TextView
    private lateinit var statusTeamA: TextView
    private lateinit var statusTeamB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        bind()//calling function
        //now we have to pass the data we take from main activity, this is the intent we declared in main activity
        intent?.let { intent ->
            scoreTeamA = intent.getIntExtra(MainActivity.KEY_TEAM_A, 0)
            scoreTeamB = intent.getIntExtra(MainActivity.KEY_TEAM_B, 0)
        }
        fillScoreBoard()
    }

    //1-) function bind
    private fun bind(){
        scoreTeamATextView = findViewById(R.id.score_team_a_text_view)
        scoreTeamBTextView = findViewById(R.id.score_team_b_text_view)
        statusTeamA = findViewById(R.id.status_team_a_text_view)
        statusTeamB = findViewById(R.id.status_team_b_text_view)
    }
    //2-) showing data
    private fun fillScoreBoard(){
        scoreTeamATextView.text = scoreTeamA.toString()
        scoreTeamBTextView.text = scoreTeamB.toString()

        //conditional for knowing results
        if (scoreTeamA == scoreTeamB){
            scoreTeamATextView.text = getString(R.string.text_winner)
            scoreTeamBTextView.text = getString(R.string.text_winner)
        }else if(scoreTeamA > scoreTeamB){
            scoreTeamATextView.text = getString(R.string.text_winner)
            scoreTeamBTextView.text = getString(R.string.text_looser)
        }else{
            scoreTeamATextView.text = getString(R.string.text_looser)
            scoreTeamBTextView.text = getString(R.string.text_winner)
        }
    }
}