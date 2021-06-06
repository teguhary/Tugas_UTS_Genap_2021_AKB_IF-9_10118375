package com.example.catatanharian.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.catatanharian.main.menu.main.home.HomeFragment;
import com.example.catatanharian.main.menu.main.notes.NotesFragment;
import com.example.catatanharian.main.menu.main.profile.ProfileFragment;
import com.example.catatanharian.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnItemSelectedListener navigation = new BottomNavigationView.OnItemSelectedListener(){
        public boolean onNavigationItemSelected( MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()){
                case R.id.menu_home:
                    f = new HomeFragment();
                    break;
                case R.id.menu_notes:
                    f = new NotesFragment();
                    break;
                case R.id.menu_profile:
                    f = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, f).commit();
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        bottomNavigationView.setOnItemSelectedListener(navigation);
    }
}