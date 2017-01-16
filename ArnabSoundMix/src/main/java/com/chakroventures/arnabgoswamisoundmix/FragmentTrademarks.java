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

public class FragmentTrademarks extends Fragment {

    CustomGridViewAdapter customGridViewAdapter;
    GridView gridView;
    ArrayList<String> gridArray = new ArrayList<>();

    static MediaPlayer mPlayer;
    static int[] soundClips = {R.raw.tms_anywaygoingback, R.raw.tms_dontbeintolarenttome,
            R.raw.tms_imaskingdquestions, R.raw.tms_imaskingyoutonightagainandagain,
            R.raw.tms_isthatbetter, R.raw.tms_myfirstquestiontoutonight,
            R.raw.tms_nowletmetelluveryclearly, R.raw.tms_nswermyquestion,
            R.raw.tms_thepointis, R.raw.tms_theydontdothat,
            R.raw.tms_thtsyudontlikeit,R.raw.tms_ucanhearmemr,
            R.raw.tms_urchallengedonfact, R.raw.tms_yishedoingtht,
            R.raw.tms_yousaid };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, null);


        gridArray.add("Anyway going back to the subject right now");
        gridArray.add("Don't be intolerant to me");
        gridArray.add("I am asking the questions");
        gridArray.add("I'm asking you tonight again and again!");
        gridArray.add("Is that better?");
        gridArray.add("My first question to you tonight is");
        gridArray.add("Now let me tell you very clearly");
        gridArray.add("Answer my question");
        gridArray.add("The point is this");
        gridArray.add("They don't do that");
        gridArray.add("That's why you don't like it");
        gridArray.add("You can hear me Mr.");
        gridArray.add("You are challenged on fact");
        gridArray.add("Why is he doing that");
        gridArray.add("You said!");



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