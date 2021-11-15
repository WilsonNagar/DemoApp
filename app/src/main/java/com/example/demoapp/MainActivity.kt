package com.example.demoapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.adapters.PageAdapter
import com.example.demoapp.database.PageDatabase
import com.example.demoapp.database.PageRepository
import com.example.demoapp.models.Page
import com.example.demoapp.viewmodel.PageViewModel
import com.example.demoapp.viewmodel.PagesViewModelFactory
import android.content.Intent
import android.net.Uri


class MainActivity : AppCompatActivity() {
    lateinit var ViewModel: PageViewModel
    lateinit var list: List<Page>
    lateinit var pageAdapter: PageAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.pagelist)
        list = ArrayList<Page>()
        pageAdapter = PageAdapter(list, ViewModel)
        recyclerView.adapter = pageAdapter
        //recyclerView.layoutManager = RecyclerView.LayoutManager(LinearLayoutManager(this))

        val pageRepository = PageRepository(PageDatabase(this))
        val factory = PagesViewModelFactory(pageRepository)
//
//        // Initialised View Model
        ViewModel = ViewModelProvider(this, factory).get(PageViewModel::class.java)

//
//        recyclerView.adapter = pageAdapter
//
//        // To display all items in recycler view
        ViewModel.allPageItems().observe(this, Observer {
            pageAdapter.list = it
            pageAdapter.notifyDataSetChanged()
        })
        setonclick()
    }
    fun setonclick(){
        var addbut = findViewById<Button>(R.id.btnAdd)
        var gettitle = findViewById<EditText>(R.id.titleSelect)
        var getDetail = findViewById<EditText>(R.id.textSelect)
        var getImage = findViewById<ImageView>(R.id.imageSelect)
        addbut.setOnClickListener {
            ViewModel.insert(Page(title = gettitle.text.toString(),detail = getDetail.text.toString(),))
        }
        getImage.setOnClickListener {

        }
    }

    fun send(){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 100 && resultCode == RESULT_OK) {
//            val uri: Uri? = data.data
//            findViewById<ImageView>(R.id.imageSelect).setImageURI(uri)
//        }
//    }



}