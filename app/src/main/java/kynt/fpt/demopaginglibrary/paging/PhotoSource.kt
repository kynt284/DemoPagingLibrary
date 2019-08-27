package kynt.fpt.demopaginglibrary.paging

import androidx.paging.PageKeyedDataSource
import kynt.fpt.demopaginglibrary.xsplash.XSplash
import kynt.fpt.demopaginglibrary.xsplash.beans.Order
import kynt.fpt.demopaginglibrary.xsplash.beans.Photo

class PhotoSource : PageKeyedDataSource<Long, Photo>() {
    private var XSplash: XSplash? = null

    init {
        XSplash = XSplash("5b8f9b5c47699d1a192e293a44c1d2f8daa4e7794b8de31c04aed97ba60a62c1")
    }


    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, Photo>) {
        XSplash?.getPhotos(
            1,
            params.requestedLoadSize,
            Order.LATEST,
            object : XSplash.OnPhotosLoadedListener {
                override fun onComplete(photos: MutableList<Photo>?) {
                    callback.onResult(photos as MutableList<Photo>, null, 2)
                }

                override fun onError(error: String) {}
            })
    }


    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Photo>) {
        XSplash?.getPhotos(
            (params.key).toInt(),
            params.requestedLoadSize,
            Order.LATEST,
            object : XSplash.OnPhotosLoadedListener {
                override fun onComplete(photos: MutableList<Photo>?) {
                    callback.onResult(photos as MutableList<Photo>, params.key + 1)
                }

                override fun onError(error: String) {}
            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Photo>) {}
}