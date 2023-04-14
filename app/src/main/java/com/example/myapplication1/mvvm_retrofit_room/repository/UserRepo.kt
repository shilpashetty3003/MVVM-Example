package com.example.myapplication1.mvvm_retrofit_room.repository

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication1.mvvm_retrofit_room.db.UserDao
import com.example.myapplication1.mvvm_retrofit_room.model.Users
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem
import com.example.myapplication1.mvvm_retrofit_room.network.UserAPI
import retrofit2.Response


class UserRepo(var userAPI:UserAPI,var userDao: UserDao,var contexts: Context) {

   public var  apiResult=MutableLiveData<List<UsersItem>>()

    suspend fun insertData(usersItem: List<UsersItem>){
        userDao.insertUser(usersItem)

    }

    suspend fun getUserDetails(){

        if(isOnline(contexts)){
            var result=userAPI.getUsers()
            Log.d("TAG", "getUserDetails: "+result.body())
            if(result!=null){
                result.body()?.let { userDao.insertUser(it) }

                apiResult.postValue(result.body())

                Log.d("TAG", "getUserDetails: "+apiResult.value)
            }
        }
        else{
           apiResult.postValue(userDao.getUsers())
        }
    }
    @SuppressLint("ServiceCast")
    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}