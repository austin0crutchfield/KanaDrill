package com.example.austin.kanadrill;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    ListView settingsListView;
    SettingsAdapter settingsAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setActionBar("Settings");
        sharedPreferences = this.getSharedPreferences("com.example.austin.kanadrill.sharedpreferences", Context.MODE_PRIVATE);


        settingsListView = findViewById(R.id.settingsListView);
        settingsAdapter = new SettingsAdapter(this);
        settingsAdapter.addItem("Hiragana");
        settingsAdapter.addItem("Katakana");
        settingsAdapter.addItem("Fonts");
        settingsAdapter.addCheckBoxItem("Speed Mode");
        settingsListView.setAdapter(settingsAdapter);
        settingsListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        settingsListView.setItemChecked(3, sharedPreferences.getBoolean("speedMode", false));

        settingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position) {
                    case 0:
                        openHiragana();
                        break;
                    case 1:
                        openKatakana();
                        break;
                    case 2:
                        openFonts();
                        break;
                    case 3:
                        sharedPreferences.edit().putBoolean("speedMode", !sharedPreferences.getBoolean("speedMode", false)).apply();
                        sharedPreferences.edit().putBoolean("mustReload", true).apply();
                        //Toast.makeText(SettingsActivity.this, "speed: "+sharedPreferences.getBoolean("speedMode", false), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        });

    }


    public void openMainActivity(View v) {
        finish();
    }

    public void openHiragana() {
        Intent intent = new Intent(this, HiraganaActivity.class);
        startActivity(intent);
    }

    public void openKatakana() {
        Intent intent = new Intent(this, KatakanaActivity.class);
        startActivity(intent);
    }

    public void openFonts() {
        Intent intent = new Intent(this, FontsActivity.class);
        startActivity(intent);
    }

    public void setActionBar(String heading) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(heading);
        actionBar.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
