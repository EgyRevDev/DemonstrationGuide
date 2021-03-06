package com.showair.Demonstratorguide;

import java.util.Locale;

import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdvicesActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advices);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.advice_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        /* Customize the page title*/
        PagerTabStrip pageStrip = (PagerTabStrip)findViewById(R.id.advice_page_stripper);
        customizeStripper(pageStrip);
    }

    private void customizeStripper(PagerTabStrip a_strip){
        a_strip.setBackgroundColor(Color.LTGRAY);
        a_strip.setTabIndicatorColor(Color.DKGRAY);
        a_strip.setTextColor(Color.BLUE);
        a_strip.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.advices, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }

        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // total number of advice pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            /* I am not sure what is the importance of the following line?!!*/
            Locale dl = Locale.getDefault();


            switch (position) {
                case 0:
                    return getString(R.string.advice_title_section1);
                case 1:
                    return getString(R.string.advice_title_section2);
                case 2:
                    return getString(R.string.advice_title_section3);
                case 3:
                    return getString(R.string.advice_title_section4);
                case 4:
                    return getString(R.string.advice_title_section5);
                case 5:
                    return getString(R.string.advice_title_section6);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_advices, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.advice_content);

            /* Inflate XML string array to Java object array of strings */
            String advicesArray []= getResources().getStringArray(R.array.ListOfAdvices);

            int indexOfAdvice = getArguments().getInt(ARG_SECTION_NUMBER);

            /* Set the text view with the corresponding advice contents*/
            textView.setText(advicesArray[indexOfAdvice]);
            return rootView;
        }
    }

}
