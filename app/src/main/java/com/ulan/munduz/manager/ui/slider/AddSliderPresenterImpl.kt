package com.ulan.munduz.manager.ui.slider

import android.graphics.Bitmap
import android.net.Uri
import com.ulan.munduz.manager.data.model.SliderImage
import com.ulan.munduz.manager.data.repository.Repository
import com.ulan.munduz.manager.data.repository.Storage

class AddSliderPresenterImpl : AddSliderPresenter{

    private var mView: AddSliderView?
    private var mStorage: Storage
    private var mRepository: Repository

    constructor(mView: AddSliderView, mStorage: Storage, mRepository: Repository) {
        this.mView = mView
        this.mStorage = mStorage
        this.mRepository = mRepository
    }

    override fun setSliderImage(filePath: Uri?) {
        mStorage.insertSliderImage(filePath!!)
    }

    override fun insertToDatabase(name: String){
        mRepository.insertSliderImage(name, getSliderImage())
    }

    private fun getSliderImage(): SliderImage {
        return mStorage.getInsertedSliderImage()
    }

    override fun detachView() {
        mView = null
    }

}