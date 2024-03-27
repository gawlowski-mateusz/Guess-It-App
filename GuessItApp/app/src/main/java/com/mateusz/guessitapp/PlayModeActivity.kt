package com.mateusz.guessitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class PlayModeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_mode)

        val btnPlayers : TextView  = findViewById(R.id.tv_players_mode)
        val btnLogos : TextView    = findViewById(R.id.tv_clubs_logos_mode)
        val btnStadiums : TextView = findViewById(R.id.tv_stadiums_mode)

        btnPlayers.setOnClickListener(this)
        btnLogos.setOnClickListener(this)
        btnStadiums.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_players_mode -> {
//                Toast.makeText(this, "Players mode successfully chosen", Toast.LENGTH_LONG).show()

                val playMode = "players_mode"
                val userName : String? = intent.getStringExtra(Constants.USER_NAME)

                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.PLAY_MODE, playMode)
                intent.putExtra(Constants.USER_NAME, userName)
                startActivity(intent)
                finish()
            }

            R.id.tv_clubs_logos_mode -> {
//                Toast.makeText(this, "Clubs Logos mode successfully chosen", Toast.LENGTH_LONG).show()

                val playMode = "clubs_logos_mode"
                val userName : String? = intent.getStringExtra(Constants.USER_NAME)

                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.PLAY_MODE, playMode)
                intent.putExtra(Constants.USER_NAME, userName)
                startActivity(intent)
                finish()
            }

            R.id.tv_stadiums_mode -> {
//                Toast.makeText(this, "Stadiums mode successfully chosen", Toast.LENGTH_LONG).show()

                val playMode = "stadiums_mode"
                val userName : String? = intent.getStringExtra(Constants.USER_NAME)

                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.PLAY_MODE, playMode)
                intent.putExtra(Constants.USER_NAME, userName)
                startActivity(intent)
                finish()
            }
        }
    }
}