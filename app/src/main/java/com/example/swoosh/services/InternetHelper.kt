package com.example.swoosh.services

import android.content.Context
import android.net.ConnectivityManager

object InternetHelper {

    fun hasInternetConnection(context: Context) : Boolean{
        try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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