package com.example.apogeeeventsmock.presenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.room.Room
import com.example.apogeeeventsmock.MainContract
import com.example.apogeeeventsmock.SingletonObjects
import com.example.apogeeeventsmock.data.retrofit.EventsApi
import com.example.apogeeeventsmock.data.retrofit.EventsPOJO
import com.example.apogeeeventsmock.data.room.EventsDataClassRoom
import com.example.apogeeeventsmock.data.room.EventsDatabase
import com.example.apogeeeventsmock.view.MainActivity
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsPresenter(val view : MainActivity) : MainContract.EventsPresenter{

    val BASE_URL = "https://bits-apogee.org/"
    var list : List<EventsPOJO> = emptyList()

    override fun initalizePresenter() {
        if (SingletonObjects.eventsRetrofit == null)
        {
            SingletonObjects.eventsRetrofit = Retrofit.Builder()
                                                .baseUrl(BASE_URL)
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                                .build()
        }

        if (SingletonObjects.eventsDatabase == null)
        {
            SingletonObjects.eventsDatabase = Room.databaseBuilder<EventsDatabase>(view.getApplicationContext(),
                                                                                     EventsDatabase::class.java!!,
                                                                               "EventsDatabase")
                                                  .allowMainThreadQueries()
                                                  .build()
        }
    }

    @SuppressLint("CheckResult")
    override fun fetchEvents(): List<EventsPOJO> {

        /*SingletonObjects.eventsDatabase.eventsDao().getEvents().
            subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).
            subscribe {
                it.forEach {event ->
                    Log.d("Database Fetch" , "OnNext Called with ${event.id}")
                }
            }*/

        // val obData = SingletonObjects.eventsDatabase.eventsDao().getEvents() as Observable<List<EventsDataClassRoom>>
        val obNetwork = SingletonObjects.eventsRetrofit.create(EventsApi::class.java).fetchEvents().
            subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).
            subscribe(
                {events ->
                    events.forEach {
                        Log.d("Network Fetch" , "Fetched item is ${it.id} \t ${it.name}")
                    }
                },
                {
                    Log.e("Network Fetch" , "Error occoured ${it}")
                },
                {
                    Log.d("Network Fetch" , "OnComplete Called")
                }
            )
        /*io.reactivex.Observable.mergeDelayError(obData , obNetwork).
            subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).
            subscribe {
                Log.d("Final  Fetch" , "Fetched item is $it")
            }*/
        return emptyList()
    }

    override fun destroy() {

    }

}