package dev.nguyen.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.nguyen.affirmations.R
import dev.nguyen.affirmations.model.Affirmation

/**
 * Adapter is a design pattern that adapts the data
 * into something that can be used by RecyclerView
 *
 * In this case, ItemAdapter takes Affirmation instances from the list returned by
 * loadAffirmations in DataSource.kt, then turn it into a list item view, so that it can
 * be displayed in the RecyclerView
 *
 * Datasource ---> Adapter ----> RecyclerView
 */

// Context stores information about the app and the resources
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * RecyclerView doesn't interact directly with item views, but deals with ViewHolders instead.
     * A ViewHolder represents a single list item view in RecyclerView, and can be reused when possible.
     */
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title) // R.id.item_title is defined in list_item.xml
        val imageView: ImageView = view.findViewById(R.id.item_image) // R.id.item_image is defined in list_item.xml
    }

    /**The getItemCount() method needs to return the size of the dataset*/
    override fun getItemCount(): Int {
        return dataset.size
    }

    /**
     * The onCreateViewHolder() method is called by the layout manager
     * to create new view holders for the RecyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // A PARENT parameter, which is the view group that the new list item view
        // will be attached to as a child. The parent is the RecyclerView

        // A VIEWTYPE parameter which becomes important when there are multiple item view types
        // in the same RecyclerView. If you have different list item layouts displayed within
        // the RecyclerView, there are different item view types

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
        holder.imageView.setImageResource(item.imageResourceId)
    }
}