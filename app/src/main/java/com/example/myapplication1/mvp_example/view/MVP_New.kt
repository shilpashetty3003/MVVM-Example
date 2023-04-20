package com.example.myapplication1.mvp_example.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication1.MyApplication
import com.example.myapplication1.R
import com.example.myapplication1.databinding.ActivityMvpNewBinding

import com.example.myapplication1.mvp_example.contractor.NewsContractor
import com.example.myapplication1.mvp_example.model.NewsModal
import com.example.myapplication1.mvp_example.presenter.NewsPresenter
import com.example.myapplication1.mvvm_retrofit_room.NewAdapter
import com.example.myapplication1.mvvm_retrofit_room.model.UsersItem

class MVP_New : AppCompatActivity(),NewsContractor.View {


    var newsPresenter:NewsPresenter ? =null
    lateinit var mvpNewBinding: ActivityMvpNewBinding
    lateinit var newsAdapter:NewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setContentView(R.layout.activity_mvp_new)

        mvpNewBinding=ActivityMvpNewBinding.inflate(layoutInflater)
        var view=mvpNewBinding.root
        setContentView(view)
        var userDao=(application as MyApplication).userDao
        newsPresenter= NewsPresenter(this, NewsModal(userDao))
        mvpNewBinding.pbData.visibility= View.GONE
        mvpNewBinding.rvNewsData.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        newsPresenter?.getData()
    }
    override fun showProgress() {
       mvpNewBinding.pbData.visibility=View.VISIBLE
    }

    override fun hideProgress() {
        mvpNewBinding.pbData.visibility=View.GONE
    }

    override fun getError(error: String) {
        Log.d("TAG", "getError: "+error)
    }

    override fun setData(listdata: List<UsersItem>) {
        mvpNewBinding.rvNewsData.layoutManager=LinearLayoutManager(this)
        newsAdapter=NewAdapter(listdata) {
            onItemClick(it)
        }
        mvpNewBinding.rvNewsData.adapter=newsAdapter
        Log.d("TAG", "setData: "+listdata)
    }

    fun onItemClick(usersItem: UsersItem){

        Log.d("TAG", "onItemClick: "+usersItem)
        Toast.makeText(this,usersItem.name,Toast.LENGTH_LONG).show()
    }
}

