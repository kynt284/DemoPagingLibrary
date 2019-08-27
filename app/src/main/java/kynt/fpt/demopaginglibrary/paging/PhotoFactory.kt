package kynt.fpt.demopaginglibrary.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import kynt.fpt.demopaginglibrary.xsplash.beans.Photo

class PhotoFactory : DataSource.Factory<Long, Photo>() {

    val dataSource = MutableLiveData<PhotoSource>()

    override fun create(): DataSource<Long, Photo> = PhotoSource().apply {
        dataSource.postValue(this)
    }
}