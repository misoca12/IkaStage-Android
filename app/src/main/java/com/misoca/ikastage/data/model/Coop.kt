package com.misoca.ikastage.data.model

import java.io.Serializable

data class Coop(
        val start: String,
        val start_utc: String,
        val start_t: String,
        val end: String,
        val end_utc: String,
        val end_t: String,
        val stage: Stage?,
        val weapons: List<Weapon>?
): Serializable
