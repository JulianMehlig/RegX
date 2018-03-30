package regx.expandablelist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Julian on 30.03.2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter
{
    private Context context;
    private List<String> StringData;
    private HashMap<String, List<String>> listHashMap;

    public ExpandableListAdapter(Context context, List<String> stringData, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        StringData = stringData;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return StringData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(StringData.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return StringData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(StringData.get(i)).get(i1); // i = Group Item i1 = Child Item
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader = (TextView) view.findViewById(R.id.listheading);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String) getChild(i, i1);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        TextView textListChild = (TextView) view.findViewById(R.id.listitem);
        textListChild.setText(childText);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
