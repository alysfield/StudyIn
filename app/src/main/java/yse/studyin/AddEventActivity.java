package yse.studyin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity {

    // Date Button
    Button Date;
    int year;
    int month;
    int day;
    static final int DATE_DIALOG_ID = 0;

    // Time Button
    static final int TIME_DIALOG_ID = 1;
    Button Time;
    int hour;
    int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        showDateOnClick();
        showTimeOnClick();
    }

    // SET DATE -----------------------------------------
    public void showDateOnClick(){
        Date = (Button) findViewById(R.id.button4);
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int ID){
        if(ID == DATE_DIALOG_ID)
            return new DatePickerDialog(this, dateListener, year, month, day);
        if(ID == TIME_DIALOG_ID)
            return new TimePickerDialog(this, timeListener, hour, minute, false);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dateListener
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int yearNum, int monthNum, int dayNum){
            year = yearNum;
            month = monthNum + 1;
            day = dayNum;

            // change text on button
            Date.setText(year + "-" + month + "-" + day);
        }
    };

    // SET TIME -----------------------------------------------
    public void showTimeOnClick(){
        Time = (Button) findViewById(R.id.button5);
        Time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showDialog(TIME_DIALOG_ID);
            }
        });
    }

    private TimePickerDialog.OnTimeSetListener timeListener =
            new TimePickerDialog.OnTimeSetListener(){
                @Override
                public void onTimeSet(TimePicker view, int hourNum, int minuteNum){
                    String AM_PM;
                    if(hourNum < 12){
                        AM_PM = "AM";
                        hour = hourNum;
                    } else {
                        AM_PM = "PM";
                        hour = hourNum - 12;
                    }
                    minute = minuteNum;

                    // Change text on button
                    if(minute == 0)
                        Time.setText(hour + ":" + "00" + " " + AM_PM);
                    else
                        Time.setText(hour + ":" + minute + " " + AM_PM);
                }
            };
}
