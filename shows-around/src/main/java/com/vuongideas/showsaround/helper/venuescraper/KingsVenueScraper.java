package com.vuongideas.showsaround.helper.venuescraper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.vuongideas.showsaround.model.Show;

@Component
public class KingsVenueScraper implements VenueScraper {
    
    @Override
    public List<Show> getShows() {
        // TODO Auto-generated method stub
        List<Show> results = new ArrayList<Show>();
        
        
        
        try {
            DateFormat timeFormat = new SimpleDateFormat("h:mma");
            timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            
            Document doc = Jsoup.connect("http://www.kingsraleigh.com/").get();
            Elements rows = doc.select("table#Shows tr");
            
            
            for (Element row : rows) {
                Show show = new Show();
                
                // title
                show.setTitle(row.select("h3 a").first().text());
                
                // date
                show.setDate(new SimpleDateFormat("EEEE, MMMMM d, yyyy")
                        .parse(row.select("p.date")
                                .first()
                                .text()
                                .replaceAll("(?<=\\d)(st|nd|rd|th)", "")));
                
                // start time
                String startTime = row.select("p:contains(Time:)")
                        .first()
                        .text()
                        .replace("Time:", "")
                        .trim();
                
                show.setStartTime(timeFormat
                        .parse(startTime));
                
                // door time
                show.setDoorTime(timeFormat
                        .parse(row.select("p:contains(Doors:)")
                                .first()
                                .text()
                                .replace("Doors:", "")
                                .trim()));
                
                
                // admission
                show.setAdmission(row.select("p:contains(Admission:)").first().text().replace("Admission:", "").trim());
                
                // location
                show.setLocation("Kings");
                

                
                
                results.add(show);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return results;
    }

}
