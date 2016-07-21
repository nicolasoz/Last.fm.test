package com.nicolasocampo.lastfmtest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicolasocampo.lastfmtest.R;
import com.nicolasocampo.lastfmtest.domain.Artist;
import com.nicolasocampo.lastfmtest.ui.adapter.HypedArtistAdapter;

import java.util.ArrayList;

/**
 * Created by Nicolás on 20/07/2016.
 */
public class HypedArtistsFragment extends Fragment {

    public static final int NUM_COLUMNS = 2;

    public static final String LOG_TAG = HypedArtistsFragment.class.getSimpleName();

    private RecyclerView mHypedArtistsList;
    private HypedArtistAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);

        mHypedArtistsList = (RecyclerView) root.findViewById(R.id.hyped_artist_list);

        setupArtistsList();
        setDummyContent();
        return root;
    }

    private void setupArtistsList()
    {
        mHypedArtistsList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNS));
        mHypedArtistsList.setAdapter(adapter);
        mHypedArtistsList.addItemDecoration(new itemOffsetDecoration(getActivity(), R.integer.offset));
    }

    private void setDummyContent(){
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i =0; i<10; i++){
            artists.add(new Artist("Artist " + i));
        }
        adapter.addAll(artists);
    }
}
