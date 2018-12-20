package com.paranoid.mao.animationexample.revealhide

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.paranoid.mao.animationexample.R
import com.paranoid.mao.animationexample.inflate
import kotlinx.android.synthetic.main.activity_expansion_list_example.*
import kotlinx.android.synthetic.main.expandable_item.view.*

class ExpansionListExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expansion_list_example)

        val models = List(20) {
            Model("Header: $it", "Content: $it")
        }
        recycler_view.apply {
            adapter = ExpandableAdapter(models)
            itemAnimator = ExpansionItemAnimator()
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }

    private class ExpansionItemAnimator : DefaultItemAnimator() {
        init {
            supportsChangeAnimations = false
        }
    }

    private class ExpandableAdapter(
        val models: List<Model>
    ) : RecyclerView.Adapter<ExpandableViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableViewHolder {
            val view = parent.inflate(R.layout.expandable_item)
            val viewHolder = ExpandableViewHolder(view)
            view.header_group.setOnClickListener {
                val model = models[viewHolder.adapterPosition]
                model.isExpanded = !model.isExpanded
                notifyItemChanged(viewHolder.adapterPosition)
            }
            return viewHolder
        }

        override fun getItemCount(): Int = models.size

        override fun onBindViewHolder(holder: ExpandableViewHolder, position: Int) {
            holder.bind(models[position])
        }
    }

    private class ExpandableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(model: Model) = itemView.apply {
            header_text.text = model.title
            content.text = model.content
            expandable_group.isVisible = model.isExpanded
            val rotation = if (model.isExpanded && toggle_button.rotation == 0f) {
                180f
            } else if (!model.isExpanded && toggle_button.rotation == 180f) {
                0f
            } else {
                null
            }
            rotation?.let {
                toggle_button.animate()
                    .rotation(it)
                    .setDuration(200)
                    .start()
            }
        }
    }

    private class Model(val title: String, val content: String) {
        var isExpanded: Boolean = false
    }
}