package com.example.abhayclasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

public class Message_5 extends AppCompatActivity {
    Toolbar toolbartest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_5);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Message_5.this,FirstNameScreen.class);
                startActivity(intent);
            }
        });
        // Use the correct Toolbar class
        toolbartest = findViewById(R.id.toolbartest);

        // Set the toolbar as the ActionBar
        setSupportActionBar(toolbartest);

        // Set the title to an empty string to hide the app name
        getSupportActionBar().setTitle("");
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