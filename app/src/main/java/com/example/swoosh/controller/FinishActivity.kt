package com.example.swoosh.controller

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.DUMMY_TEXT
import com.example.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.coroutines.*

class FinishActivity : AppCompatActivity() {

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
            GlobalScope.launch(Dispatchers.Main) {
                val result = makeHTTPRequestGET("www.example.com")
                progressBar.visibility = GONE
                resultsTextView.text = "$result \n\n ${Thread.currentThread().name}"
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

//    fun exampleGlobalScopeLaunch() = runBlocking(){
//
//        val defered1 = GlobalScope.launch(Dispatchers.Main) {
//            val result = makeHTTPRequestGET("www.example.com")
//            progressBar.visibility = GONE
//            resultsTextView.text = "$result \n\n ${Thread.currentThread().name}"
//        }
//    }

//    fun exampleAyncAwait() = runBlocking(){
//
//        val result = async { makeHTTPRequestGET("www.example.com")}.await()
//        progressBar.visibility = GONE
//        resultsTextView.text = "$result \n\n ${Thread.currentThread().name}"
//    }
}
