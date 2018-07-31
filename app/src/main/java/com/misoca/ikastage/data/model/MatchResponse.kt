package com.misoca.ikastage.data.model

import java.io.Serializable

data class MatchResponse(
        val result: List<Match>?
): Serializable
