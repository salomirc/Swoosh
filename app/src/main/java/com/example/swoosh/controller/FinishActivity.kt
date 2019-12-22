package com.example.swoosh.controller

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.services.InternetHelper
import com.example.swoosh.services.RequestHelper
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Suppress("DEPRECATION")
class FinishActivity : BaseActivity() {

    private var toggle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = this.intent.getParcelableExtra(EXTRA_PLAYER) ?: Player("","")

        searchLeaguesText.text = this.getString(R.string.FinishActivityMessageTxt, player.league, player.skill)
        //exampleGlobalScopeLaunch()
    }

    fun onGetDataButtonClicked(view: View){
        runBlocking(){

            //GLOBAL SCOPE
            GlobalScope.launch(Dispatchers.IO) {
                if(InternetHelper.hasInternetConnection(this@FinishActivity))
                {
                    runOnUiThread {
                        progressBar.visibility = VISIBLE
                        resultsTextView.text = ""
                    }
                    val result = RequestHelper.getStringAsync("https://publicobject.com/helloworld.txt")
                    runOnUiThread {
                        progressBar.visibility = GONE
                        resultsTextView.text = "$result \n\n ${Thread.currentThread().name}"
                    }
                }
                else
                {
                    runOnUiThread{
                        val message = Toast.makeText(this@FinishActivity, R.string.noInternetConnection, Toast.LENGTH_SHORT)
                        message.setGravity(Gravity.BOTTOM,0, 200)
                        message.show()
                    }
                }
            }

        }
        getDataButton.setBackgroundColor(Color.MAGENTA)
    }

    fun onGetDataButtonRightClicked(view: View){
        if(toggle) getDataButtonRight.setBackgroundColor(Color.MAGENTA) else getDataButtonRight.setBackgroundColor(Color.YELLOW)
        toggle = !toggle
    }
}
