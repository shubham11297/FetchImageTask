package com.example.fetchimagetask.data

data class ImagesDataItem(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
)