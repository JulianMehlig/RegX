package regx.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.explist);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData()
    {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Android");
        listDataHeader.add("IOS");
        listDataHeader.add("Passt");

        List<String> androidlist = new ArrayList<>();
        androidlist.add("Expandable");



        List<String> ioslist = new ArrayList<>();
        ioslist.add("IOS Expand");

        List<String> passtlist = new ArrayList<>();
        passtlist.add("Passt Expans#d");

        listHashMap.put(listDataHeader.get(0), androidlist);
        listHashMap.put(listDataHeader.get(1), ioslist);
        listHashMap.put(listDataHeader.get(2), passtlist);


    }
}
