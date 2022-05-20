package com.example.tugaslistnewjumat.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugaslistnewjumat.model.GetAllNewsItem
import com.example.tugaslistnewjumat.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel() {
    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsItem>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLiveNews():MutableLiveData<List<GetAllNewsItem>>{
        return liveDataNews
    }

    fun getNewsAPI(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsItem>>,
                    response: Response<List<GetAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }
}