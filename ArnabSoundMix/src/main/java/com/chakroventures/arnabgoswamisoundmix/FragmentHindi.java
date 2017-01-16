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

public class FragmentHindi extends Fragment {

    CustomGridViewAdapter customGridViewAdapter;
    GridView gridView;
    ArrayList<String> gridArray = new ArrayList<>();

    static MediaPlayer mPlayer;
    static int[] soundClips = {R.raw.hindi_aapekbaartohjawabdekdekhiye, R.raw.hindi_aapkobhineichorungamain,
            R.raw.hindi_appiskatohjawabdede, R.raw.hindi_yehbahutoriginaltha,
            R.raw.hindi_isskajawabdedijiye, R.raw.hindi_jawabneihainmerepaas,
            R.raw.hindi_kitnedintak};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, null);


        gridArray.add("Aap ek baar toh jawab de k dekhiye");
        gridArray.add("Aap ko bhi nei chorunga main");
        gridArray.add("Aap iska toh jawab de de");
        gridArray.add("Yeh toh bahut original tha !");
        gridArray.add("Iska jawab de dijiye");
        gridArray.add("Jawab nei hain mere paas");
        gridArray.add("Kitne din tak aap bhagoge");


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