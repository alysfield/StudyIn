package Google;

import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

import yse.studyin.MainActivity;
import java.io.IOException;

/**
 * Created by yiltan on 1/2/2017.
 */

public class DeleteEvent extends GoogleCalendar {

    String eventId;

    /**
     * Constructor.
     * @param activity MainActivity that spawned this task.
     */
    public DeleteEvent(MainActivity activity, String eventId) {
        super(activity);
        this.eventId = eventId;
    }

    public DeleteEvent(MainActivity activity, String eventId, String calendarId) {
        super(activity);
        this.setCalendarId(calendarId);
        this.eventId = eventId;
    }

    protected Void doInBackground(Void... params) {
        try {
            //TODO modify to react with GUI or controller class
            mActivity.clearResultsText();
            mActivity.mService.events().delete(calendarId, eventId).execute();
            mActivity.updateResultsText("Event Deleted");

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

}
