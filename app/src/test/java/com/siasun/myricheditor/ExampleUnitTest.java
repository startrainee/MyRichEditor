package com.siasun.myricheditor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        int a = Integer.MAX_VALUE;
        float b = Float.MAX_VALUE;
        System.out.println(Math.round(b));
        System.out.println(Math.round(111111.1f));
        System.out.println(Math.round(111f));
        System.out.println(Math.round(12.1f));
        System.out.println(Math.round(12.5f));



        assertEquals(4, 2 + 2);
    }
}