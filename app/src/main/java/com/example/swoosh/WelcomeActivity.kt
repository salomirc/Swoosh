package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*
import kotlin.reflect.typeOf

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val getStartedUppercase = GetStartedButton.text.toString().toUpperCase(Locale.getDefault())
        GetStartedButton.text = getStartedUppercase

        GetStartedButton.setOnClickListener{
            var intent = Intent(this, LeagueActivity::class.java)
            startActivity(intent)
        }
    }
}
