package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import com.example.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    private var league = ""
    private var skill = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = this.intent.getStringExtra(EXTRA_LEAGUE) ?: ""
    }

    fun beginnerButtonClicked(view: View){
        ballerButton.isChecked = false
        skill = setSelectedLeague(view as ToggleButton, R.string.beginnerTxt)
    }

    fun ballerButtonClicked(view: View){
        beginnerButton.isChecked = false
        skill = setSelectedLeague(view as ToggleButton, R.string.ballerTxt)
    }

    fun finishButtonClicked(view: View){
        if(skill != ""){
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, league)
            intent.putExtra(EXTRA_SKILL, skill)
            startActivity(intent)
        }
        else{
            val message = Toast.makeText(this, R.string.selectSkillMessage, Toast.LENGTH_SHORT)
            message.setGravity(Gravity.BOTTOM,0, 200)
            message.show()
        }
    }

}
