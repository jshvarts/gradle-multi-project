package com.udacity.gradle.builditbigger.jokes;

public class Joke {
    public static final String JOKE_1 = "i am a funny joke";
    public static final String JOKE_2 = "i am even a funnier joke";
    public static final String JOKE_3 = "i am not a funny joke at all";
    public static final String JOKE_4 = "i am not even a joke";
    public static final String JOKE_5 = "i used to be a joke";
    public static final String DEFAULT_JOKE = "this is one funny joke";

    private String text;

    Joke(String text) {
        if (text == null) {
            throw new IllegalArgumentException("joke passed to constructor is empty");
        }
        this.text = text;
    }

    public String getText() {
        if (text == null) {
            return DEFAULT_JOKE;
        }
        return text;
    }
}
