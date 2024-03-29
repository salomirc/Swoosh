package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.model.Student
import com.example.swoosh.utilities.EXTRA_NAME
import com.example.swoosh.utilities.EXTRA_PLAYER
import com.example.swoosh.utilities.EXTRA_STUDENT
import kotlinx.android.synthetic.main.activity_league.*
import java.util.*

class LeagueActivity : BaseActivity() {

    private var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER) ?: Player("", "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        NextButton.text = NextButton.text.toString().toUpperCase(Locale.getDefault())
    }

    fun mensLeagueButtonClicked(view: View) {
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        player.league = setSelectedLeague(view as ToggleButton, R.string.mensTxt)
    }

    fun womensLeagueButtonClicked(view: View) {
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        player.league = setSelectedLeague(view as ToggleButton, R.string.womensTxt)
    }

    fun coedLeagueButtonClicked(view: View) {
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false
        player.league = setSelectedLeague(view as ToggleButton, R.string.co_edTxt)
    }

    fun nextButtonClicked(view: View) {
        if (player.league != "")
        {
            val intent = Intent(this, SkillActivity::class.java)
            intent.putExtra(EXTRA_NAME, "John")
            intent.putExtra(EXTRA_PLAYER, player)
            intent.putExtra(EXTRA_STUDENT, Student("Ciprian", 25))
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
