package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_skill.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = this.intent.getParcelableExtra(EXTRA_PLAYER) ?: Player("","")

        searchLeaguesText.text = this.getString(R.string.FinishActivityMessageTxt, player.league, player.skill)

    }
}
