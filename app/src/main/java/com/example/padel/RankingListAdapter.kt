package com.example.padel


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.ranking_list_row.view.*


class RankingListAdapter : RecyclerView.Adapter<RankingListViewHolder>() {

    private val rankingListFeed = listOf(
            RankingList("World Padel Tour", "World Padel Tour", "WPT", "MO", "2020-03-02"),
            RankingList("World Padel Tour", "World Padel Tour","WPT", "WO", "2020-03-02"),
            RankingList("Germany", "German Padel Series","Germany", "MO", "2020-08-10"),
            RankingList("Germany", "German Padel Series","Germany", "WO", "2020-08-10"),
            RankingList("Netherlands", "NPB Padelcompetitie","Netherlands", "MO", "2020-03-30"),
            RankingList("Netherlands", "NPB Padelcompetitie","Netherlands", "WO", "2020-03-30"),
            RankingList("Switzerland", "SUIPA Competition","Switzerland", "MO", "2020-03-02"),
            RankingList("Switzerland", "SUIPA Competition","Switzerland", "WO", "2020-03-02"),
            RankingList("Thailand", "Thai Official Padel League","Thailand", "O", "2020-03-02"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingListViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.ranking_list_row, parent, false)
        return RankingListViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: RankingListViewHolder, position: Int) {
        val rankingList = rankingListFeed[position]
        holder?.itemView?.RankingListTitle?.text = rankingList.series
        holder?.itemView?.Division?.text = rankingList.hrDivision()
        holder?.itemView?.imageView.setImageResource(rankingList.getFlagImage())
        holder?.rankingList = rankingList
    }

    override fun getItemCount(): Int {
        return rankingListFeed.count();
    }
}

class RankingListViewHolder (view: View, var rankingList: RankingList? = null) :
        RecyclerView.ViewHolder(view) {

    companion object {
        const val RANKING_TITLE = "RANKING_TITLE"
        const val RANKING_FEDERATION = "RANKING_FEDERATION"
        const val RANKING_DIVISION = "RANKING_DIVISION"
        const val RANKING_DATE = "RANKING_DATE"
        const val RANKING_IMAGE = "RANKING_IMAGE"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, RankingActivity::class.java)

            intent.putExtra(RANKING_TITLE, rankingList?.title)
            intent.putExtra(RANKING_FEDERATION, rankingList?.federation)
            intent.putExtra(RANKING_DIVISION, rankingList?.division)
            intent.putExtra(RANKING_DATE, rankingList?.date)

            view.context.startActivity(intent)
        }
    }
}