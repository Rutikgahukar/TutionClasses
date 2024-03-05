package com.example.abhayclasses;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class FirstNameScreen extends AppCompatActivity {
    ImageView FiestNamebackArrow ,UsermenuIcon ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.username_screen);

        FiestNamebackArrow= findViewById(R.id.FiestNamebackArrow);
        FiestNamebackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstNameScreen.this, StudentsActivity.class);
                startActivity(intent);
            }
        });

        // Retrieve data from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String firstLetter = extras.getString("FIRST_LETTER");
            String username = extras.getString("USERNAME");

            // Set data in the corresponding views
            TextView firstLetterTextView = findViewById(R.id.userProfileicon);
            TextView usernameTextView = findViewById(R.id.SelectedUserName);

            if (firstLetter != null && username != null) {
                setProfileData(firstLetterTextView, usernameTextView, firstLetter, username);
            }
        }
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        // Set up ViewPager with the adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Link the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);

    }
    // FragmentPagerAdapter to handle fragments
    private static class ViewPagerAdapter extends FragmentPagerAdapter {

        ViewPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            // Return the corresponding fragment based on the position
            switch (position) {
                case 0:
                    return new StudentDetailsFragment();
                case 1:
                    return new CurrentAffairsFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Return the number of tabs
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            // Return the tab title based on the position
            switch (position) {
                case 0:
                    return "Student Updates";
                case 1:
                    return "Current Affairs";
                default:
                    return null;
            }
        }
    }

    private void setProfileData(TextView firstLetterTextView, TextView usernameTextView, String firstLetter, String username) {
        // Set the circular background for the firstLetterTextView
        firstLetterTextView.setBackgroundResource(R.drawable.circular_background);
        // Set the username and first letter
        usernameTextView.setText(username);
        firstLetterTextView.setText(firstLetter);
    }

}
