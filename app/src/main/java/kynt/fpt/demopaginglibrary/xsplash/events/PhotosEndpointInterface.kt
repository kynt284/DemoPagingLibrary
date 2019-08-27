package kynt.fpt.demopaginglibrary.xsplash.events

import kynt.fpt.demopaginglibrary.xsplash.beans.Photo
import retrofit2.Call
import retrofit2.http.*

interface PhotosEndpointInterface {

    @GET("photos")
    fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String
    ): Call<MutableList<Photo>>

}

