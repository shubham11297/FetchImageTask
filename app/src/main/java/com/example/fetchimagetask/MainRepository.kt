package com.example.fetchimagetask

import android.app.Application
import com.example.fetchimagetask.network.ApiServices

class MainRepository(application: Application) {

    val api = ApiServices()

    suspend fun getImagesData() = api.getImagesData()

}