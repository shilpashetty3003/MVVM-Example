package com.example.myapplication1.coroutines.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication1.coroutines.data.api.APIInterface
import com.example.myapplication1.coroutines.data.model.Mock_UserItem
import com.example.myapplication1.coroutines.ui.room.LocalUser
import com.example.myapplication1.coroutines.utils.ResponseState
import kotlinx.coroutines.*

class SingleNetworkVIewModel(var apiInterface: APIInterface, var localUser: LocalUser) :
    ViewModel() {

    var apiData = MutableLiveData<ResponseState<List<Mock_UserItem>>>()
    var handleError = CoroutineExceptionHandler { _, throwable ->

        apiData.postValue(ResponseState.Failure("${throwable.toString()}"))

    }


    init {
        viewModelScope.launch() {
            apiData.postValue(ResponseState.Loading())


            //Exception Handle
//            var userList = apiInterface.getError()
//            apiData.postValue(ResponseState.Success(userList))

            // try catch
//            try {
//                var userList = apiInterface.getError()
//                apiData.postValue(ResponseState.Success(userList))
//
//            } catch (error: Exception) {
//                apiData.postValue(ResponseState.Failure("${error.toString()}"))
//            }

            // with timeout
            try {
                withTimeout(100) {
                    var userList=apiInterface.getUsers()
                    apiData.postValue(ResponseState.Success(userList))
                }
            } catch (e: TimeoutCancellationException) {
                apiData.postValue(ResponseState.Failure("${e.toString()}"))
            } catch (e: Exception) {
                apiData.postValue(ResponseState.Failure("${e.toString()}"))
            }
            //Single Network
//            try{
//                var result=apiInterface.getUsers()
//                apiData.postValue(ResponseState.Success(result))
//            }
//            catch (error:java.lang.Error){
//                apiData.postValue(ResponseState.Failure("Error"))
//            }


            // Series Network
//            try {
//                var userList = apiInterface.getUsers()
//                var userAllList = apiInterface.getAllUsers()
//
//                var mockData = mutableListOf<Mock_UserItem>()
//                mockData.addAll(userList)
//                mockData.addAll(userAllList)
//                apiData.postValue(ResponseState.Success(mockData))
//
//
//            } catch (error: java.lang.Error) {
//                apiData.postValue(ResponseState.Failure(error.toString()))
//            }


            // Parallel Network
//            try {
//                coroutineScope {
//                    var userList=async {apiInterface.getUsers()  }
//                    var userAllList=async { apiInterface.getAllUsers() }
//
//                    var mockList= mutableListOf<Mock_UserItem>()
//                    mockList.addAll(userList.await())
//                    mockList.addAll(userAllList.await())
//                    apiData.postValue(ResponseState.Success(mockList))
//                }
//
//            } catch (error: java.lang.Error) {
//                    apiData.postValue(ResponseState.Failure(error.toString()))
//            }

            //Room DB

//            try {
//
//                var localData = localUser.getAllUser()
//                if (localData.isEmpty()) {
//                    var apiUserData = apiInterface.getUsers()
//                    var mockUserList = mutableListOf<Mock_UserItem>()
//                    mockUserList.addAll(apiUserData)
//                    localUser.insertUser(apiUserData)
//                    apiData.postValue(ResponseState.Success(mockUserList))
//                }
//                apiData.postValue(ResponseState.Success(localData))
//
//            } catch (error: Error) {
//                apiData.postValue(ResponseState.Failure(error.toString()))
//            }

            // Supervisor

//            supervisorScope {
//                val userFromDeffered = async { apiInterface.getError() }
//                val moreUserDeffered = async { apiInterface.getAllUsers() }
//
//                var userFromAPI = try {
//                    userFromDeffered.await()
//                } catch (error: Exception) {
//                    emptyList()
//                }
//
//                var moreUserFromAPI = try {
//                    moreUserDeffered.await()
//                } catch (error: Exception) {
//                    emptyList()
//                }
//                var mockList = mutableListOf<Mock_UserItem>()
////                mockList.addAll(userFromAPI)
//                mockList.addAll(moreUserFromAPI)
//                apiData.postValue(ResponseState.Success(mockList))
//            }
        }
    }

    fun getUserDetails(): LiveData<ResponseState<List<Mock_UserItem>>> = apiData

}