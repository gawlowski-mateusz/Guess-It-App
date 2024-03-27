package com.mateusz.guessitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var tvPlay   : TextView? = null
    private var tvAbout  : TextView? = null
    private var tvDonate : TextView? = null
    private var tvExit   : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvPlay   = findViewById(R.id.tv_play)
        tvAbout  = findViewById(R.id.tv_about)
        tvDonate = findViewById(R.id.tv_donate)
        tvExit   = findViewById(R.id.tv_exit)

        tvPlay?.setOnClickListener(this)
        tvAbout?.setOnClickListener(this)
        tvDonate?.setOnClickListener(this)
        tvExit?.setOnClickListener(this)
    }

    private fun exitAlertDialog() {
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

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_play -> {
                tvPlay.let {
                    val intent = Intent(this, PlayerNameActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            R.id.tv_about -> {
//                Toast.makeText(this, "ABOUT - nothing to show", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AboutAppActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.tv_donate -> {
//                Toast.makeText(this, "DONATE - nothing to show", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HowToPlayActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.tv_exit -> {
                exitAlertDialog()
            }
        }
    }
}