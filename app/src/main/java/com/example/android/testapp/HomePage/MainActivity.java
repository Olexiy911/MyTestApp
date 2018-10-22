package com.example.android.testapp.HomePage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.android.testapp.R;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("AudioBooks");
        //load first Fragment
        loadFragment(new AudioBooksFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_audio_books:
                    toolbar.setTitle(getResources().getString(R.string.title_audio_books));
                    fragment = new AudioBooksFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_movies:
                    toolbar.setTitle(getResources().getString(R.string.title_movies));
                    fragment = new MoviesFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_podcasts:
                    toolbar.setTitle(getResources().getString(R.string.title_podcasts));
                    fragment = new PodcastsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_favorites:
                    toolbar.setTitle(getResources().getString(R.string.title_favorites));
                    fragment = new FavoritesFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null).commit();
    }

}
