package com.madhujgowda.www.themecolorapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTheme();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void changeTheme()
    {
        SharedPreferences themePreferences = getApplicationContext().getSharedPreferences("theme_pref",MODE_PRIVATE);
        String theme = themePreferences.getString("theme","");
        switch (theme)
        {
            case "1":
                setTheme(R.style.AppTheme1);
                break;
            case "2":
                setTheme(R.style.AppTheme2);
                break;
            case "3":
                setTheme(R.style.AppTheme3);
                break;
            case "4":
                setTheme(R.style.AppTheme4);
                break;
            case "5":
                setTheme(R.style.AppTheme5);
                break;
            case "6":
                setTheme(R.style.AppTheme6);
                break;
            case "7":
                setTheme(R.style.AppTheme7);
                break;
            case "8":
                setTheme(R.style.AppTheme8);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
