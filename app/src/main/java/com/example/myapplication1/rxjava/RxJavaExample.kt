package com.example.myapplication1.rxjava

import android.annotation.SuppressLint
import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.myapplication1.R
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.Observer

import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RxJavaExample : AppCompatActivity() {
    val TAG = "RXJAVA"
    lateinit var btnClick: Button

    @SuppressLint("MissingInflatedId", "CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_jjava_example)


//        implementRXJava()
//        setUpOnservable()
//        createObserable()

        doSomeWork()
    }

    private fun doSomeWork() {
        val observableA = io.reactivex.Observable.fromArray("A1", "B1")
        val observableB = io.reactivex.Observable.fromArray("A2", "B2")
        //io.reactivex.Observable.concat(observableA,observableB).subscribe(getObserver())
        //getObservable().delay(5, TimeUnit.SECONDS).subscribe(getObserver())
        io.reactivex.Observable.just(1, 2, 3, 5, 4, 6, 7, 8, 9)
            .filter { value ->
                return@filter value % 2 == 0
            }.subscribe(getObserver())

    }

    fun getObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

            override fun onNext(t: Int) {
                Log.d(TAG, "onNext: " + t.toString())
            }

        }
    }

    fun getObservable(): io.reactivex.Observable<String> {
        return io.reactivex.Observable.just("A", "B")
    }

//    @SuppressLint("CheckResult")
//    private fun implementRXJava() {
//        var retrofit = Retrofit.Builder().baseUrl("https://fakestoreapi.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
//
//        val productService = retrofit.create(ProductService::class.java)
//        productService.getProducts().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread()).subscribe {
//                Log.d("TAG", "implementRXJava: " + it)
//            }
//    }
}


