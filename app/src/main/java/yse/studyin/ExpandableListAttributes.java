package yse.studyin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Owner on 2017-01-12.
 */

public class ExpandableListAttributes {
    public static HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> expandableList = new HashMap<String, List<String>>();

        // Study Tips
        List<String> studyTips = new ArrayList<String>();
        studyTips.add("Student Wellness Services");
        studyTips.add("Learning Strategies");
        studyTips.add("Quizlet");

        // Online Tools
        List<String> onlineTools = new ArrayList<String>();
        onlineTools.add("WolframAlpha");
        onlineTools.add("Thesaurus");
        onlineTools.add("Google Scholar");

        // Queen's Links
        List<String> queensWeb = new ArrayList<String>();
        queensWeb.add("OnQ");
        queensWeb.add("Office 365");
        queensWeb.add("Library");
        queensWeb.add("Dining Hours");
        queensWeb.add("ARC Hours");
        queensWeb.add("Career Services");

        expandableList.put("STUDY TOOLS", studyTips);
        expandableList.put("QUEEN'S UNIVERSITY LINKS", queensWeb);
        expandableList.put("ONLINE TOOLS", onlineTools);

        return expandableList;
    }
}
