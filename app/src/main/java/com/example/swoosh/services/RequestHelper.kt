package com.example.swoosh.services

import GitInfo
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


object RequestHelper {

    private val client = OkHttpClient()

    fun getString(url: String): String?{

        try {
            val request = Request.Builder().url(url).build()
            client.newCall(request).execute().use {
                if (it.isSuccessful) return it.body!!.string()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }

    fun getGist(url: String): String?{

        try {
            val request = Request.Builder().url(url).build()
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful){
                    val gitInfo = Gson().fromJson(response.body!!.string(), GitInfo::class.java)

                    val sb: StringBuilder = StringBuilder()
                    sb.append("${gitInfo.url} \n\n ${gitInfo.id} \n\n")
                    return sb.toString()
                }
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }
}