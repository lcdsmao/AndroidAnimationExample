package com.paranoid.mao.animationexample

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.entry_item.view.*

class EntryAdapter(
    private val entries: List<Entry>
) : RecyclerView.Adapter<EntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = parent.inflate(R.layout.entry_item)
        return EntryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.bind(entries[position])
    }

}

class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(entry: Entry) = with(itemView) {
        title.text = entry.title
        setOnClickListener { entry.invoke() }
    }
}