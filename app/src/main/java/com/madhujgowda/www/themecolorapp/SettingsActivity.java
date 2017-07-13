package com.madhujgowda.www.themecolorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTheme();
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onStart() {
        //Change the theme text in settings layout
        SharedPreferences themePreferences = getApplicationContext().getSharedPreferences("theme_pref",MODE_PRIVATE);

        String theme_name = themePreferences.getString("theme_name","");
        TextView themeTextView = (TextView)findViewById(R.id.settings_theme_sub);
        themeTextView.setText(theme_name);
        super.onStart();
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

    public void settingsOption(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.settings_theme:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Theme Color");
                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView= inflater.inflate(R.layout.theme_dialog, null);
                builder.setView(dialogView);
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create();
                builder.show();
                break;
        }
    }

    public void changeThemeColor(View view)
    {
        SharedPreferences themePreferences = getApplicationContext().getSharedPreferences("theme_pref",MODE_PRIVATE);
        int id = view.getId();
        switch(id)
        {
            case R.id.theme1:
                themePreferences.edit().putString("theme","1").apply();
                themePreferences.edit().putString("theme_name","Blue").apply();
                restartApplication();
                break;
            case R.id.theme2:
                themePreferences.edit().putString("theme","2").apply();
                themePreferences.edit().putString("theme_name","Violet").apply();
                restartApplication();
                break;
            case R.id.theme3:
                themePreferences.edit().putString("theme","3").apply();
                themePreferences.edit().putString("theme_name","Red").apply();
                restartApplication();
                break;
            case R.id.theme4:
                themePreferences.edit().putString("theme","4").apply();
                themePreferences.edit().putString("theme_name","Cement").apply();
                restartApplication();
                break;
            case R.id.theme5:
                themePreferences.edit().putString("theme","5").apply();
                themePreferences.edit().putString("theme_name","Black").apply();
                restartApplication();
                break;
            case R.id.theme6:
                themePreferences.edit().putString("theme","6").apply();
                themePreferences.edit().putString("theme_name","Cyan").apply();
                restartApplication();
                break;
            case R.id.theme7:
                themePreferences.edit().putString("theme","7").apply();
                themePreferences.edit().putString("theme_name","Green").apply();
                restartApplication();
                break;
            case R.id.theme8:
                themePreferences.edit().putString("theme","8").apply();
                themePreferences.edit().putString("theme_name","Gold").apply();
                restartApplication();
                break;
        }
    }

    public void restartApplication()
    {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

        Intent settingsIntent = new Intent(this,SettingsActivity.class);
        settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(settingsIntent);
    }
}
