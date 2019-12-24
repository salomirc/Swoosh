package com.example.swoosh.services

import GitInfo
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request


object RequestHelper {

    private val client = OkHttpClient()

    //For custom Types you have to .add(KotlinJsonAdapterFactory())
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val gitInfoJsonAdapter = moshi.adapter(GitInfo::class.java)

    // For Colections use this:
    // private val type = Types.newParameterizedType(MutableList::class.java, GitInfo::class.java)
    // private val gistJsonAdapter: JsonAdapter<List<GitInfo>> = moshi.adapter(type)

    fun getString(url: String): String?{

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

    fun getGist(url: String): String?{

        try {
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful){
//                val gitInfo = gitInfoJsonAdapter.fromJson(response.body!!.source())
                val gitInfo = Gson().fromJson(response.body!!.string(), GitInfo::class.java)

                val sb: StringBuilder = StringBuilder()
                sb.append("${gitInfo!!.url} \n\n ${gitInfo!!.id} \n\n")
                return sb.toString()
            }
        }
        catch (e: Exception){
            println("Exception : ${e.message}")
        }
        return null
    }
}