package yse.studyin;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResourceActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListHeader;
    HashMap<String, List<String>> expandableListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        expandableListView = (ExpandableListView)findViewById(R.id.expandListView);
        expandableListData = ExpandableListAttributes.getData();
        expandableListHeader = new ArrayList<String>(expandableListData.keySet());
        expandableListAdapter = new ResourceExpandableListAdapter(this, expandableListHeader, expandableListData);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                String website;
                website = expandableListData.get(expandableListHeader.get(groupPosition)).get(childPosition);

                // Study Tips
                if(website == "Student Wellness Services"){
                    intent.setData(Uri.parse("http://www.queensu.ca/studentwellness/"));
                    startActivity(intent);
                }

                if(website == "Learning Strategies"){
                    intent.setData(Uri.parse("http://sass.queensu.ca/learningstrategies/topics/"));
                    startActivity(intent);
                }

                if(website == "Quizlet"){
                    intent.setData(Uri.parse("https://quizlet.com"));
                    startActivity(intent);
                }

                // Online tools
                if(website == "WolframAlpha") {
                    intent.setData(Uri.parse("https://www.wolframalpha.com"));
                    startActivity(intent);
                }

                if(website == "Thesaurus") {
                    intent.setData(Uri.parse("http://www.thesaurus.com"));
                    startActivity(intent);
                }

                if(website == "Google Scholar"){
                    intent.setData(Uri.parse("https://scholar.google.ca"));
                    startActivity(intent);
                }

                // Queens' Website
                if(website == "OnQ") {
                    intent.setData(Uri.parse("http://www.queensu.ca/its/onq"));
                    startActivity(intent);
                }

                if(website == "Office 365") {
                    intent.setData(Uri.parse("https://outlook.office.com"));
                    startActivity(intent);
                }

                if(website == "Library") {
                    intent.setData(Uri.parse("http://library.queensu.ca"));
                    startActivity(intent);
                }

                if(website == "Dining Hours"){
                    intent.setData(Uri.parse("http://dining.queensu.ca/hours-of-operations/"));
                    startActivity(intent);
                }

                if(website == "ARC Hours"){
                    intent.setData(Uri.parse("http://rec.gogaelsgo.com/sports/2013/7/26/Fac-Serv_0726132155.aspx?tab=hoursofoperation2"));
                    startActivity(intent);
                }

                if(website == "Career Services"){
                    intent.setData(Uri.parse("http://careers.queensu.ca/"));
                    startActivity(intent);
                }

                return false;
            }
        });

    }
}
