package com.example.mapview.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserMaps(val title: String, val places: List<Place>) : Parcelable
