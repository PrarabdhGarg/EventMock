package com.example.apogeeeventsmock

import com.example.apogeeeventsmock.data.retrofit.EventsPOJO

interface MainContract {

    interface EventsPresenter{

        fun initalizePresenter()

        fun fetchEvents() : List<EventsPOJO>

        fun destroy()

    }

    interface EventsView {

        fun initializeView()

        fun displayError(message : String)

        fun displayEvents(list : List<EventsPOJO>)

    }

}