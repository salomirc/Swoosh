package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class LeagueActivity : BaseActivity() {

    var selectedLeague: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        NextButton.text = NextButton.text.toString().toUpperCase(Locale.getDefault())
    }

    fun mensLeagueButtonClicked(view: View) {
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        selectedLeague = "mens"
    }

    fun womensLeagueButtonClicked(view: View) {
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        selectedLeague = "womens"
    }

    fun coedLeagueButtonClicked(view: View) {
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false
        selectedLeague = "co-ed"
    }

    fun nextButtonClicked(view: View) {
        if (selectedLeague != "")
        {
            var intent = Intent(this, SkillActivity::class.java)
            intent.putExtra("SELECTED", selectedLeague)
            startActivity(intent)
        }
        else
        {
            var message = Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT)
            message.setGravity(Gravity.BOTTOM,0, 200)
            message.show()
        }
    }
}
