// Francisco Javier Revilla Linares. Copyright (c) 2020 . All rights reserved.
package com.example.padel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewRanking.layoutManager = LinearLayoutManager(this)
        val title = intent.getStringExtra(RankingListViewHolder.RANKING_TITLE)
        val federation = intent.getStringExtra(RankingListViewHolder.RANKING_FEDERATION)
        val division = intent.getStringExtra(RankingListViewHolder.RANKING_DIVISION)
        val date = intent.getStringExtra(RankingListViewHolder.RANKING_DATE)
        supportActionBar?.title = title
        println("${title}, ${federation}, ${division}, ${date}")
        fetchJson(federation, division, date)
    }

    private fun fetchJson(federation : String?, division : String?, date : String?) {
        val url = "https://www.padelanalytics.com/api/ranking?federation=${federation}&division=${division}&date=${date}"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val rankingFeed : Array<RankingRow> =
                        gson.fromJson(body, Array<RankingRow>::class.java)
                //recyclerViewRanking.adapter = RankingAdapter(rankingFeed)
                runOnUiThread {
                    recyclerViewRanking.adapter = RankingAdapter(rankingFeed)
                }

            }
        })
    }

}