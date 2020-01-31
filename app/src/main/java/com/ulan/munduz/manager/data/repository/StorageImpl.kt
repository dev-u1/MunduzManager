package com.ulan.munduz.manager.data.repository

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.ulan.app.munduz.helpers.*
import com.ulan.app.munduz.data.models.Picture
import com.ulan.munduz.manager.data.model.SliderImage
import java.util.*

class StorageImpl(private val context: Context): Storage {

    private val storage: FirebaseStorage = FirebaseStorage.getInstance()
    private val storageRef: StorageReference = storage.reference
    private var mSliderImage =  SliderImage()

    override fun insertImage(filePath: Uri): Picture {
        var picture = Picture()
        val progress = ProgressDialog(context)
        progress.show()
        val random = Random()
        val randomInt = random.nextInt(10000) + 1
        val storageRef: StorageReference = storageRef.child("images/$randomInt")
        var uploadTask: UploadTask = storageRef.putFile(filePath)
        uploadTask
            .continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                storageRef.downloadUrl
            }
            .addOnSuccessListener {
            }
            .addOnFailureListener {
                showErrorLoadingImage(context, it)
            }
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    picture.urlImage = task.result.toString()
                    progress.hide()
                    showSuccessLoadingImage(context)
                } else {
                    showNotCompletedLoadingImage(context, task)
                }
            }
        return picture
    }

    override fun insertSliderImage(filePath: Uri) {
        val progress = ProgressDialog(context)
        progress.show()
        val random = Random()
        val randomInt = random.nextInt(1000) + 1
        val storageRef: StorageReference = storageRef.child("sliderImages/$randomInt")
        var uploadTask: UploadTask = storageRef.putFile(filePath)
        uploadTask
            .continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                storageRef.downloadUrl
            }
            .addOnSuccessListener {
            }
            .addOnFailureListener {
                showErrorLoadingImage(context, it)
            }
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mSliderImage.image = task.result.toString()
                    progress.hide()
                    showSuccessLoadingImage(context)
                } else {
                    showNotCompletedLoadingImage(context, task)
                }
            }
    }

    override fun getInsertedSliderImage(): SliderImage {
        return mSliderImage
    }

    override fun removeImage(picture: Picture) {
        val deletedFile = storageRef.child(picture.urlImage)
        deletedFile.delete().addOnSuccessListener(object : OnSuccessListener<Void> {
            override fun onSuccess(p0: Void?) {
                showImageRemoved(context)
            }
        }).addOnFailureListener(object : OnFailureListener {
            override fun onFailure(p0: Exception) {
                showImageRemovedFailure(context)
            }

        })
    }
    
}