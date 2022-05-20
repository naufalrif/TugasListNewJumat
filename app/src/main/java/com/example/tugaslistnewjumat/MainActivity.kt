package com.example.tugaslistnewjumat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaslistnewjumat.adapter.NewsAdapter
import com.example.tugaslistnewjumat.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter = NewsAdapter()
        initRV()
    }

    fun initRV(){
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter
        getNews()
    }
    fun getNews(){
        val viewmodel = ViewModelProvider(this).get(ViewModelNews::class.java)

        viewmodel.getLiveNews().observe(this, Observer {
            if (it != null){
                newsAdapter.setDataNews(it)
                newsAdapter.notifyDataSetChanged()
            }
        })
        viewmodel.getNewsAPI()
    }
}