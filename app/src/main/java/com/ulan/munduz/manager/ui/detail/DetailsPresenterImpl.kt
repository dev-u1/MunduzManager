package com.ulan.munduz.manager.ui.detail

import android.net.Uri
import com.ulan.app.munduz.ui.Product
import com.ulan.app.munduz.data.models.Picture
import com.ulan.munduz.manager.data.repository.Repository
import com.ulan.munduz.manager.data.repository.Storage

class DetailsPresenterImpl : DetailsPresenter{

    private var mView: DetailsView? = null
    private var mRepository: Repository
    private var mStorage: Storage
    private lateinit var mProduct: Product

    constructor(repository: Repository, storage: Storage) {
        this.mRepository = repository
        this.mStorage = storage
    }

    override fun attachView(view: DetailsView) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    override fun initCategory() {
        val categories = mRepository.getCategories()
        mView?.setCategories(categories)
    }

    override fun findCategoryPosition(category: String): Int {
        val categories = mRepository.getCategories()
        var position = 0
        for ((index, value) in categories.withIndex()){
            if(category == value){
                position =  index
            }
        }
        return position
    }

    override fun setToolbar() {
        mView?.initToolbar("Details")
    }

    override fun showProduct(product: Product) {
        mView?.setProduct(product)
    }

    override fun getPictureUrl(filePath: Uri?): Picture {
        return mStorage.insertImage(filePath!!)
    }

    override fun updateButtonClicked() {
        mProduct = mView!!.getInputProduct()
        mRepository.updateProduct(mProduct)
    }

    override fun deleteButtonClicked() {
        mRepository.removeProduct(mProduct.id)
    }

    override fun chooseImageButtonClicked() {
        mView?.chooseImage()
    }
}