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

public class FragmentSarcastic extends Fragment {

    CustomGridViewAdapter customGridViewAdapter;
    GridView gridView;
    ArrayList<String> gridArray = new ArrayList<>();

    static MediaPlayer mPlayer;
    static int[] soundClips = {R.raw.sarcas_whereralltheseppl, R.raw.sarcas_rureadyliedetector, R.raw.sarcas_ucantbewrongby,
            R.raw.sarcas_imsayingpubliclyurrunningaway, R.raw.sarcas_pappijhappi, R.raw.sarcas_dotheyhavedgutsamerica,
            R.raw.sarcas_weknowthehistoryamerica,R.raw.sarcas_howdidmodigetitsowrong, R.raw.sarcas_thedayihavetolearn};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, null);


        gridArray.add("Where are all these people");
        gridArray.add("Are you ready for a lie detector test Mr");
        gridArray.add("You can't be wrong by 600%");
        gridArray.add("I'm saying this publicly because you have been running away from me");
        gridArray.add("Pappi-jhappi and say Oh My God!");
        gridArray.add("Do they have the guts to say racist intolerant America");
        gridArray.add("We know the history of America!");
        gridArray.add("How did Modi get it so wrong?");
        gridArray.add("The day I have to learn.. I will be in trouble..");

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