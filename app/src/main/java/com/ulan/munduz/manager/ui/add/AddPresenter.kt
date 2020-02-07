package com.ulan.munduz.manager.ui.add

import android.net.Uri
import com.ulan.app.munduz.ui.Product
import com.ulan.app.munduz.data.models.Picture

interface AddPresenter{

    fun setToolbar()
    fun initCategory()
    fun insert(product: Product)
    fun getPictureUrl(filePath: Uri?): Picture
    fun chooseImageButtonClicked()
    fun addButtonClicked()
    fun detachView()


}