package dev.nguyen.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.nguyen.affirmations.R
import dev.nguyen.affirmations.model.Affirmation

// Context stores information about the app and the resources
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /**
     * The onCreateViewHolder()method is called by the layout manager
     * to create new view holders for the RecyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // parent is the RecyclerView

        //The layout inflater knows how to inflate
        // an XML layout into a hierarchy of view objects.
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false) // adapterLayout holds a reference to the list item view

        return ItemViewHolder(adapterLayout)
    }

    /**
     * This method is called by the layout manager in order to replace the contents of a list item view
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    /**The getItemCount() method needs to return the size of your dataset*/
    override fun getItemCount(): Int {
        return dataset.size
    }
}