package com.example.fetchimagetask

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.fetchimagetask.utils.Coroutines

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MainRepository = MainRepository(application)
    val imagesList: MutableList<String> = mutableListOf()
    var imagesRetrieved = MutableLiveData<Boolean>().apply { postValue(false) }

    fun fetchData(){
//        var data : ArrayList<ImagesDataItem>? = null
        Coroutines.io {
            val response = getImagesData()
            if (response.isSuccessful){
                response.body()?.forEach {
                    imagesList.add(it.download_url) }
                imagesRetrieved.postValue(true)
            }

        }
    }

    private suspend fun getImagesData() = repository.getImagesData()
}