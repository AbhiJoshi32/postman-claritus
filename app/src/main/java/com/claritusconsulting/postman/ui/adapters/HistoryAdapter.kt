package com.claritusconsulting.postman.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.claritusconsulting.postman.R
import com.claritusconsulting.postman.data.Request
import kotlinx.android.synthetic.main.history_item.view.*

class HistoryAdapter(val items: List<Request>, val context: Context?) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.methodText.text = items.get(position).method
        holder.urlText.text = items.get(position).url
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.history_item, parent, false))
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val methodText= view.methodText
    val urlText = view.urlText
}