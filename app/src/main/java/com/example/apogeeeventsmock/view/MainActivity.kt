package com.example.apogeeeventsmock.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apogeeeventsmock.MainContract
import com.example.apogeeeventsmock.R
import com.example.apogeeeventsmock.data.retrofit.EventsPOJO
import com.example.apogeeeventsmock.presenter.EventsPresenter

class MainActivity : AppCompatActivity() , MainContract.EventsView{

    var presenter : EventsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()

        presenter?.fetchEvents()
    }

    override fun initializeView() {
        presenter = EventsPresenter(this)
        presenter!!.initalizePresenter()
    }

    override fun displayError(message: String) {
        Toast.makeText(this , "Please Retry\n$message" , Toast.LENGTH_LONG).show()
    }

    override fun displayEvents(list: List<EventsPOJO>) {

    }


}
