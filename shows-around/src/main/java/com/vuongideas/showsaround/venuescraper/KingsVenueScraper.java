package com.vuongideas.showsaround.venuescraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.vuongideas.showsaround.model.Show;

public class KingsVenueScraper implements VenueScraper {

    @Override
    public List<Show> getShows() {
        // TODO Auto-generated method stub
        List<Show> results = new ArrayList<Show>();
        
        try {
            Document doc = Jsoup.connect("http://www.kingsraleigh.com/").get();
            
            Elements rows = doc.select("table#Shows tr");
            for (Element row : rows) {
                Show show = new Show();
                
                show.setTitle(row.select("h3 a").first().text());
                String dateString = row.select("p.date").first().text();
                
                results.add(show);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return results;
    }

}
