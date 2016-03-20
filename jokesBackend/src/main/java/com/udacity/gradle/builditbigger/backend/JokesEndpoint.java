/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.jokes.Joke;
import com.udacity.gradle.builditbigger.jokes.JokeFactory;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.gradle.udacity.com",
    ownerName = "backend.builditbigger.gradle.udacity.com",
    packagePath=""
  )
)
public class JokesEndpoint {

    /** A simple endpoint method that retrieves and returns a joke */
    @ApiMethod(name = "tellJoke")
    public JokeBean tellJoke() {
        JokeBean response = new JokeBean();
        response.setData(JokeFactory.getInstance().getJoke().getText());
        return response;
    }
}
