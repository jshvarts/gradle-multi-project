package com.udacity.gradle.builditbigger.jokes;

public class Joke {
    private static final String DEFAULT_JOKE = "this is one funny joke";
    private String joke;

    public String getJoke() {
        if (joke == null) {
            return DEFAULT_JOKE;
        }
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
