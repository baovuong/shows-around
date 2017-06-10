package com.vuongideas.showsaround.controller;

import java.util.Collections;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuongideas.showsaround.helper.StringHelper;
import com.vuongideas.showsaround.helper.venuescraper.VenueScraper;
import com.vuongideas.showsaround.model.Show;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "SHOWS AROUND";
    }
    
    @RequestMapping("/shows/{name}")
    public Iterable<Show> shows(@PathVariable String name) {
        VenueScraper scraper = createScraper(name);
        return scraper == null ? Collections.<Show>emptyList() : scraper.getShows();
    }
    
    
    private VenueScraper createScraper(String name) {
        try {
            Class<?> cls;
            cls = Class.forName("com.vuongideas.showsaround.helper.venuescraper." + StringHelper.toCamelCase(name)
                    + "VenueScraper");
            return (VenueScraper) cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }        
    }
}
