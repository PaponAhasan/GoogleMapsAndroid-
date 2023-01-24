package com.example.mapview.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/* Place is marker which is at a particular location on the map
* when tap on that we show a title and description for what is located
* there */

@Parcelize
data class Place(val title: String, val description: String, val latitude: Double, val longitude: Double): Parcelable