package kynt.fpt.demopaginglibrary.xsplash

import android.util.Log
import kynt.fpt.demopaginglibrary.xsplash.beans.Order
import kynt.fpt.demopaginglibrary.xsplash.beans.Photo
import kynt.fpt.demopaginglibrary.xsplash.events.PhotosEndpointInterface
import kynt.fpt.demopaginglibrary.xsplash.retrofit.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class XSplash(clientId: String) {
    private val photosApiService: PhotosEndpointInterface

    init {
        val client = OkHttpClient.Builder().addInterceptor(HeaderInterceptor(clientId)).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        photosApiService = retrofit.create(PhotosEndpointInterface::class.java)
    }


    private abstract inner class XSplashCallback<T> : Callback<T> {
        internal abstract fun onComplete(response: T?)

        internal abstract fun onError(call: Call<T>, message: String)

        override fun onResponse(call: Call<T>, response: Response<T>) {
            val statusCode = response.code()
            Log.d(TAG, "Status Code = $statusCode")
            if (statusCode == 200) {
                onComplete(response.body())
            } else if (statusCode >= 400) {
                onError(call, statusCode.toString())

                if (statusCode == 401) {
                    Log.d(TAG, "Unauthorized, Check your client Id")
                }
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(call, t.message!!)
        }
    }

    fun getPhotos(page: Int?, perPage: Int?, order: Order, listener: OnPhotosLoadedListener) {
        val call = photosApiService.getPhotos(page, perPage, order.order)
        call.enqueue(getMultiplePhotoCallback(listener))
    }

    private fun getMultiplePhotoCallback(listener: OnPhotosLoadedListener): XSplashCallback<MutableList<Photo>> {
        return object : XSplashCallback<MutableList<Photo>>() {
            override fun onComplete(response: MutableList<Photo>?) {
                listener.onComplete(response)
            }

            override fun onError(call: Call<MutableList<Photo>>, message: String) {
                listener.onError(message)
            }
        }
    }

    interface OnPhotosLoadedListener {
        fun onComplete(photos: MutableList<Photo>?)

        fun onError(error: String)
    }

    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"
        private const val TAG = "XSplash"
    }
}
