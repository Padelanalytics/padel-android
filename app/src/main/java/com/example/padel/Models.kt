// Francisco Javier Revilla Linares. Copyright (c) 2020 . All rights reserved.
package com.example.padel

class RankingList (
        val title: String,
        val series: String,
        val federation: String,
        val division: String,
        val date: String) {

    fun getFlagImage() : Int {
        var result : Int = -1

        when(this.title.toLowerCase()) {
            "germany" -> result = R.drawable.germany
            "netherlands" -> result = R.drawable.netherlands
            "switzerland" -> result = R.drawable.switzerland
            "thailand" -> result = R.drawable.thailand
            "world padel tour" -> result = R.drawable.international_fed
        }

        return result
    }

    fun hrDivision() : String {
        var result = ""

        when(this.division) {
            "MO" -> result = "Men Open"
            "WO" -> result = "Women Open"
            "O" -> result = "Men and Women Open"
        }
        return result
    }
}

class RankingRow(val position: Int, val person: RankingPerson, val points: Int)

class RankingPerson(val first_name: String, val last_name: String)