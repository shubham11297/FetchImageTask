package com.example.fetchimagetask.network

import com.example.fetchimagetask.data.ImagesDataItem
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://picsum.photos/"

private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

val okHttp = OkHttpClient.Builder()
    .addInterceptor(logger)

interface ApiServices {

//    @Headers("Content-Type: application/json")
    @GET("v2/list?page=1&limit=100")
    suspend fun getImagesData() : Response<ArrayList<ImagesDataItem>>

    companion object {
        val gson = Gson()
        operator fun invoke(): ApiServices {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttp.build())
                .build()
                .create(ApiServices::class.java)
        }
    }
}