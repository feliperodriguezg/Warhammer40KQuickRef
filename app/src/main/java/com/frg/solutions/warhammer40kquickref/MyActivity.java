package com.frg.solutions.warhammer40kquickref;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import adapters.ReglasAdapter;
import data.ReaderJsonData;
import model.Regla;


public class MyActivity extends Activity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }

        //ReaderJsonData readerData = new ReaderJsonData();
        //String dato = readerData.Read();
        //Log.d("TEST", "Dato del json: " + dato);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        Log.d("TEST", "Tab seleccionado: " + tab.getPosition());
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
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
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
                case 3:
                    return getString(R.string.title_section4).toUpperCase(l);
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

            Bundle bundle = this.getArguments();

            int tabIndex = bundle.getInt(ARG_SECTION_NUMBER);
            View rootView = null;

            ReaderJsonData reader = new ReaderJsonData();
            reader.context = getActivity().getApplicationContext();
            reader.prefs = getActivity().getSharedPreferences("com.frg.solutions.warhammer40kquickref", Context.MODE_PRIVATE);

            if(tabIndex == 0){
                reader.Tab = R.layout.tab_reglas;
                rootView = inflater.inflate(R.layout.tab_reglas, container, false);

                ListView listVReglas = (ListView) rootView.findViewById(R.id.listVReglas);
                if(listVReglas.getChildCount() == 0) {
                    reader.lista = listVReglas;

                }
            }
            if(tabIndex == 1){
                reader.Tab = R.layout.tab_armas;
                rootView = inflater.inflate(R.layout.tab_armas, container, false);

                ListView listVArmas = (ListView) rootView.findViewById(R.id.listVArmas);
                if(listVArmas.getChildCount() == 0){
                    reader.lista = listVArmas;
                }
            }
            if(tabIndex == 2){
                reader.Tab = R.layout.tab_infanteria;
                rootView = inflater.inflate(R.layout.tab_infanteria, container, false);

                Resources res = getResources();

                TabHost tabs= (TabHost)rootView.findViewById(R.id.tabHost);
                tabs.setup();

                TabHost.TabSpec spec=tabs.newTabSpec("CG");
                spec.setContent(R.id.tab1);
                spec.setIndicator("CG",
                        res.getDrawable(android.R.drawable.ic_btn_speak_now));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("LINEA");
                spec.setContent(R.id.tab2);
                spec.setIndicator("Línea",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("ELITE");
                spec.setContent(R.id.tab3);
                spec.setIndicator("Elite",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("AP");
                spec.setContent(R.id.tab4);
                spec.setIndicator("AP",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("AR");
                spec.setContent(R.id.tab5);
                spec.setIndicator("AR",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                tabs.setCurrentTab(0);

                reader.listaCG = (ListView)tabs.findViewById(R.id.listVCG);
                reader.listaLinea = (ListView)tabs.findViewById(R.id.listVInfanteria);
                reader.listaElite = (ListView)tabs.findViewById(R.id.listVElite);
                reader.listaApoyoPesado = (ListView)tabs.findViewById(R.id.listVApoyoPesado);
                reader.listaAtaqueRapido = (ListView)tabs.findViewById(R.id.listVAtaqueRapido);
            }
            if(tabIndex == 3){
                rootView = inflater.inflate(R.layout.tab_vehiculos, container, false);

                Resources res = getResources();

                TabHost tabs= (TabHost)rootView.findViewById(R.id.tabHost);
                tabs.setup();

                TabHost.TabSpec spec=tabs.newTabSpec("CG");
                spec.setContent(R.id.tab1);
                spec.setIndicator("CG",
                        res.getDrawable(android.R.drawable.ic_btn_speak_now));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("LINEA");
                spec.setContent(R.id.tab2);
                spec.setIndicator("Línea",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("ELITE");
                spec.setContent(R.id.tab3);
                spec.setIndicator("Elite",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("AP");
                spec.setContent(R.id.tab4);
                spec.setIndicator("AP",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                spec=tabs.newTabSpec("AR");
                spec.setContent(R.id.tab5);
                spec.setIndicator("AR",
                        res.getDrawable(android.R.drawable.ic_dialog_map));
                tabs.addTab(spec);

                tabs.setCurrentTab(0);
            }

            reader.execute("");

            return rootView;
        }
    }

}
