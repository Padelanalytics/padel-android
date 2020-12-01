// Francisco Javier Revilla Linares. Copyright (c) 2020 . All rights reserved.
package com.example.padel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.ranking_row.view.*

class RankingAdapter(val rankingFeed: Array<RankingRow>): RecyclerView.Adapter<RankingViewHolder>() {

    private val rankingRows = listOf(
        Triple(1, "Francisco Revilla", 1500),
        Triple(2, "Jasper Ahrens", 1000),
        Triple(3, "Satan", 500)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.ranking_row, parent, false)
        return RankingViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return rankingFeed.count();
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val rankingRow = rankingFeed[position]
        holder?.itemView?.rankingPosition?.text = rankingRow.position.toString()
        holder?.itemView?.rankingPlayerName?.text =
            rankingRow.person.first_name + " " + rankingRow.person.last_name
        holder?.itemView?.rankingPoints?.text = rankingRow.points.toString()
    }
}

class RankingViewHolder(v: View): RecyclerView.ViewHolder(v){}
