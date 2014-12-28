package cs.abraham.mikee.sam.frcwiremapper._0_splash_screen;

import cs.abraham.mikee.sam.frcwiremapper._0_splash_screen.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._1_home_screen.HomeActivity;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.ConnectionHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.WireHolder;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class SplashScreen2 extends Activity {

    //How long to wait before proceeding to the home activity
    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen2);

        //We don't want to see the action bar during the splash screen
        this.getActionBar().hide();

        //Get the TextView on which to display the SplashScreen
        TextView tv = (TextView) this.findViewById(R.id.splash_screen_text);

        //Set the text view to the HTML text specified
        tv.setText(Html.fromHtml("<html>" +
                "<font color=#FF0000>&nbsp;&nbsp;D</font>" + "<font color=#FFFFFF>ON&nbsp;</font>" + "<font color=#000000>'T</font>" +
                "<br>" +
                "<font color=#FF0000>FO</font>" + "<font color=#FFFFFF>RG</font>" + "<font color=#000000>ET</font>" +
                "<br>" +
                "<font color=#FF0000>&nbsp;&nbsp;&nbsp;T&nbsp;</font>" + "<font color=#FFFFFF>H&nbsp;&nbsp;</font>" + "<font color=#000000>E</font>" +
                "<br>" +
                "<font color=#FF0000>&nbsp;&nbsp;P&nbsp;</font>" + "<font color=#FFFFFF>W&nbsp;&nbsp;</font>" + "<font color=#000000>M</font>" +
                "<br>" +
                "</html>"));

        //Start HomeActivity.java after SPLASH_TIME_OUT amount of time
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen2.this, HomeActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

        //Read the saved data from the last time this app was opened
        SaveUtilities.readData(this);

    }
}
