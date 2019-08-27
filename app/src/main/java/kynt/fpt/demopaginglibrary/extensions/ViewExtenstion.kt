package kynt.fpt.demopaginglibrary.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kynt.fpt.demopaginglibrary.R
import kynt.fpt.demopaginglibrary.xsplash.events.OnLoadImageStatusListener
import kotlin.random.Random

fun loadImage(view: ImageView, url: String, progressBar: ProgressBar, onLoadImageStatusListener: OnLoadImageStatusListener?) {
    progressBar.visibility = View.VISIBLE
    Glide.with(view.context)
        .asBitmap()
        .load(url)
        .placeholder(getRandomDrawableColor())
        .listener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                progressBar.visibility = View.VISIBLE
                onLoadImageStatusListener?.error()
                return false
            }
            override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                progressBar.visibility = View.GONE
                setImageViewAnimated2(view.context, view, resource)
                onLoadImageStatusListener?.done()
                return false
            }
        })
        .into(view)
}

fun convertPixelsToDp(px: Int): Int {
    return px / (Resources.getSystem().displayMetrics!!.density).toInt()
}

fun setImageViewAnimated2(context: Context, imageView: ImageView, resource: Bitmap?) {
    val animIn = AnimationUtils.loadAnimation(context, R.anim.fade_in_image)
    imageView.setImageBitmap(resource)
    imageView.startAnimation(animIn)
}

fun getRandomDrawableColor(): ColorDrawable {
    val idx = Random.nextInt(vibrantLightColorList.size)
    return vibrantLightColorList[idx]
}

val vibrantLightColorList = arrayOf(
    ColorDrawable(Color.parseColor("#f44336")),
    ColorDrawable(Color.parseColor("#E91E63")),
    ColorDrawable(Color.parseColor("#9C27B0")),
    ColorDrawable(Color.parseColor("#673AB7")),
    ColorDrawable(Color.parseColor("#3F51B5")),
    ColorDrawable(Color.parseColor("#2196F3")),
    ColorDrawable(Color.parseColor("#03A9F4")),
    ColorDrawable(Color.parseColor("#00BCD4")),
    ColorDrawable(Color.parseColor("#009688")),
    ColorDrawable(Color.parseColor("#4CAF50")),
    ColorDrawable(Color.parseColor("#8BC34A")),
    ColorDrawable(Color.parseColor("#CDDC39")),
    ColorDrawable(Color.parseColor("#FFEB3B")),
    ColorDrawable(Color.parseColor("#FFC107")),
    ColorDrawable(Color.parseColor("#FF9800")),
    ColorDrawable(Color.parseColor("#FF5722")),
    ColorDrawable(Color.parseColor("#795548")),
    ColorDrawable(Color.parseColor("#9E9E9E")),
    ColorDrawable(Color.parseColor("#607D8B"))
)