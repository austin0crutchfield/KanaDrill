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

public class KatakanaActivity extends AppCompatActivity {
    ListView katakanaListView;
    ArrayAdapter<String> katakanaArrayAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana);
        setActionBar("Katakana");
        sharedPreferences = this.getSharedPreferences("com.example.austin.kanadrill.sharedpreferences", Context.MODE_PRIVATE);

        katakanaListView = findViewById(R.id.katakanaListView);

        ArrayList<String> katakanaArrayList = new ArrayList<>();
        katakanaArrayList.add("Select all");
        katakanaArrayList.add("Deselect all");
        katakanaArrayList.add("ア　イ　ウ　エ　オ");
        katakanaArrayList.add("カ　キ　ク　ケ　コ");
        katakanaArrayList.add("サ　シ　ス　セ　ソ");
        katakanaArrayList.add("タ　チ　ツ　テ　ト");
        katakanaArrayList.add("ナ　ニ　ヌ　ネ　ノ");
        katakanaArrayList.add("ハ　ヒ　フ　ヘ　ホ");
        katakanaArrayList.add("マ　ミ　ム　メ　モ");
        katakanaArrayList.add("ヤ　ユ　ヨ");
        katakanaArrayList.add("ラ　リ　ル　レ　ロ");
        katakanaArrayList.add("ワ　ヲ");
        katakanaArrayList.add("ン");
        katakanaArrayList.add("ガ　ギ　グ　ゲ　ゴ");
        katakanaArrayList.add("ザ　ジ　ズ　ゼ　ゾ");
        katakanaArrayList.add("ダ　ヂ　ヅ　デ　ド");
        katakanaArrayList.add("バ　ビ　ブ　ベ　ボ");
        katakanaArrayList.add("パ　ピ　プ　ペ　ポ");
        katakanaArrayList.add("キャ　キュ　キョ");
        katakanaArrayList.add("シャ　シュ　ショ");
        katakanaArrayList.add("チャ　チュ　チョ");
        katakanaArrayList.add("ニャ　ニュ　ニョ");
        katakanaArrayList.add("ヒャ　ヒュ　ヒョ");
        katakanaArrayList.add("ミャ　ミュ　ミョ");
        katakanaArrayList.add("リャ　リュ　リョ");
        katakanaArrayList.add("ギャ　ギュ　ギョ");
        katakanaArrayList.add("ジャ　ジュ　ジョ");
        katakanaArrayList.add("ヂャ　ヂュ　ヂョ");
        katakanaArrayList.add("ビャ　ビュ　ビョ");
        katakanaArrayList.add("ピャ　ピュ　ピョ");

        katakanaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, katakanaArrayList);
        katakanaListView.setAdapter(katakanaArrayAdapter);
        katakanaListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        katakanaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        // select all
                        katakanaListView.setItemChecked(position, true);
                        for(int i = 2; i < katakanaArrayAdapter.getCount(); i++) {
                            katakanaListView.setItemChecked(i, true);
                            sharedPreferences.edit().putBoolean("k" + (position+i-2), true).apply();
                        }
                        break;

                    case 1:
                        // deselect all
                        for(int i = 0; i < katakanaArrayAdapter.getCount(); i++) {
                            katakanaListView.setItemChecked(i, false);
                            sharedPreferences.edit().putBoolean("k" + i, false).apply();
                        }
                        break;
                    default:
                        // if false, save as true
                        if(!sharedPreferences.getBoolean("k"+(position-2), false)) {
                            sharedPreferences.edit().putBoolean("k" + (position - 2), true).apply();
                            //Toast.makeText(KatakanaActivity.this, "k"+(position-2)+": "+sharedPreferences.getBoolean("k" + (position - 2), true), Toast.LENGTH_SHORT).show();
                        // otherwise save as false
                        } else {
                            sharedPreferences.edit().putBoolean("k" + (position-2), false).apply();
                            //Toast.makeText(KatakanaActivity.this, "k"+(position-2)+": "+sharedPreferences.getBoolean("k" + (position - 2), false), Toast.LENGTH_SHORT).show();
                        }
                        // check if all are selected and check/uncheck select all
                        boolean allSelected = true;
                        for(int i = 2; i < katakanaArrayAdapter.getCount(); i++) {
                            if(!sharedPreferences.getBoolean("k" + (i-2), false)) {
                                allSelected = false;
                            }
                        }
                        katakanaListView.setItemChecked(0, allSelected);
                        break;
                }
                sharedPreferences.edit().putBoolean("mustReload", true).apply();
            }

        });
        // load checkboxes
        for(int i = 2; i < katakanaArrayAdapter.getCount(); i++) {
            if(sharedPreferences.getBoolean("k"+(i-2), false)) {
                katakanaListView.setItemChecked(i, true);
            }
        }
        if(katakanaListView.getCheckedItemCount() == katakanaArrayAdapter.getCount()-2) {
            katakanaListView.setItemChecked(0, true);
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
