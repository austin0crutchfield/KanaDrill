package com.example.austin.kanadrill;

import android.content.Context;
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
import java.util.ArrayList;

public class FontsActivity extends AppCompatActivity {

    ListView fontsListView;
    FontsAdapter fontsArrayAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fonts);
        setActionBar("Fonts");
        sharedPreferences = this.getSharedPreferences("com.example.austin.kanadrill.sharedpreferences", Context.MODE_PRIVATE);

        fontsListView = findViewById(R.id.fontsListView);
        ArrayList<String> fontsArrayList = new ArrayList<>();
        fontsArrayList.add("Select all");
        fontsArrayList.add("Deselect all");
        fontsArrayList.add("あ　い　う　え　お");
        fontsArrayList.add("あ　い　う　え　お");
        fontsArrayList.add("あ　い　う　え　お");
        fontsArrayList.add("あ　い　う　え　お");
        fontsArrayAdapter = new FontsAdapter(this, android.R.layout.simple_list_item_multiple_choice, fontsArrayList);
        fontsListView.setAdapter(fontsArrayAdapter);
        fontsListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        fontsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        // select all
                        fontsListView.setItemChecked(position, true);
                        for(int i = 2; i < fontsArrayAdapter.getCount(); i++) {
                            fontsListView.setItemChecked(i, true);
                            sharedPreferences.edit().putBoolean("f" + (position+i-2), true).apply();
                        }
                        break;

                    case 1:
                        // deselect all
                        for(int i = 0; i < fontsArrayAdapter.getCount(); i++) {
                            fontsListView.setItemChecked(i, false);
                            sharedPreferences.edit().putBoolean("f" + i, false).apply();
                        }
                        break;
                    default:
                        // if false, save as true
                        if(!sharedPreferences.getBoolean("f"+(position-2), false)) {
                            sharedPreferences.edit().putBoolean("f" + (position - 2), true).apply();
                            //Toast.makeText(FontsActivity.this, "f"+(position-2)+": "+sharedPreferences.getBoolean("f" + (position - 2), true), Toast.LENGTH_SHORT).show();
                        } else {
                            sharedPreferences.edit().putBoolean("f" + (position-2), false).apply();
                            //Toast.makeText(FontsActivity.this, "f"+(position-2)+": "+sharedPreferences.getBoolean("f" + (position - 2), false), Toast.LENGTH_SHORT).show();
                        }
                        // check if all are selected and check/uncheck select all
                        boolean allSelected = true;
                        for(int i = 2; i < fontsArrayAdapter.getCount(); i++) {
                            if(!sharedPreferences.getBoolean("f" + (i-2), false)) {
                                allSelected = false;
                            }
                        }
                        fontsListView.setItemChecked(0, allSelected);
                        break;
                }
                sharedPreferences.edit().putBoolean("mustReload", true).apply();
            }

        });
        // load checkboxes
        for(int i = 2; i < fontsArrayAdapter.getCount(); i++) {
            if(sharedPreferences.getBoolean("f"+(i-2), false)) {
                fontsListView.setItemChecked(i, true);
            }

        }
        if(fontsListView.getCheckedItemCount() == fontsArrayAdapter.getCount()-2) {
            fontsListView.setItemChecked(0, true);
        }

    }

    public void setActionBar(String heading) {
        if(getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(heading);
            actionBar.show();
        }
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
