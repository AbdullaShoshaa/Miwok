package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Shoshaa on 8/18/16.
 */

public class CategoriesFragmentAdapter extends FragmentPagerAdapter{

    Context mContext;

    public CategoriesFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

//        switch (position){
//            case 0: return new NumbersFragment();
//            case 1: return new FamilyFragment();
//            case 2: return new ColorsFragment();
//            case 3: return new PhrasesFragment();
//            default: return null;
//        }
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0: return mContext.getString(R.string.category_numbers);
            case 1: return mContext.getString(R.string.category_family);
            case 2: return mContext.getString(R.string.category_colors);
            case 3: return mContext.getString(R.string.category_phrases);
            default: return null;
        }
    }
}
