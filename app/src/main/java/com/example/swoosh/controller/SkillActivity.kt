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
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    private lateinit var name: String
    private lateinit var player: Player
    private lateinit var student: Student

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_NAME, name)
        outState.putParcelable(EXTRA_PLAYER, player)
        outState.putSerializable(EXTRA_STUDENT, student)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        name = savedInstanceState.getString(EXTRA_NAME, "")
        player = savedInstanceState.getParcelable(EXTRA_PLAYER) ?: Player("", "")
        student = savedInstanceState.getSerializable(EXTRA_STUDENT) as Student? ?: Student("", 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        name = intent.getStringExtra(EXTRA_NAME) ?: ""
        player = intent.getParcelableExtra(EXTRA_PLAYER) ?: Player("","")
        student = intent.getSerializableExtra(EXTRA_STUDENT) as Student? ?: Student("", 0)
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
