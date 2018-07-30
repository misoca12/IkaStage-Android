package com.misoca.ikastage.data.model

import android.support.annotation.IntegerRes
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class Coop(
        val start: String,
        val start_utc: String,
        val start_t: String,
        val end: String,
        val end_utc: String,
        val end_t: String,
        val stage: Stage?,
        val weapons: List<Weapon>?
): Serializable {

    val period
      get(): String {
          val formatter = SimpleDateFormat("HH:mm")
          return formatter.format(start_t.toLong() * 1000) + " - " + formatter.format(end_t.toLong() * 1000)
      }

}

