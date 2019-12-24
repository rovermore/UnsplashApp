package com.example.rovermore.unsplashapp.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rovermore.unsplashapp.R
import com.example.rovermore.unsplashapp.UnsplashApp
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import com.example.rovermore.unsplashapp.gone
import com.example.rovermore.unsplashapp.visible
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainPresenterView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private lateinit var photoList: MutableList<PhotoFromList>
    private val layoutManager = GridLayoutManager(this, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.initWith(this)

        setUpRecyclerView()

        mainPresenter.addOnScrollListener()
    }

    init { UnsplashApp.daggerAppComponent().inject(this) }

    private fun setUpRecyclerView() {
        recyclerView = mainRecyclerView
        recyclerView.gone()
        recyclerView.layoutManager = layoutManager
        adapter = MainAdapter(this, null)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun createUi(photoList: MutableList<PhotoFromList>) {
        recyclerView.visible()
        this.photoList = photoList
        adapter.clearMainAdapter()
        adapter.updateRepositoriesList(this.photoList)
    }

    override fun getRecyclerView(): RecyclerView = recyclerView

    override fun getLayoutManager(): GridLayoutManager = layoutManager

    override fun onReceiveFirstPhotoListResult(photoList: MutableList<PhotoFromList>) {
        createUi(photoList)
    }

    override fun onReceiveMoreResults(positionIndex: Int, photoList: MutableList<PhotoFromList>) {
        this.photoList.addAll(positionIndex, photoList)
        recyclerView.adapter!!.notifyItemRangeInserted(positionIndex, photoList.size)
    }
}
