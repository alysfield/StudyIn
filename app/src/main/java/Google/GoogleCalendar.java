package Google;

import android.os.AsyncTask;

import yse.studyin.MainActivity;

/**
 * Created by yiltan on 1/1/2017.
 */

public abstract class GoogleCalendar extends AsyncTask<Void, Void, Void> {

    protected MainActivity mActivity;
    protected String calendarId = "primary";
    protected String timeZone = "Canada/Eastern";

    /**
     * Constructor.
     * @param activity MainActivity that spawned this task.
     */
    public GoogleCalendar(MainActivity activity){
        this.mActivity=activity;
    }

    protected abstract Void doInBackground(Void... params);

    /**
     * Method to set the Google calendar we want to modify
     * by default it is set to "Primary"
     * @param id - A string of the calendar id
     */
    public void setCalendarId(String id){
        //TODO error checking
        calendarId = id;
    }

    /**
     * Method to set the time zone for the event
     * by default it is set to "Canada/Eastern"
     * @param timeZone - String formatted as an IANA Time Zone Database name
     */
    public void setTimeZone(String timeZone){
        //TODO error checking
        this.timeZone = timeZone;
    }

    public void updateCalFile(){

    }

    public void deleteEvent(){

    }

    public void moveEvent(){

    }

    public void googleLogIn(){

    }

    public void modifyEvent(){

    }





}
