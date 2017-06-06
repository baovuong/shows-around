package com.vuongideas.showsaround;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.vuongideas.showsaround.model.Show;
import com.vuongideas.showsaround.venuescraper.KingsVenueScraper;
import com.vuongideas.showsaround.venuescraper.VenueScraper;

public class ScraperTests {

    @Test
    public void test() {
        VenueScraper scraper = new KingsVenueScraper();
        List<Show> shows = scraper.getShows();
        for (Show show : shows) {
            System.out.println(show.getTitle());
        }
    }
}
