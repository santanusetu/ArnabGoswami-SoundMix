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

public class FragmentWarning extends Fragment {

    CustomGridViewAdapter customGridViewAdapter;
    GridView gridView;
    ArrayList<String> gridArray = new ArrayList<>();

    static MediaPlayer mPlayer;
    static int[] soundClips = {R.raw.wn_chosethetime, R.raw.wn_dontshowmeurtemper,
            R.raw.wn_donttrytobeagressive, R.raw.wn_donttrytopetronizeme,
            R.raw.wn_ifuhavetheguts, R.raw.wn_neverever,
            R.raw.wn_uanswerme,
            R.raw.wn_urtimeurplace, R.raw.wn_youcanhearme,
            R.raw.wn_dontu};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, null);


        gridArray.add("Choose the time - have a debate");
        gridArray.add("Don't show me your temper");
        gridArray.add("Do not try to be aggressive with me ");
        gridArray.add("Don't try to patronize me");
        gridArray.add("If you have the guts, I'm challenging you");
        gridArray.add("Never ever - ever ever");

        gridArray.add("You answer me");
        gridArray.add("Your time, your place");
        gridArray.add("You can hear me Mr");
        gridArray.add("Don't you?");

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
                    case 1:
                        playSound(position);
                        break;
                    case 2:
                        playSound(position);
                        break;
                    case 3:
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