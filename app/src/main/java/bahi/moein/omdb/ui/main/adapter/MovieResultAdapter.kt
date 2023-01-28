package bahi.moein.omdb.ui.main.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bakhtiyor.gradients.Gradients
import bahi.moein.omdb.data.model.response.Search
import bahi.moein.omdb.databinding.MovieItemBinding
import bahi.moein.omdb.utils.loadImage
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 * Adapter for result of search
 *
 */
class MovieResultAdapter
@Inject constructor() : RecyclerView.Adapter<MovieResultAdapter.ViewHolder>() {

    internal var collection: List<Search> by Delegates.observable(emptyList()) { _, old, new ->
       notifyItemInserted(old.size)
    }

    internal var clickListener: (Search, ImageView) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(collection[position],clickListener)

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class ViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(search: Search, onItemClicked: (Search, ImageView) -> Unit) {
            binding.item=search

            val drawable: Drawable =
                Gradients.find(Gradients.names()[search.background ?: 0]) as Drawable
            binding.rootView.background = drawable
            binding.imageView.loadImage(search.poster
            )
            binding.root.setOnClickListener {
                onItemClicked(search, binding.imageView)
            }

        }
    }
}
