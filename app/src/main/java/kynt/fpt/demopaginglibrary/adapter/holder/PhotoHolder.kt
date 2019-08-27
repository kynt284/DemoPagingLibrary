package kynt.fpt.demopaginglibrary.adapter.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_list_photo.view.*
import androidx.constraintlayout.widget.ConstraintLayout
import kynt.fpt.demopaginglibrary.R
import kynt.fpt.demopaginglibrary.extensions.convertPixelsToDp
import kynt.fpt.demopaginglibrary.extensions.loadImage
import kynt.fpt.demopaginglibrary.xsplash.beans.Photo
import kynt.fpt.demopaginglibrary.xsplash.events.OnLoadImageStatusListener

class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(data: Photo?, loadImageStatusListener: OnLoadImageStatusListener?) {
        if (data != null) {
            val layoutParams = itemView.imageData.layoutParams as ConstraintLayout.LayoutParams
            val withImage = convertPixelsToDp(data.width)
            val heightImage = convertPixelsToDp(data.height)
            layoutParams.dimensionRatio = "H,$withImage:$heightImage"
            itemView.imageData.layoutParams = layoutParams
            itemView.imageData.requestLayout()
            loadImage(itemView.imageData, data.urls.regular, itemView.progressBar, loadImageStatusListener)
        }
    }

    companion object {
        fun createHolderView(parent: ViewGroup) = PhotoHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_list_photo, parent, false)
        )
    }
}