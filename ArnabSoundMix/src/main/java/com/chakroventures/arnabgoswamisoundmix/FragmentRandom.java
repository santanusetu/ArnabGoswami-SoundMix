package com.chakroventures.arnabgoswamisoundmix;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class FragmentRandom extends Fragment {

    static MediaPlayer mPlayer;
    Button btPlayRandom;
    ArrayList<Integer> randomSoundListInt = new ArrayList<>();
    private Random randomGenerator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_random, null);

        Field[] fields = R.raw.class.getFields();

        Log.i("FragmentRandom", "@@@@ Raw Asset Count: " + fields.length);

        for (int count = 0; count < fields.length; count++) {
            Log.i("FragmentRandom", "@@@@ Raw Asset: " + fields[count].getName());
            int resourceID = this.getResources().getIdentifier(fields[count].getName(), "raw", getActivity().getPackageName());
            randomSoundListInt.add(resourceID);
        }

        randomGenerator = new Random();
        btPlayRandom = (Button) rootView.findViewById(R.id.btButtonPlay);
        btPlayRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iMusic = anyItem();
                playSound(iMusic);
            }
        });

        return rootView;
    }

    public int anyItem() {
        int index = randomGenerator.nextInt(randomSoundListInt.size());
        int item = randomSoundListInt.get(index);
        if (item == 0) {
            anyItem();
        }
        return item;
    }

    private void playSound(int iMusic) {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
        mPlayer = MediaPlayer.create(getActivity(), iMusic);
        mPlayer.start();
    }
}
