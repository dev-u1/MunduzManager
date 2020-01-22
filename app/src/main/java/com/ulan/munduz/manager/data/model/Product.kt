package com.ulan.app.munduz.ui



import android.os.Parcelable
import com.ulan.app.munduz.data.models.Picture
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    var id: String = "",
    var category: String = "",
    var name: String = "",
    var desc: String = "",
    var cost: Int = -1,
    var amount: Int = -1,
    var isVisible: Boolean = false,
    var picture: Picture = Picture(
        "url"
    ),
    var date:  Long = -1)
    : Parcelable



