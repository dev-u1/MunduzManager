package com.ulan.munduz.manager.ui.detail

import android.net.Uri
import com.ulan.app.munduz.ui.Product
import com.ulan.app.munduz.data.models.Picture
import com.ulan.munduz.manager.data.repository.Repository
import com.ulan.munduz.manager.data.repository.Storage
import javax.inject.Inject

class DetailsPresenterImpl : DetailsPresenter{

    private var mView: DetailsView? = null
    private var mRepository: Repository
    private var mStorage: Storage

    @Inject
    constructor(view: DetailsView, repository: Repository, storage: Storage) {
        this.mView = view
        this.mRepository = repository
        this.mStorage = storage
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

    override fun setDialog() {
        mView?.showDialog()
    }

    override fun getPictureUrl(filePath: Uri?): Picture {
        return mStorage.insertImage(filePath!!)
    }

    override fun updateButtonClicked() {
        val product = mView!!.getInputProduct()
        mRepository.updateProduct(product)
    }

    override fun deleteButtonClicked(product: Product) {
        mRepository.removeProduct(product.id)
    }

    override fun chooseImageButtonClicked() {
        mView?.chooseImage()
    }

    override fun detachView() {
        mView = null
    }
}
