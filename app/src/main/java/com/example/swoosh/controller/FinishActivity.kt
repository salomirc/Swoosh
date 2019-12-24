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
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("DEPRECATION")
class FinishActivity : BaseActivity() {

    private var toggle: Boolean = false
//    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val moshi = Moshi.Builder().build()
    val type = Types.newParameterizedType(MutableList::class.java, String::class.java)
    val adapter = moshi.adapter<MutableList<String>>(type)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = this.intent.getParcelableExtra(EXTRA_PLAYER) ?: Player("","")

        searchLeaguesText.text = this.getString(R.string.FinishActivityMessageTxt, player.league, player.skill)
        //exampleGlobalScopeLaunch()
    }

    fun onGetDataButtonClicked(view: View){
        if(InternetHelper.hasInternetConnection(this@FinishActivity))
        {
            progressBar.visibility = VISIBLE
            resultsTextView.text = ""

            CoroutineScope(Dispatchers.IO).launch(){
//               val result = RequestHelper.getString("https://publicobject.com/helloworld.txt")
               val result = RequestHelper.getGist("https://api.github.com/gists/c2a7c39532239ff261be")

                withContext(Dispatchers.Main) {
                    progressBar.visibility = GONE

                    val items = mutableListOf<String>("Apple", "Pear", "Banana")
                    val jsonStr = adapter.toJson(items)
                    val newItems = adapter.fromJson(jsonStr)
                    resultsTextView.text = "$result \n\n ${Thread.currentThread().name}  \n\n $jsonStr \n\n ${newItems.toString()}"
                }
            }

        }
        else
        {
            val message = Toast.makeText(this@FinishActivity, R.string.noInternetConnection, Toast.LENGTH_SHORT)
            message.setGravity(Gravity.BOTTOM,0, 200)
            message.show()
        }
        getDataButton.setBackgroundColor(Color.MAGENTA)
    }

    fun onGetDataButtonRightClicked(view: View){
        if(toggle) getDataButtonRight.setBackgroundColor(Color.MAGENTA) else getDataButtonRight.setBackgroundColor(Color.YELLOW)
        toggle = !toggle
    }
}
