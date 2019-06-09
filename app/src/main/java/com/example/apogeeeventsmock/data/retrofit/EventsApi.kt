package com.example.apogeeeventsmock.data.retrofit

import io.reactivex.Observable
import retrofit2.http.GET

interface EventsApi {

    @GET("2019/registrations/events/")
    fun fetchEvents() : Observable<List<EventsPOJO>>

}