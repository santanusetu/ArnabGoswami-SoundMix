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

public class FragmentNames extends Fragment {

    CustomGridViewAdapter customGridViewAdapter;
    GridView gridView;
    ArrayList<String> gridArray = new ArrayList<>();

    static MediaPlayer mPlayer;
    static int[] soundClips = {R.raw.names_hereismrphulka, R.raw.names_imtellingumrbhatt,
            R.raw.names_mrowasi, R.raw.names_smritiirani,
            R.raw.names_mrtightler, R.raw.names_mrbhatt,
            R.raw.names_mrswamypleaselisten};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, null);


        gridArray.add("Here is Mr Phulka");
        gridArray.add("I'm telling you Mr. Bhatt");
        gridArray.add("Mr. Owaisi - I'm asking once again");
        gridArray.add("Smriti Irani");
        gridArray.add("Mr. Tytler");
        gridArray.add("I'll speak the truth Mr. Bhatt");
        gridArray.add("Mr. Swamy - please listen");


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