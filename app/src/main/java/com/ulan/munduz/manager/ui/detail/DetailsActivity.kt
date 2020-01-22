package com.ulan.munduz.manager.ui.detail

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.ulan.app.munduz.data.models.Picture
import com.ulan.app.munduz.helpers.Constants.Companion.PICK_IMAGE_REQUEST
import com.ulan.app.munduz.helpers.Constants.Companion.PRODUCTS_DATA
import com.ulan.app.munduz.helpers.showEditTextEmpty
import com.ulan.app.munduz.helpers.showEmptyDrawable
import com.ulan.app.munduz.helpers.showProductUpdated
import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.data.repository.RepositoryImpl
import com.ulan.munduz.manager.data.repository.StorageImpl
import kotlinx.android.synthetic.main.add_layout.choose_product_image
import kotlinx.android.synthetic.main.add_layout.product_amount
import kotlinx.android.synthetic.main.add_layout.product_category
import kotlinx.android.synthetic.main.add_layout.product_cost
import kotlinx.android.synthetic.main.add_layout.product_desc
import kotlinx.android.synthetic.main.add_layout.product_image
import kotlinx.android.synthetic.main.add_layout.product_name
import kotlinx.android.synthetic.main.details_layout.*
import java.io.IOException

class DetailsActivity : AppCompatActivity(), DetailsView {

    private lateinit var mPresenter: DetailsPresenter
    private lateinit var mProduct: Product
    private var filePath: Uri? = null
    private var newPicture: Picture = Picture()
    private var oldPicture: Picture = Picture()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)
        val repository = RepositoryImpl(this)
        val storage = StorageImpl(this)
        mPresenter = DetailsPresenterImpl(repository, storage)

        mPresenter.attachView(this)
        mPresenter.setToolbar()
        mPresenter.initCategory()

        mProduct = intent.getParcelableExtra(PRODUCTS_DATA)
        if (mProduct != null) {
            mPresenter.showProduct(mProduct)
        }

        update_product.setOnClickListener {
            mPresenter.updateButtonClicked()
            showProductUpdated(this)
        }

        choose_product_image.setOnClickListener {
            mPresenter.chooseImageButtonClicked()
        }
    }

    override fun initToolbar(title: String) {
        setSupportActionBar(details_toolbar)
        supportActionBar?.title = "Details"
        details_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        details_toolbar.setNavigationOnClickListener {
            finish()
        }

    }

    override fun setCategories(categories: MutableList<String>) {
        val categoryAdapter =
            ArrayAdapter(
                applicationContext,
                android.R.layout.simple_spinner_item,
                categories
            )
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        product_category.adapter = categoryAdapter
    }

    override fun setProduct(product: Product?) {
        product_category.setSelection(mPresenter.findCategoryPosition(product!!.category))
        product_name.setText(product.name)
        product_desc.setText(product.desc)
        product_cost.setText(product.cost.toString())
        product_visibility.isChecked = product.isVisible
        oldPicture = product.picture
        Picasso.get().load(product.picture.urlImage).into(product_image)
    }

    override fun getInputProduct(): Product {
        var product = Product()
        product.id = mProduct.id
        product.date = System.currentTimeMillis()
        product.category = product_category.selectedItem.toString()
        product.isVisible = product_visibility.isChecked
        product.desc = product_desc.text.toString()
        product.amount = product_amount.text.toString().toInt()
        product.cost = Integer.parseInt(product_cost.text.toString())
        product.picture = if(filePath != null) newPicture else oldPicture
        return product
    }

    override fun checkForNull() {
        if (product_name.text.toString() == "" || product_desc.text.toString() == "" ||
            product_cost.text.toString() == ""
        ) {
            showEditTextEmpty(this)
            return
        }
        if (product_image.drawable == null) {
            showEmptyDrawable(this)
            return
        }
    }

    override fun chooseImage() {
        val intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(
            Intent.createChooser(intent, resources.getString(R.string.select_image)),
            PICK_IMAGE_REQUEST
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
            && data != null && data.data != null
        ) {
            filePath = data.data
            try {
                var bitmap: Bitmap =
                    MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                product_image.setImageBitmap(bitmap)
                newPicture = mPresenter.getPictureUrl(filePath)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }
}