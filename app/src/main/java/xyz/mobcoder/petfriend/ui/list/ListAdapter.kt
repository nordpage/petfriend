package xyz.mobcoder.petfriend.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import xyz.mobcoder.petfriend.Pet
import xyz.mobcoder.petfriend.R

class ListAdapter(private val context: Context, private val list: MutableList<Pet>,
                  fragment: Fragment
): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val listener: ListAdapter.onItemClickListener

    init {
        this.listener = fragment as ListAdapter.onItemClickListener
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var post = list[position]

        holder.bind(post)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ListAdapter.ListViewHolder(itemView)
    }



    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Pet) {

        }
    }

    interface onItemClickListener {
        fun itemRemoveClick(post: Pet)
        fun itemDetail(postId : String)
    }
}