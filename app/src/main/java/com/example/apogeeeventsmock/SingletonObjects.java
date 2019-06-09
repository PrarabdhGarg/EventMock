package com.example.apogeeeventsmock;

import com.example.apogeeeventsmock.data.room.EventsDatabase;
import retrofit2.Retrofit;

public class SingletonObjects {

    public static Retrofit eventsRetrofit = null;

    public static EventsDatabase eventsDatabase = null;

}
