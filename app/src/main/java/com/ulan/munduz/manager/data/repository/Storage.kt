package com.ulan.munduz.manager.data.repository

import android.net.Uri
import com.ulan.app.munduz.data.models.Picture

interface Storage {

    fun insertImage(filePath: Uri): Picture
    fun removeImage(picture: Picture)
}