package com.udacity.gradle.builditbigger.jokes;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by shvartsy on 3/20/16.
 */
public class JokeFactoryTest {

    private JokeFactory jokeFactory;
    private Set<String> randomJokes;

    @Before
    public void setUp(){
        jokeFactory = JokeFactory.getInstance();

        randomJokes = new HashSet<>(5);
        randomJokes.add(Joke.JOKE_1);
        randomJokes.add(Joke.JOKE_2);
        randomJokes.add(Joke.JOKE_3);
        randomJokes.add(Joke.JOKE_4);
        randomJokes.add(Joke.JOKE_5);
    }

    @Test
    public void verifyNotNull() {
        assertNotNull(jokeFactory);
    }

    @Test
    public void verifyReturnJokeNotEmpty() {
        assertNotNull(jokeFactory.getJoke());
        assertTrue(!jokeFactory.getJoke().getText().isEmpty());
    }

    @Test
    public void verifyReturnJokeOneOfSupported() {
        assertTrue(randomJokes.contains(jokeFactory.getJoke().getText()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyFailedInstantiation() {
        new Joke(null);
    }
}
