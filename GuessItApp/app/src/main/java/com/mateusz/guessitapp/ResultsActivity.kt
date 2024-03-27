package com.mateusz.guessitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val tvPlayerName : TextView = findViewById(R.id.tv_player_name)
        val tvCorrectAnswers : TextView = findViewById(R.id.tv_correct_answers)
        val tvQuizTime : TextView = findViewById(R.id.tv_quiz_time)
        val btnFinish : Button = findViewById(R.id.btn_finish)

        btnFinish.setOnClickListener(this)

        val playerName = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val quizTime = intent.getLongExtra(Constants.QUIZ_TIME, 0)

        tvPlayerName.text = "$playerName"
        tvCorrectAnswers.text = "  $correctAnswers out of $totalQuestions"
        tvQuizTime.text = "  $quizTime seconds"
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_finish -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}