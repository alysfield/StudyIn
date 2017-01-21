package yse.studyin;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class PreferencesActivity extends AppCompatActivity {

    // Bedtime Button
    static final int BEDTIME_DIALOG_ID = 0;
    Button Bedtime;
    int bHour;
    int bMinute;

    // Wake Up Button
    static final int WAKETIME_DIALOG_ID = 1;
    Button Waketime;
    int wHour;
    int wMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        showBedtimeOnClick();
        showWaketimeOnClick();
    }

    @Override
    protected Dialog onCreateDialog(int ID){
        if(ID == BEDTIME_DIALOG_ID)
            return new TimePickerDialog(this, timeListener, bHour, bMinute, false);
        if(ID == WAKETIME_DIALOG_ID)
            return new TimePickerDialog(this, wTimeListener, wHour, wMinute,false);
        return null;
    }

    // SET BEDTIME -------------------------------
    public void showBedtimeOnClick(){
        Bedtime = (Button) findViewById(R.id.button7);
        Bedtime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showDialog(BEDTIME_DIALOG_ID);
            }
        });
    }

    private TimePickerDialog.OnTimeSetListener timeListener =
            new TimePickerDialog.OnTimeSetListener(){
                @Override
                public void onTimeSet(TimePicker view, int bHrNum, int bMinNum){
                    String AM_PM;
                    if(bHrNum < 12){
                        AM_PM = "AM";
                        bHour = bHrNum;
                    } else {
                        AM_PM = "PM";
                        bHour = bHrNum - 12;
                    }
                    bMinute = bMinNum;

                    // Change text on button
                    if(bMinute == 0)
                        Bedtime.setText(bHour + ":" + "00" + " " + AM_PM);
                    else
                        Bedtime.setText(bHour + ":" + bMinute + " " + AM_PM);
                }
            };

    // SET WAKE UP TIME -------------------------------
    public void showWaketimeOnClick(){
        Waketime = (Button) findViewById(R.id.button8);
        Waketime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showDialog(WAKETIME_DIALOG_ID);
            }
        });
    }

    private TimePickerDialog.OnTimeSetListener wTimeListener =
            new TimePickerDialog.OnTimeSetListener(){
                @Override
                public void onTimeSet(TimePicker view, int wHrNum, int wMinNum){
                    String AM_PM;
                    if(wHrNum < 12){
                        AM_PM = "AM";
                        wHour = wHrNum;
                    } else {
                        AM_PM = "PM";
                        wHour = wHrNum - 12;
                    }
                    wMinute = wMinNum;

                    // Change text on button
                    if(wMinute == 0)
                        Waketime.setText(wHour + ":" + "00" + " " + AM_PM);
                    else
                        Waketime.setText(wHour + ":" + wMinute + " " + AM_PM);
                }
            };
}
