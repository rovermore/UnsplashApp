package com.example.rovermore.unsplashapp.screen.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rovermore.unsplashapp.R
import com.example.rovermore.unsplashapp.UnsplashApp
import com.example.rovermore.unsplashapp.domain.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailPresenterView {

    companion object {
        const val PHOTO_ID = "PHOTO_ID"
    }

    @Inject
    lateinit var detailPresenter: DetailPresenter

    private var photoId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailPresenter.initWith(this)

    }

    init { UnsplashApp.daggerAppComponent().inject(this) }

    override fun getExtrasFromIntent() {
        getExtras()
    }

    private fun getExtras() {
        intent.extras?.let {extras ->
            if (extras.containsKey(PHOTO_ID)) {
                photoId = extras.getString(PHOTO_ID)
            }
        }
    }

    override fun getPhotoId(): String? = photoId

    override fun setUpView(photo: Photo) {
        Picasso.with(applicationContext)
            .load(photo.photoUrls.regular)
            .fit().centerCrop()
            .into(detailImageView)
        descriptionTextView.text = photo.description
        userNameTextView.text = photo.user.name
        textViewCamera.text = photo.exif.brand
    }
}
