package com.udacity.gradle.builditbigger.jokeintenthandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class HandleJokeActivity extends AppCompatActivity {

    public static final String JOKE_TEXT_EXTRA = "jokeintenthandler.joke_text_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_joke);

        String jokeText = getIntent().getStringExtra(JOKE_TEXT_EXTRA);
        if (TextUtils.isEmpty(jokeText)) {
            Toast.makeText(this, "Joke text is required", Toast.LENGTH_SHORT).show();
            return;
        }

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
        if (jokeTextView == null) {
            Log.e(getClass().getSimpleName(), "Joke text view is null");
            return;
        }

        jokeTextView.setText(jokeText);
    }
}
