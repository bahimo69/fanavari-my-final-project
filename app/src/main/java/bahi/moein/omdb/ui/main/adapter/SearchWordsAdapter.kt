package bahi.moein.omdb.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bahi.moein.omdb.data.model.search.SearchWords
import bahi.moein.omdb.databinding.SearchTextItemBinding
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 *
 * Adapter for search words
 */

class SearchWordsAdapter
@Inject constructor() : RecyclerView.Adapter<SearchWordsAdapter.ViewHolder>() {

    internal var collection: List<SearchWords> by Delegates.observable(emptyList()) { _, old, new ->
        notifyItemInserted(old.size)
    }

    internal var clickListener: (SearchWords) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            SearchTextItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(collection.get(position), clickListener)

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class ViewHolder(private val binding: SearchTextItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(searchWords: SearchWords, onItemClicked: (SearchWords) -> Unit) {
            binding.item = searchWords
            binding.root.setOnClickListener {
                onItemClicked(searchWords)
            }

        }
    }
}
