package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.jokeintenthandler.HandleJokeActivity;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private JokeEndpointAsyncTask jokeEndpointAsyncTask;
    private String googleBackendAppId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeEndpointAsyncTask = new JokeEndpointAsyncTask(this);

        googleBackendAppId = this.getString(R.string.google_app_id);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (jokeEndpointAsyncTask == null) {
            Log.e(TAG, "jokeEndpointAsyncTask should not be null");
            return;
        }

        //if there is a joke endpoint async task request currently in progress, don't fire another one
        if (jokeEndpointAsyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            Log.e(TAG, "jokeEndpointAsyncTask already executing.");
            return;
        }

        jokeEndpointAsyncTask = new JokeEndpointAsyncTask(this);
        jokeEndpointAsyncTask.execute();
    }

    private class JokeEndpointAsyncTask extends AsyncTask<Object, Void, String> {
        private MyApi myApiService = null;
        private Context context;

        protected JokeEndpointAsyncTask(Context context) {
            if (context == null) {
                Log.e(MainActivity.class.getSimpleName(), "null context passed in");
            }
            this.context = context;
        }

        @Override
        protected String doInBackground(Object... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://" + googleBackendAppId + ".appspot.com/_ah/api/");
                myApiService = builder.build();
            }

            try {
                return myApiService.tellJoke().execute().getData();
            } catch (IOException e) {
                Log.e(TAG, "error executing the joke endpoint to get data");
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d(TAG, "joke data retrieved: " + result);
            Intent intent = new Intent(context, HandleJokeActivity.class);
            intent.putExtra(HandleJokeActivity.JOKE_TEXT_EXTRA, result);
            startActivity(intent);
        }
    }
}
