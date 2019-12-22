package com.example.swoosh.services

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import java.lang.Exception

object InternetHelper : Activity() {

    fun hasInternetConnection() : Boolean{
        try {
            val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
        catch (e: Exception)
        {
            println("Exception : ${e.message}")
        }

        return false
    }
}