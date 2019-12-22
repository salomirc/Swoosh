package com.example.swoosh.controller

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.DUMMY_TEXT
import com.example.swoosh.utilities.EXTRA_PLAYER
import com.example.swoosh.services.InternetHelper
import com.example.swoosh.services.RequestHelper
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.coroutines.*

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
                if(hasInternetConnection())
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

    suspend fun makeHTTPRequestGET(ulr: String) : String{

        delay(5000)
        return DUMMY_TEXT
    }
}
