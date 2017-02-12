package marinatassi.amherstlunch;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Marina on 2/11/17.
 */

public class GetVal extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Document valWeb = Jsoup.connect("https://www.amherst.edu/campuslife/housing-dining/dining/menu").get();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String divTag = "dining-menu-" + dateFormat.format(date);

            //BREAKFAST HEADERS followed by BREAKFAST ITEMS
            String divTag1 = divTag + "-Breakfast-menu-listing";
            Elements breakfastE = valWeb.select("#" + divTag1);
            Elements breakfastHeaders = breakfastE.select(".dining-course-name");
            Elements breakfastItems = breakfastE.select("p");
            String[] food = new String[breakfastHeadersE.size()];






        }
        catch(IOException e){

        }
        return null;
    }


}
