package marinatassi.amherstlunch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

/**
 * Created by Marina on 2/7/17.
 */
public class DiningMenu extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Intent intent = getIntent();

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.Food);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Breakfast");
        listDataHeader.add("Lunch");
        listDataHeader.add("Dinner");

        // Adding child data
        List<String> Breakfast = new ArrayList<String>();
        Breakfast.add("TESTBF");

        List<String> Lunch = new ArrayList<String>();
        Lunch.add("TESTL");

        List<String> Dinner = new ArrayList<String>();
        Dinner.add("TESTD");

        listDataChild.put(listDataHeader.get(0), Breakfast); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Lunch);
        listDataChild.put(listDataHeader.get(2), Dinner);
    }
}