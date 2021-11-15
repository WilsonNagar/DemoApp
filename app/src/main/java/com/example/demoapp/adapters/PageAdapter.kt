package com.example.demoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.R
import com.example.demoapp.models.Page
import com.example.demoapp.viewmodel.PageViewModel

class PageAdapter(var list: List<Page>, val viewModel: PageViewModel) :
    RecyclerView.Adapter<PageAdapter.PageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pagecard, parent, false)
        return PageHolder(view)
    }

    // This function is used to return total number of size of list.
    override fun getItemCount(): Int {
        return list.size
    }

    // In onBindViewHolder we will bind our itemViews with adapter
    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        var currentPosition = list[position]
        holder.ptitle.text = currentPosition.title
        //holder.pimage.setImageDrawable(currentPosition.image)
        holder.pdetail.text = currentPosition.detail
    }
    // Inner class for viewHolder
    inner class PageHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var pimage: ImageView = itemView.findViewById(R.id.pageimage)
        var ptitle: TextView = itemView.findViewById(R.id.pagetitle)
        var pdetail: TextView = itemView.findViewById(R.id.pagetext)
        var pdelete: Button = itemView.findViewById(R.id.btnDel)
        init {
            pdelete.setOnClickListener {
                val position = adapterPosition
                viewModel.delete(list[position])
//                if (listener != null && position != RecyclerView.NO_POSITION) {
//                    listener!!.onItemClick(getItem(position),cardImage.drawable)
//                }
            }
        }
    }
}