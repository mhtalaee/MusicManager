package ir.heydarii.musicmanager.features.searchpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.heydarii.musicmanager.R
import ir.heydarii.musicmanager.pojos.Artist
import kotlinx.android.synthetic.main.search_layout_item.view.*

class SearchArtistAdapter(private val list: List<Artist>, private val clickListener: (String, String) -> Unit) : RecyclerView.Adapter<SearchArtistAdapter.SearchArtistViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchArtistViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_layout_item, parent, false)
        return SearchArtistViewHolder(view, clickListener)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SearchArtistViewHolder, position: Int) {
        holder.bind(list[position])
    }


    class SearchArtistViewHolder(private val view: View, val clickListener: (String, String) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(artist: Artist) {
            view.txtName.text = artist.name
            if (artist.image.last().text.isNotEmpty())
                Picasso.get().load(artist.image.last().text).into(view.imgArtist)

            view.setOnClickListener {
                clickListener(artist.name, artist.mbid)
            }
        }


    }
}