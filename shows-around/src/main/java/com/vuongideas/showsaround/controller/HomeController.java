package com.vuongideas.showsaround.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Show> shows = new ArrayList<Show>();
        try {
            Class<?> cls = Class.forName("com.vuongideas.showsaround.helper.venuescraper." + StringHelper.toCamelCase(name) + "VenueScraper");
            VenueScraper scraper = (VenueScraper) cls.getDeclaredConstructor().newInstance();
            shows.addAll(scraper.getShows());
        } catch (ClassNotFoundException e) {
            
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return shows;
    }
    
    
}
