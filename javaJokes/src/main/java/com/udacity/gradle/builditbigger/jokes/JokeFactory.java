package com.udacity.gradle.builditbigger.jokes;

import java.util.Random;

/**
 * Created by shvartsy on 3/20/16.
 */
public class JokeFactory {
    private static JokeFactory instance;

    private JokeFactory() {
        // prevent others from instantiating
    }

    public static JokeFactory getInstance() {
        if (instance == null) {
            instance = new JokeFactory();
        }
        return instance;
    }

    public Joke getJoke() {
        final int maxJoke = 5;
        final int minJoke = 1;

        Random rand = new Random();
        int randJokeNum = rand.nextInt((maxJoke - minJoke) + 1) + minJoke;
        switch (randJokeNum) {
            case 1:
                return new Joke(Joke.JOKE_1);
            case 2:
                return new Joke(Joke.JOKE_2);
            case 3:
                return new Joke(Joke.JOKE_3);
            case 4:
                return new Joke(Joke.JOKE_4);
            case 5:
                return new Joke(Joke.JOKE_5);
            default:
                throw new IllegalStateException("unable to generate a random joke");
        }
    }
}
