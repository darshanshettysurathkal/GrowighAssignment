package com.example.growigh
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FeedAdapter(private var feedItems: List<FeedItem>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feedItem = feedItems[position]
        Glide.with(holder.itemView.context)
            .load(feedItem.Itemurl)
            .apply(RequestOptions().centerCrop())
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return feedItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newFeedItems: List<FeedItem>) {
        feedItems = newFeedItems
        notifyDataSetChanged()
    }

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.feedImageView)
    }
}
