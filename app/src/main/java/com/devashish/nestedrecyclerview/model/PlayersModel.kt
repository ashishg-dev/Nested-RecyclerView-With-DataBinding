package com.devashish.nestedrecyclerview.model

import com.devashish.nestedrecyclerview.enums.PlayerType

data class PlayersModel(
    val name: String,
    val type: PlayerType,
    val isCaptain: Boolean
)