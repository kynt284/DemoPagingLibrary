package kynt.fpt.demopaginglibrary.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kynt.fpt.demopaginglibrary.adapter.holder.PhotoHolder
import kynt.fpt.demopaginglibrary.xsplash.beans.Photo
import kynt.fpt.demopaginglibrary.xsplash.events.OnLoadImageStatusListener


class RecyclerAdapter : PagedListAdapter<Photo, RecyclerView.ViewHolder>(DIFF_UTIL) {
    private var mLoadImageStatusListener: OnLoadImageStatusListener? = null

    fun setOnLoadImageStatus(loadImageStatusListener: OnLoadImageStatusListener){
        mLoadImageStatusListener = loadImageStatusListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = PhotoHolder.createHolderView(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoHolder).bind(getItem(position), mLoadImageStatusListener)
    }

    private companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldConcert: Photo, newConcert: Photo): Boolean = oldConcert.id == newConcert.id

            override fun areContentsTheSame(oldConcert: Photo, newConcert: Photo): Boolean = oldConcert.id == newConcert.id
        }
    }
}


