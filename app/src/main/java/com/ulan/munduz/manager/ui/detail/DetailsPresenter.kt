package com.ulan.munduz.manager.ui.detail

import android.net.Uri
import com.ulan.app.munduz.ui.Product
import com.ulan.app.munduz.data.models.Picture

interface DetailsPresenter {

    fun detachView()
    fun initCategory()
    fun setToolbar()
    fun showProduct(product: Product)
    fun getPictureUrl(filePath: Uri?): Picture
    fun updateButtonClicked()
    fun deleteButtonClicked(product: Product)
    fun chooseImageButtonClicked()
    fun findCategoryPosition(category: String): Int

}