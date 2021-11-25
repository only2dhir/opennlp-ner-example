package com.devglan;

import org.junit.Test;

/**
 * Created by only2dhir on 15-07-2017.
 */
public class NERTester {

    @Test
    public  void nameFinderTest() throws Exception{
        NameFinder nameFinder = new NameFinder();
        nameFinder.findName("Where is Charlie and Mike.");
    }

    @Test
    public  void locationFinderTest() throws Exception{
        LocationFinder locFinder = new LocationFinder();
        locFinder.findLocation("Charlie is in California but I don't about Mike.");

    }
}
