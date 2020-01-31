package com.ulan.munduz.manager.data.repository

import android.net.Uri
import com.ulan.app.munduz.data.models.Picture
import com.ulan.munduz.manager.data.model.SliderImage

interface Storage {

    fun insertImage(filePath: Uri): Picture
    fun insertSliderImage(filePath: Uri)
    fun getInsertedSliderImage(): SliderImage
    fun removeImage(picture: Picture)
}