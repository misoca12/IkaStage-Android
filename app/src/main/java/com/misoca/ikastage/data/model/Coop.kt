package com.misoca.ikastage.data.model

import java.io.Serializable
import java.text.SimpleDateFormat

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
            val formatter = SimpleDateFormat("M/d H:mm")
            return formatter.format(start_t.toLong() * 1000) + " - " + formatter.format(end_t.toLong() * 1000)
        }

    val stageName
        get(): String? {
            stage ?: return null
            return stage.name
        }

    val stageImageUrl
        get(): String? {
            stage ?: return null
            return stage.image
        }

    val hasDetail
        get(): Boolean {
            return (stage is Stage) and (weapons is List<Weapon>)
        }

}

