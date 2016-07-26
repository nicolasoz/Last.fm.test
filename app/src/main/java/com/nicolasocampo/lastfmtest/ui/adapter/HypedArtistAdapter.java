package com.nicolasocampo.lastfmtest.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicolasocampo.lastfmtest.R;
import com.nicolasocampo.lastfmtest.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nicolás on 20/07/2016.
 */
public class HypedArtistAdapter extends RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHolder> {

    ArrayList<Artist> artists;
    Context context;

    public HypedArtistAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hyped_artist, parent, false);

        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);
        holder.setArtistName(currentArtist.getName());

        if (currentArtist.getUrlMediumImage() !=null)
            holder.setArtistImage(currentArtist.getUrlMediumImage());

        else
            holder.setArtistDefaultImage();
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(ArrayList<Artist> artists){
        if (artists == null)
            throw  new NullPointerException("The items cannot be null");


        this.artists.addAll(artists);
        notifyDataSetChanged();
    }

    public class HypedArtistViewHolder extends RecyclerView.ViewHolder
    {
        TextView artistName;
        ImageView artistImage;


        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }

        public void setArtistName (String name) {
            artistName.setText(name);
        }

        public void setArtistImage (String url){
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.artist_placeholder)
                    .into(artistImage);
        }

        public void setArtistDefaultImage(){
        Picasso.with(context)
                .load(R.drawable.artist_placeholder)
                .into(artistImage);
    }
    }
}
