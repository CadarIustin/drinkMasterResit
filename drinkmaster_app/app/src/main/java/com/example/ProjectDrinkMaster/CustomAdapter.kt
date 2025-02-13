package com.example.ProjectDrinkMaster

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// recycler view class
class CustomAdapter(private val mList: List<ItemsViewModel>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    //inner class that is created inside another clas
    lateinit var onOrderButtonPress: OnClickListener
    lateinit var order: ImageButton

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val description: TextView = itemView.findViewById(R.id.recyclerViewText)
        val image: ImageView = itemView.findViewById(R.id.recyclerViewImage)
        val title: TextView = itemView.findViewById(R.id.recylerTitle)
        val order: ImageButton = itemView.findViewById(R.id.imageButton)
        val rating: TextView = itemView.findViewById(R.id.average_rating_view)
    }

    //create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //infales the card_view_desgin view
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        val lp = view.layoutParams
        lp.width - parent.measuredHeight / 3
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        // sets the image to the imageview from our itemHolder class
        //get the items that need to be changed in the recycler view
        holder.description.text = ItemsViewModel.text
        holder.image.setImageResource(ItemsViewModel.image)
        holder.title.text = ItemsViewModel.title
        holder.order.setImageResource(ItemsViewModel.orderButton)
        holder.rating.text = ItemsViewModel.rating
        order = holder.order
        holder.order.setOnClickListener {
            this.onOrderButtonPress.onClick(holder.order)
        }
    }

    fun test(holder: ViewHolder, position: Int): ItemsViewModel {
        return mList[position]
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setOnOrderClick(button: OnClickListener) {
        this.onOrderButtonPress = button

    }
}
