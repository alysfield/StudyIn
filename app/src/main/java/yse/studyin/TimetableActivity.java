package yse.studyin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class TimetableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        updateDate();
    }

    // update date on timetable
    private void updateDate() {
        TextView tv = (TextView) findViewById(R.id.calendarID);
        String date = getIntent().getStringExtra("SELECTED_DATE");
        tv.setText(date);
    }
}
