package com.pushpak.findmyip.remote

import com.pushpak.findmyip.domain.model.Data
import retrofit2.http.GET

interface IPAPI {
    @GET("/json")
    suspend fun getData():Data
}