package com.chakroventures.arnabgoswamisoundmix;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentOthers extends Fragment {

    CustomGridViewAdapter customGridViewAdapter;
    GridView gridView;
    ArrayList<String> gridArray = new ArrayList<>();

    static MediaPlayer mPlayer;
    static int[] soundClips = {R.raw.otrs_arnab, R.raw.otrs_clinteastwoodndrajnikant,
            R.raw.otrs_dontputwordsinmymouth, R.raw.otrs_imnotembarrasing,
            R.raw.otrs_listentome, R.raw.otrs_urtalkingnonsense,
            R.raw.otrs_whorutopass,
            R.raw.otrs_willuonlytalk, R.raw.otrs_yacalmdownu, R.raw.otrs_dontbestupid,
            R.raw.otrs_uranignorantman};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, null);


        gridArray.add("Arnaaaab");
        gridArray.add("Mix of Clint Eastwood and Rajnikanth");
        gridArray.add("Don't put words in my mouth");
        gridArray.add("I understand you are embarrassed");
        gridArray.add("Listen to me");
        gridArray.add("You are talking non-sense");
        gridArray.add("Who are you to pass judgement on this?");
        gridArray.add("Will you only talk or let me talk also?");

        gridArray.add("Ya - calm down you");
        gridArray.add("Don't be stupid");
        gridArray.add("You are an ignorant man");

        gridView = (GridView) rootView.findViewById(R.id.gridViewCustom);
        customGridViewAdapter = new CustomGridViewAdapter(getActivity(), R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridViewAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0:
                        playSound(position);
                        break;
                    default:
                        playSound(position);
                        break;
                }
            }
        });

        return rootView;
    }

    private void playSound(int pos) {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
        mPlayer = MediaPlayer.create(getActivity(), soundClips[pos]);
        mPlayer.start();
    }
}