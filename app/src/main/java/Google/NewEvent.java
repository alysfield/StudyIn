package Google;

import android.os.AsyncTask;

import yse.studyin.MainActivity;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by yiltan on 1/2/2017.
 */

public class NewEvent extends GoogleCalendar {
    private Event event;

    /**
     * Constructor.
     * @param activity MainActivity that spawned this task.
     */
    public NewEvent(MainActivity activity){
        super(activity);
        event = new Event();
    }

    protected Void doInBackground(Void... params) {
        try {
            //TODO modify to react with GUI or controller class
            mActivity.clearResultsText();
            event = mActivity.mService.events().insert(calendarId, event).execute();
            String s = "Event created";
            mActivity.updateResultsText(s);

        } catch (final GooglePlayServicesAvailabilityIOException availabilityException) {
            mActivity.showGooglePlayServicesAvailabilityErrorDialog(
                    availabilityException.getConnectionStatusCode());

        } catch (UserRecoverableAuthIOException userRecoverableException) {
            mActivity.startActivityForResult(
                    userRecoverableException.getIntent(),
                    mActivity.REQUEST_AUTHORIZATION);

        } catch (IOException e) {
            mActivity.updateStatus("The following error occurred: " +
                    e.getMessage());
        }
        return null;
    }

    /**
     * Create the start time of the event
     * @param year - the year.
     * @param month - the month between 1-12.
     * @param date - the day of the month between 1-31.
     * @param hrs - the hours between 0-23.
     * @param min - the minutes between 0-59.
     **/
    public void startTime(int year, int month, int date, int hrs, int min){
        // Date constructor requires (year - 1900)
        // and requires month values between 0-11
        //TODO error checking
        Date value = new Date(year - 1900, month - 1, date, hrs, min);
        DateTime startDateTime = new DateTime(value);
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone(timeZone);
        event.setStart(start);
    }

    /**
     * Create the start time of the event
     * @param year - the year.
     * @param month - the month between 1-12.
     * @param date - the day of the month between 1-31.
     * @param hrs - the hours between 0-23.
     * @param min - the minutes between 0-59.
     **/
    public void endTime(int year, int month, int date, int hrs, int min){
        // Date constructor requires (year - 1900)
        // and requires month values between 0-11
        //TODO error checking
        Date value = new Date(year -1900, month - 1, date, hrs, min);
        DateTime endDateTime = new DateTime(value);
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone(timeZone);
        event.setEnd(end);
    }

    /**
     * Function to set the name of the event
     * @param name - A string value of the name
     */
    public void setName(String name){
        event.setSummary(name);
    }

    /**
     * Method to set the location of the event
     * @param location - A string value of the location
     */
    public void setLocation(String location){
        event.setLocation(location);
    }

    /**
     * Method to set the description of the event
     * @param des - A string value of the description
     */
    public void setDescription(String des){
        event.setDescription(des);
    }

    /**
     * Function to return the event object that as just created
     * @return event object
     */
    public Event getEvent(){
        return event;
    }

    //TODO finish this method
    public void reminder(){
        EventReminder[] reminderOverrides = new EventReminder[] {
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);
    }

}
