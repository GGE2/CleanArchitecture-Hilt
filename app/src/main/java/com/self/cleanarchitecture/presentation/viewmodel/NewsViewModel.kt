package com.self.cleanarchitecture.presentation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.self.cleanarchitecture.data.model.APIResponse
import com.self.cleanarchitecture.data.util.Resource
import com.self.cleanarchitecture.domain.usecase.GetNewHeadlineUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    val getNewsHeadlinesUseCase : GetNewHeadlineUseCase
) : AndroidViewModel(app){
    val newsHeadLines : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country:String,page:Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadLines.postValue(apiResult)
            } else {
                newsHeadLines.postValue(Resource.Error("Internet is not Available"))
            }
        }catch (e:Exception){
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }


    }
    @SuppressLint("ServiceCast")
    private fun isNetworkAvailable(context: Context) : Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

}