package com.example.apogeeeventsmock.data.retrofit

import com.google.gson.annotations.SerializedName

class EventsPOJO {

    @SerializedName("id") val id : Long = 0

    @SerializedName("name") val name : String = ""

    @SerializedName("venue") val venue : String = ""

    @SerializedName("about") val about : String = ""

    @SerializedName("rules") val rules : String = ""

    @SerializedName("date_time") val date_time : String = ""

    @SerializedName("duration") val duration : Int = 0

}