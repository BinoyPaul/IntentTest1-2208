package com.example.binoypaul.intenttest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Apple extends AppCompatActivity {

    Button b;
    EditText appleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b = (Button) findViewById(R.id.appleButton);
        appleText = (EditText) findViewById(R.id.appleText);
        Intent i = new Intent(this, MyService.class);
        startService(i);

        b.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Log.i("bTest", "Button is clicked");
                        makeIntent(v);
                    }

                }
        );


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void makeIntent (View view)
        {
            Log.i("bTest", "Inside the click method");
            Intent i = new Intent(this, Bacon.class);
            i.putExtra("appleMessage", appleText.getText().toString());
            startActivity(i);

        }

}
