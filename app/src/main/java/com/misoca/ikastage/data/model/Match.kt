package com.misoca.ikastage.data.model

import com.squareup.moshi.Json
import java.io.Serializable
import java.text.SimpleDateFormat

data class Match(
        @Json(name = "rule_ex")
        val rule: Rule,
        @Json(name = "maps_ex")
        val maps: List<Map>,
        val start: String,
        val start_utc: String,
        val start_t: String,
        val end: String,
        val end_utc: String,
        val end_t: String
): Serializable {

    val period
        get(): String {
            val formatter = SimpleDateFormat("M/d H:mm")
            return formatter.format(start_t.toLong() * 1000) + " - " + formatter.format(end_t.toLong() * 1000)
        }

}

