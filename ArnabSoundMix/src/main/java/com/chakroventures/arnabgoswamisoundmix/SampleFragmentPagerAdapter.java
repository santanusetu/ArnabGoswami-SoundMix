package com.chakroventures.arnabgoswamisoundmix;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    final int PAGE_COUNT = 8;
    private String tabTitles[] = new String[]{"Trademarks", "Sarcastic", "Hindi", "Names", "Patriotic", "Warning", "Others@Arnab", "Random"};

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentTrademarks();
        } else if (position == 1) {
            return new FragmentSarcastic();
        } else if (position == 2) {
            return new FragmentHindi();
        } else if (position == 3) {
            return new FragmentNames();
        } else if (position == 4) {
            return new FragmentPatriotic();
        } else if (position == 5) {
            return new FragmentWarning();
        } else if (position == 6) {
            return new FragmentOthers();
        } else if (position == 7) {
            return new FragmentRandom();
        }

        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}