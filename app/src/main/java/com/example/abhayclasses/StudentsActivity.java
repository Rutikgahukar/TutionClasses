package com.example.abhayclasses;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;

public class StudentsActivity extends AppCompatActivity {

    private TextView firstLetterTextViewOne;
    private TextView profileNameTextViewOne;
    ImageView NumberbackArrow ;
    Toolbar toolbartest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        NumberbackArrow = findViewById(R.id.NumberbackArrow);
        NumberbackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentsActivity.this, OtpActivity.class);
                startActivity(intent);
            }
        });

        // Assuming you have the following views in your activity_students layout
        LinearLayout userLayoutOne = findViewById(R.id.userlayoutone);
        firstLetterTextViewOne = findViewById(R.id.newonefirstLetterTextViewOne);
        profileNameTextViewOne = findViewById(R.id.profileNameTextViewOne);

        // Set first letter and background color for userLayoutOne
        setProfileData(userLayoutOne, firstLetterTextViewOne, profileNameTextViewOne);
        userLayoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstNameScreen(firstLetterTextViewOne.getText().toString(),
                        profileNameTextViewOne.getText().toString());
            }
        });

        // Assuming you have the following views in your activity_students layout
        LinearLayout userLayoutTwo = findViewById(R.id.userlayouttwo);
        TextView firstLetterTextViewTwo = findViewById(R.id.newtowfirstLetterTextView);
        TextView profileNameTextViewTwo = findViewById(R.id.profileNameTextViewTwo);

        // Set first letter and background color for userLayoutTwo
        setProfileData(userLayoutTwo, firstLetterTextViewTwo, profileNameTextViewTwo);
        userLayoutTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstNameScreen(firstLetterTextViewTwo.getText().toString(),
                        profileNameTextViewTwo.getText().toString());
            }
        });
        // Use the correct Toolbar class
        toolbartest = findViewById(R.id.toolbartest);

        // Set the toolbar as the ActionBar
        setSupportActionBar(toolbartest);

        // Set the title to an empty string to hide the app name
        getSupportActionBar().setTitle("");
    }
    private void openFirstNameScreen(String firstLetter, String username) {
        Intent intent = new Intent(this, FirstNameScreen.class);
        intent.putExtra("FIRST_LETTER", firstLetter);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }
    private void setProfileData(LinearLayout userLayout, TextView firstLetterTextView, TextView textView) {
        String name = textView.getText().toString();
        String firstLetter = name.substring(0, 1).toUpperCase();

        // Set background color based on first letter
        int backgroundColor = getRandomColor();

        // Set the circular background for the firstLetterTextView
        firstLetterTextView.setBackgroundResource(R.drawable.circular_background);
        GradientDrawable drawable = (GradientDrawable) firstLetterTextView.getBackground();
        drawable.setColor(backgroundColor);

        firstLetterTextView.setTextColor(Color.BLACK);
        firstLetterTextView.setText(firstLetter);
    }

    private int getRandomColor() {
        Random random = new Random();

        int[] pastelColors = {
                Color.rgb(255, 223, 186), // Fent Orange
                Color.rgb(173, 216, 230), // Fent Sky Blue
                Color.rgb(255, 255, 153), // Fent Yellow
                Color.rgb(255, 182, 193), // Fent Pink
                Color.rgb(144, 238, 144)  // Fent Green
        };

        // Choose a random pastel color from the array
        return pastelColors[random.nextInt(pastelColors.length)];
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        // Get the MenuItem for the search action
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Search Test");

        // Set a listener to handle the click event
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Apply the custom style
                searchView.setBackgroundResource(R.drawable.custom_searchview_background);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
