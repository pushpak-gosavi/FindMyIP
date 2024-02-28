package com.pushpak.findmyip.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val ip:String,
    val city:String,
)
