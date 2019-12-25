package com.example.rovermore.unsplashapp.screen.main

import androidx.recyclerview.widget.RecyclerView
import com.example.rovermore.unsplashapp.BuildConfig
import com.example.rovermore.unsplashapp.core.presenter.Presenter
import com.example.rovermore.unsplashapp.usecase.GetPhotoListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainPresenter
    @Inject constructor(private val getPhotoListUseCase: GetPhotoListUseCase): Presenter<MainPresenterView>() {

    private  var view: MainPresenterView? = null
    private var pageNumber = 1
    private var positionIndex = 0
    private var isScrolling = false
    private var loadMoreEntries = true

    private val API_KEY = BuildConfig.API_KEY

    override fun init(view: MainPresenterView) {
        this.view = view
        loadPhotoList()
    }

    private fun loadPhotoList() {
        loadMoreEntries = false

        CoroutineScope(Dispatchers.IO).launch {

            try {
                val photoList = getPhotoListUseCase.bind(GetPhotoListUseCase.Params(API_KEY, pageNumber.toString()))

                withContext(Dispatchers.Main) {
                    if (!photoList.isNullOrEmpty()) {
                        if (pageNumber == 1) {
                            positionIndex = 0
                            view?.onReceiveFirstPhotoListResult(photoList)
                            pageNumber += 1
                        } else {
                            positionIndex += photoList.size
                            view?.onReceiveMoreResults(positionIndex, photoList)
                            pageNumber += 1
                        }
                    } else {
                        view?.setErrorToast()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view?.setErrorToast()
                }
            }
            loadMoreEntries = true
        }
    }

    fun addOnScrollListener() {
        val recyclerView = view?.getRecyclerView()
            recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        setUpScrollLoader()
                    }
                    super.onScrolled(recyclerView, dx, dy)
                }
            })
    }

    private fun setUpScrollLoader() {
        val layoutManager = view?.getLayoutManager()
        if (layoutManager != null) {
            val visibleItemCount = layoutManager.childCount
            val scrolledItems = layoutManager.findFirstCompletelyVisibleItemPosition()
            val totalCount = layoutManager.itemCount

            if ((visibleItemCount + scrolledItems) > totalCount) {
                if (loadMoreEntries)
                    loadPhotoList()
            }
        }
    }

}