package com.mateusz.guessitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import java.lang.Exception
import kotlin.system.exitProcess

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName : String? = null
    private var mPlatMode : String? = null

    private var tvEndQuiz  : TextView? = null
    private var tvCloseApp : TextView? = null

    private var tvQuestion    : TextView? = null
    private var ivImage       : ImageView? = null
    private var progressBar   : ProgressBar? = null
    private var tvProgress    : TextView? = null
    private var tvOptionOne   : TextView? = null
    private var tvOptionTwo   : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour  : TextView? = null
    private var wasAnswered   : Boolean = false
    private var startTime     : Long = 0
    private var endTime       : Long = 0

    private var llScreen : LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mPlatMode = intent.getStringExtra(Constants.PLAY_MODE)

        tvEndQuiz  = findViewById(R.id.tv_end_quiz)
        tvCloseApp = findViewById(R.id.tv_close_app)

        tvQuestion    = findViewById(R.id.tv_question)
        ivImage       = findViewById(R.id.iv_image)
        progressBar   = findViewById(R.id.progress_bar)
        tvProgress    = findViewById(R.id.tv_progress)
        tvOptionOne   = findViewById(R.id.tv_option_one)
        tvOptionTwo   = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour  = findViewById(R.id.tv_option_four)
        llScreen      = findViewById(R.id.ll_screen)

//        mQuestionsList = Constants.getStadiumsQuestions()
        mQuestionsList = setQuestionsList()
        progressBar?.max = mQuestionsList!!.size

        tvEndQuiz?.setOnClickListener(this)
        tvCloseApp?.setOnClickListener(this)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        llScreen?.setOnClickListener(this)

        startTime = System.currentTimeMillis()

        setQuestion()
    }

    private fun exitQuizAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage("Do you really want to exit current quiz session?")

        builder.setPositiveButton("yes") { dialogInterface, which ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        builder.setNegativeButton("no") { dialogInterface, which ->
            dialogInterface.dismiss()
        }

        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun closeAppAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("WARNING")
        builder.setMessage("Do you really want to close the application?")

        builder.setPositiveButton("yes") { dialogInterface, which ->
            finish()
            exitProcess(0)
        }

        builder.setNegativeButton("no") { dialogInterface, which ->
            dialogInterface.dismiss()
        }

        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun setQuestionsList(): ArrayList<Question> {
        return when {
            mPlatMode!!.contains("players_mode") -> {
                Constants.getPlayersQuestions()
            }
            mPlatMode!!.contains("clubs_logos_mode") -> {
                Constants.getClubsLogosQuestions()
            }
            mPlatMode!!.contains("stadiums_mode") -> {
                Constants.getStadiumsQuestions()
            }
            else -> {
                throw Exception("ERROR DURING LOADING QUIZ QUESTIONS")
            }
        }
    }

    private fun setQuestion() {
//        Log.i("QuestionsList size is", "${mQuestionsList.size}")
//
//        for (i in questionsList) {
//            Log.e("Questions", i.question)
//        }

        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${mQuestionsList!!.size}"
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        defaultOptionsView()
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        wasAnswered = false

        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setBackgroundResource(R.drawable.default_option_border)
        }
    }

    private fun selectedOptionView(selectedOptionNumber: Int) {
        val question = mQuestionsList?.get(mCurrentPosition - 1)

        if (!wasAnswered) {
            mSelectedOptionPosition = selectedOptionNumber

            if (question!!.correctAnswer != mSelectedOptionPosition) {
                answerView(selectedOptionNumber, R.drawable.wrong_option_border)
            }
            else {
                mCorrectAnswers++
            }

            answerView(question.correctAnswer, R.drawable.correct_option_border)
            wasAnswered = true

        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)}
            2 -> {tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)}
            3 -> {tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)}
            4 -> {tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)}
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(1) }}

            R.id.tv_option_two -> {
                tvOptionOne?.let {
                    selectedOptionView(2) }}

            R.id.tv_option_three -> {
                tvOptionOne?.let {
                    selectedOptionView(3) }}

            R.id.tv_option_four -> {
                tvOptionOne?.let {
                    selectedOptionView(4) }}

            R.id.ll_screen -> {
                if (mSelectedOptionPosition == 0 && wasAnswered) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {setQuestion()}

                        else -> {
//                            Toast.makeText(this, "Finish $mCorrectAnswers/${mQuestionsList!!.size}", Toast.LENGTH_SHORT).show()

                            endTime = System.currentTimeMillis()
                            val mQuizTime = (endTime - startTime)/1000

                            val intent = Intent(this, ResultsActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            intent.putExtra(Constants.QUIZ_TIME, mQuizTime)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                mSelectedOptionPosition = 0
            }

            R.id.tv_end_quiz -> {
                exitQuizAlertDialog()
            }

            R.id.tv_close_app -> {
                closeAppAlertDialog()
            }
        }
    }
}