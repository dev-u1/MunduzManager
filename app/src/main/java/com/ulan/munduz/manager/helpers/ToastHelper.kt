package com.ulan.app.munduz.helpers

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.ulan.munduz.manager.R
import java.lang.Exception

fun showEditTextEmpty(context: Context) {
    Toast.makeText(
        context,
        context.resources.getString(R.string.edit_text_empty),
        Toast.LENGTH_SHORT
    )
        .show()
}

fun showEmptyFields(context: Context){
    Toast.makeText(
        context,
        "Заполните все поля",
        Toast.LENGTH_LONG
    ).show()
}

fun showSuccessProductAdded(context: Context){
    Toast.makeText(
        context,
        "Добавлено",
        Toast.LENGTH_LONG
    ).show()
}

fun showSuccessDeleted(context: Context){
    Toast.makeText(
        context,
        "Успешно удален",
        Toast.LENGTH_LONG
    ).show()
}

fun showEmptyDrawable(context: Context) {
    Toast.makeText(
        context,
        context.resources.getString(R.string.product_image) + " не выбрана ",
        Toast.LENGTH_SHORT
    ).show()
}

fun showSuccessLoadingImage(context: Context){
    Toast.makeText(
        context,
        context.getString(R.string.loading_success),
        Toast.LENGTH_SHORT
    ).show()
}

fun showNotCompletedLoadingImage(context: Context, task: Task<Uri>){
    Toast.makeText(
        context,
        context.getString(R.string.loading_not_completed) + " " + task.exception.toString(),
        Toast.LENGTH_LONG
    ).show()
}

fun showErrorLoadingImage(context: Context, exception: Exception){
    Toast.makeText(
        context,
        context.resources.getString(R.string.loading_failed) + " " + exception.message,
        Toast.LENGTH_LONG
    ).show()
}

fun showErrorReadFromDatabase(context: Context){
    Toast.makeText(
        context,
        context.resources.getString(R.string.error_read_data),
        Toast.LENGTH_LONG
    ).show()
}

fun showProductUpdated(context: Context){
    Toast.makeText(
        context,
        "Обновлено",
        Toast.LENGTH_LONG
    ).show()
}

fun showImageRemoved(context: Context){
    Toast.makeText(
        context,
        "Picture remove",
        Toast.LENGTH_LONG
    ).show()
}

fun showImageRemovedFailure(context: Context){
    Toast.makeText(
        context,
        "Fail while removing image",
        Toast.LENGTH_LONG
    ).show()
}

fun showSuccessMessageSent(context: Context){
    Toast.makeText(
        context,
        "Your message sent to developer",
        Toast.LENGTH_LONG
    ).show()
}
