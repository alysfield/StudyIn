package yse.studyin;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Owner on 2017-01-12.
 */

public class ResourceExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> expandableListHeader;
    private HashMap<String, List<String>> expandableListData;

    public ResourceExpandableListAdapter(Context context, List<String> expandableListHeader, HashMap<String, List<String>> expandableListData) {
        this.context = context;
        this.expandableListHeader = expandableListHeader;
        this.expandableListData = expandableListData;
    }

    @Override
    public int getGroupCount() {
        return this.expandableListHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.expandableListData.get(this.expandableListHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.expandableListHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.expandableListData.get(this.expandableListHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String headerTxt = (String)getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView listHeaderTextView = (TextView) convertView.findViewById(R.id.expandedListHeader);
        listHeaderTextView.setTypeface(null, Typeface.BOLD);
        listHeaderTextView.setText(headerTxt);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListTxt = (String)getChild(groupPosition, childPosition);

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListTxt);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
