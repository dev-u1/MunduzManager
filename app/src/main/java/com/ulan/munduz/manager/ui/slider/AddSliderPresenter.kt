package com.ulan.munduz.manager.ui.slider

import android.net.Uri

interface AddSliderPresenter{

    fun setSliderImage(filePath: Uri?)
    fun insertToDatabase(name: String)
    fun detachView()

}