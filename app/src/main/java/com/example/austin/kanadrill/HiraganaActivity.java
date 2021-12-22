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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HiraganaActivity extends AppCompatActivity {
    ListView hiraganaListView;
    ArrayAdapter<String> hiraganaArrayAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana);
        setActionBar("Hiragana");
        sharedPreferences = this.getSharedPreferences("com.example.austin.kanadrill.sharedpreferences", Context.MODE_PRIVATE);

        hiraganaListView = findViewById(R.id.hiraganaListView);

        ArrayList<String> hiraganaArrayList = new ArrayList<>();
        hiraganaArrayList.add("Select all");
        hiraganaArrayList.add("Deselect all");
        hiraganaArrayList.add("あ　い　う　え　お");
        hiraganaArrayList.add("か　き　く　け　こ");
        hiraganaArrayList.add("さ　し　す　せ　そ");
        hiraganaArrayList.add("た　ち　つ　て　と");
        hiraganaArrayList.add("な　に　ぬ　ね　の");
        hiraganaArrayList.add("は　ひ　ふ　へ　ほ");
        hiraganaArrayList.add("ま　み　む　め　も");
        hiraganaArrayList.add("や　ゆ　よ");
        hiraganaArrayList.add("ら　り　る　れ　ろ");
        hiraganaArrayList.add("わ　を");
        hiraganaArrayList.add("ん");
        hiraganaArrayList.add("が　ぎ　ぐ　げ　ご");
        hiraganaArrayList.add("ざ　じ　ず　ぜ　ぞ");
        hiraganaArrayList.add("だ　ぢ　づ　で　ど");
        hiraganaArrayList.add("ば　び　ぶ　べ　ぼ");
        hiraganaArrayList.add("ぱ　ぴ　ぷ　ぺ　ぽ");
        hiraganaArrayList.add("きゃ　きゅ　きょ");
        hiraganaArrayList.add("しゃ　しゅ　しょ");
        hiraganaArrayList.add("ちゃ　ちゅ　ちょ");
        hiraganaArrayList.add("にゃ　にゅ　にょ");
        hiraganaArrayList.add("ひゃ　ひゅ　ひょ");
        hiraganaArrayList.add("みゃ　みゅ　みょ");
        hiraganaArrayList.add("りゃ　りゅ　りょ");
        hiraganaArrayList.add("ぎゃ　ぎゅ　ぎょ");
        hiraganaArrayList.add("じゃ　じゅ　じょ");
        hiraganaArrayList.add("ぢゃ　ぢゅ　ぢょ");
        hiraganaArrayList.add("びゃ　びゅ　びょ");
        hiraganaArrayList.add("ぴゃ　ぴゅ　ぴょ");

        hiraganaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, hiraganaArrayList);
        hiraganaListView.setAdapter(hiraganaArrayAdapter);
        hiraganaListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        hiraganaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        // select all
                        hiraganaListView.setItemChecked(position, true);
                        for(int i = 2; i < hiraganaArrayAdapter.getCount(); i++) {
                            hiraganaListView.setItemChecked(i, true);
                            sharedPreferences.edit().putBoolean("h" + (position+i-2), true).apply();
                        }
                        break;

                    case 1:
                        // deselect all
                        for(int i = 0; i < hiraganaArrayAdapter.getCount(); i++) {
                            hiraganaListView.setItemChecked(i, false);
                            sharedPreferences.edit().putBoolean("h" + i, false).apply();
                        }
                        break;
                    default:
                        // if false, save as true
                        if(!sharedPreferences.getBoolean("h"+(position-2), false)) {
                            sharedPreferences.edit().putBoolean("h" + (position - 2), true).apply();
                            //Toast.makeText(HiraganaActivity.this, "h"+(position-2)+": "+sharedPreferences.getBoolean("h" + (position - 2), true), Toast.LENGTH_SHORT).show();
                        } else {
                            sharedPreferences.edit().putBoolean("h" + (position-2), false).apply();
                            //Toast.makeText(HiraganaActivity.this, "h"+(position-2)+": "+sharedPreferences.getBoolean("h" + (position - 2), false), Toast.LENGTH_SHORT).show();
                        }
                        // check if all are selected and check/uncheck select all
                        boolean allSelected = true;
                        for(int i = 2; i < hiraganaArrayAdapter.getCount(); i++) {
                            if(!sharedPreferences.getBoolean("h" + (i-2), false)) {
                                allSelected = false;
                            }
                        }
                        hiraganaListView.setItemChecked(0, allSelected);
                        break;
                }
                sharedPreferences.edit().putBoolean("mustReload", true).apply();
            }

        });
        // load checkboxes
        for(int i = 2; i < hiraganaArrayAdapter.getCount(); i++) {
            if(sharedPreferences.getBoolean("h"+(i-2), false)) {
                hiraganaListView.setItemChecked(i, true);
            }
        }
        if(hiraganaListView.getCheckedItemCount() == hiraganaArrayAdapter.getCount()-2) {
            hiraganaListView.setItemChecked(0, true);
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
