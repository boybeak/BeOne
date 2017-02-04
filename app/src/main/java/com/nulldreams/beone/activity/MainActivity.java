package com.nulldreams.beone.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;

import com.nulldreams.beone.R;
import com.nulldreams.beone.fragment.ContentFragment;
import com.nulldreams.beone.fragment.HomeFragment;
import com.nulldreams.beone.fragment.MovieFragment;
import com.nulldreams.beone.fragment.MusicFragment;
import com.nulldreams.beone.fragment.ReadingFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private BottomNavigationView mBottomNavView;

    private ContentFragment mLastFragment = null;

    private HomeFragment mHomeFragment;
    private ReadingFragment mReadingFragment;
    private MusicFragment mMusicFragment;
    private MovieFragment mMovieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHomeFragment = HomeFragment.newInstance();
        mReadingFragment = ReadingFragment.newInstance();
        mMusicFragment = MusicFragment.newInstance();
        mMovieFragment = MovieFragment.newInstance();

        showFragment(HomeFragment.newInstance());

        mBottomNavView = (BottomNavigationView)findViewById(R.id.main_nav_view);

        mBottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        showFragment(mHomeFragment);
                        break;
                    case R.id.nav_reading:
                        showFragment(mReadingFragment);
                        break;
                    case R.id.nav_music:
                        showFragment(mMusicFragment);
                        break;
                    case R.id.nav_movie:
                        showFragment(mMovieFragment);
                        break;
                }
                return true;
            }
        });

    }

    private void showFragment (ContentFragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mLastFragment != null) {
            ft.hide(mLastFragment);
        }
        if (fragment.isAdded()) {
            ft.show(fragment);
        } else {
            ft.add(R.id.main_fragment_container, fragment);
        }
        ft.commit();
        mLastFragment = fragment;
    }
}
