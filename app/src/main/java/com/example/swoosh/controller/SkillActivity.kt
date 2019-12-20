package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    //var player = Player("", "")
    private lateinit var player: Player


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = this.intent.getParcelableExtra(EXTRA_PLAYER) ?: Player("","")
    }

    fun beginnerButtonClicked(view: View){
        ballerButton.isChecked = false
        player.skill = setSelectedLeague(view as ToggleButton, R.string.beginnerTxt)
    }

    fun ballerButtonClicked(view: View){
        beginnerButton.isChecked = false
        player.skill = setSelectedLeague(view as ToggleButton, R.string.ballerTxt)
    }

    fun finishButtonClicked(view: View){
        if(player.skill != ""){
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_PLAYER, player)
            startActivity(intent)
        }
        else{
            val message = Toast.makeText(this, R.string.selectSkillMessage, Toast.LENGTH_SHORT)
            message.setGravity(Gravity.BOTTOM,0, 200)
            message.show()
        }
    }

}
