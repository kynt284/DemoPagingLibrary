package kynt.fpt.demopaginglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kynt.fpt.demopaginglibrary.adapter.RecyclerAdapter
import kynt.fpt.demopaginglibrary.paging.PhotoFactory
import kynt.fpt.demopaginglibrary.xsplash.beans.Photo
import kynt.fpt.demopaginglibrary.xsplash.events.OnLoadImageStatusListener

class MainActivity : AppCompatActivity() {
    private lateinit var articles: LiveData<PagedList<Photo>>
    private var photoAdapter: RecyclerAdapter? = null
    private var pagedListConfig : PagedList.Config = PagedList.Config.Builder()
        .setInitialLoadSizeHint(6)
        .setEnablePlaceholders(false)
        .setPageSize(30)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()

        articles = LivePagedListBuilder(PhotoFactory(), pagedListConfig).build()
        articles.observe(this, Observer<PagedList<Photo>> {
            photoAdapter?.submitList(it)
        })

        attachEvents()
    }

    private fun attachEvents() {
        photoAdapter?.setOnLoadImageStatus(object : OnLoadImageStatusListener {
            override fun done() {
                progressBar.visibility = View.GONE
            }

            override fun error() {
                progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun initAdapter() {
        photoAdapter = RecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = photoAdapter
    }
}
