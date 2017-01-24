package yse.studyin;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchAddEvent = new Intent(CalendarActivity.this, AddEventActivity.class);
                startActivity(launchAddEvent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // CALENDAR TOAST BUTTON
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day){
                month = month + 1; // set January to month 1 instead of month 0
                String charMonth = charMonth(month);

                String date = charMonth + " " + day + ", " + year;

                Intent intent = new Intent(CalendarActivity.this, TimetableActivity.class);

                intent.putExtra("SELECTED_DATE", date); // pass the date to the timetable activity
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_soluslogin) {
            Intent intent = new Intent(this, SolusLoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_add) {
            Intent intent = new Intent(this, AddEventActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_edit) {
            // When user wishes to edit an activity they are sent to the Google Calander site
            Intent googleCalLink = new Intent();
            googleCalLink.setAction(Intent.ACTION_VIEW);
            googleCalLink.addCategory(Intent.CATEGORY_BROWSABLE);
            googleCalLink.setData(Uri.parse("https://www.google.com/calendar"));
            startActivity(googleCalLink);

        } else if (id == R.id.nav_preferences) {
            Intent intent = new Intent(this, PreferencesActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public String charMonth(int month){
        String charMonth;
        if(month == 1)
            charMonth = "January";
        else if(month == 2)
            charMonth = "February";
        else if(month == 3)
            charMonth = "March";
        else if(month == 4)
            charMonth = "April";
        else if (month == 5)
            charMonth = "May";
        else if (month == 6)
            charMonth = "June";
        else if (month == 7)
            charMonth = "July";
        else if (month == 8)
            charMonth = "August";
        else if (month == 9)
            charMonth = "September";
        else if (month == 10)
            charMonth = "October";
        else if (month == 11)
            charMonth = "November";
        else if (month == 12)
            charMonth = "December";
        else
            charMonth = "Illegal Month";
        return charMonth;
    }
}
