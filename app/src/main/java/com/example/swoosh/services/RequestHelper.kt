package com.example.swoosh.services

import okhttp3.OkHttpClient
import okhttp3.Request

object RequestHelper {

    private val client: OkHttpClient = OkHttpClient()

    fun getStringAsync(url: String): String?{

        try {
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful){
                return response.body!!.string()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }
}