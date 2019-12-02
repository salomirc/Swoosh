package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*
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
        selectedLeague = setSelectedLeague(view as ToggleButton, R.string.mensTxt)
    }

    fun womensLeagueButtonClicked(view: View) {
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        selectedLeague = setSelectedLeague(view as ToggleButton, R.string.womensTxt)
    }

    fun coedLeagueButtonClicked(view: View) {
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false
        selectedLeague = setSelectedLeague(view as ToggleButton, R.string.co_edTxt)
    }

    fun nextButtonClicked(view: View) {
        if (selectedLeague != "")
        {
            val intent = Intent(this, SkillActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(intent)
        }
        else
        {
            val message = Toast.makeText(this, R.string.selectLeagueMessage, Toast.LENGTH_SHORT)
            message.setGravity(Gravity.BOTTOM,0, 200)
            message.show()
        }
    }
}
