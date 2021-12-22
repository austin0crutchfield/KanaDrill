package com.example.austin.kanadrill;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // create kana arrays
    String[][] h0 = {{"あ","a"}, {"い","i"}, {"う","u"}, {"え","e"}, {"お","o"}};
    String[][] h1 = {{"か","ka"}, {"き","ki"}, {"く","ku"}, {"け","ke"}, {"こ","ko"}};
    String[][] h2 = {{"さ","sa"}, {"し","shi"}, {"す","su"}, {"せ","se"}, {"そ","so"}};
    String[][] h3 = {{"た","ta"}, {"ち","chi"}, {"つ","tsu"}, {"て","te"}, {"と","to"}};
    String[][] h4 = {{"な","na"}, {"に","ni"}, {"ぬ","nu"}, {"ね","ne"}, {"の","no"}};
    String[][] h5 = {{"は","ha"}, {"ひ","hi"}, {"ふ","fu"}, {"へ","he"}, {"ほ","ho"}};
    String[][] h6 = {{"ま","ma"}, {"み","mi"}, {"む","mu"}, {"め","me"}, {"も","mo"}};
    String[][] h7 = {{"や","ya"}, {"ゆ","yu"}, {"よ","yo"}};
    String[][] h8 = {{"ら","ra"}, {"り","ri"}, {"る","ru"}, {"れ","re"}, {"ろ","ro"}};
    String[][] h9 = {{"わ","wa"}, {"を","o"}};
    String[][] h10 = {{"ん","n"}};
    String[][] h11 = {{"が","ga"}, {"ぎ","gi"}, {"ぐ","gu"}, {"げ","ge"}, {"ご","go"}};
    String[][] h12 = {{"ざ","za"}, {"じ","ji"}, {"ず","zu"}, {"ぜ","ze"}, {"ぞ","zo"}};
    String[][] h13 = {{"だ","da"}, {"ぢ","ji"}, {"づ","zu"}, {"で","de"}, {"ど","do"}};
    String[][] h14 = {{"ば","ba"}, {"び","bi"}, {"ぶ","bu"}, {"べ","be"}, {"ぼ","bo"}};
    String[][] h15 = {{"ぱ","pa"}, {"ぴ","pi"}, {"ぷ","pu"}, {"ぺ","pe"}, {"ぽ","po"}};
    String[][] h16 = {{"きゃ","kya"}, {"きゅ","kyu"}, {"きょ","kyo"}};
    String[][] h17 = {{"しゃ","sha"}, {"しゅ","shu"}, {"しょ","sho"}};
    String[][] h18 = {{"ちゃ","cha"}, {"ちゅ","chu"}, {"ちょ","cho"}};
    String[][] h19 = {{"にゃ","nya"}, {"にゅ","nyu"}, {"にょ","nyo"}};
    String[][] h20 = {{"ひゃ","hya"}, {"ひゅ","hyu"}, {"ひょ","hyo"}};
    String[][] h21 = {{"みゃ","mya"}, {"みゅ","myu"}, {"みょ","myo"}};
    String[][] h22 = {{"りゃ","rya"}, {"りゅ","ryu"}, {"りょ","ryo"}};
    String[][] h23 = {{"ぎゃ","gya"}, {"ぎゅ","gyu"}, {"ぎょ","gyo"}};
    String[][] h24 = {{"じゃ","ja"}, {"じゅ","ju"}, {"じょ","jo"}};
    String[][] h25 = {{"ぢゃ","ja"}, {"ぢゅ","ju"}, {"ぢょ","jo"}};
    String[][] h26 = {{"びゃ","bya"}, {"びゅ","byu"}, {"びょ","byo"}};
    String[][] h27 = {{"ぴゃ","pya"}, {"ぴゅ","pyu"}, {"ぴょ","pyo"}};
    String[][] k0 = {{"ア","a"}, {"イ","i"}, {"ウ","u"}, {"エ","e"}, {"オ","o"}};
    String[][] k1 = {{"カ","ka"}, {"キ","ki"}, {"ク","ku"}, {"ケ","ke"}, {"コ","ko"}};
    String[][] k2 = {{"サ","sa"}, {"シ","shi"}, {"ス","su"}, {"セ","se"}, {"ソ","so"}};
    String[][] k3 = {{"タ","ta"}, {"チ","chi"}, {"ツ","tsu"}, {"テ","te"}, {"ト","to"}};
    String[][] k4 = {{"ナ","na"}, {"ニ","ni"}, {"ヌ","nu"}, {"ネ","ne"}, {"ノ","no"}};
    String[][] k5 = {{"ハ","ha"}, {"ヒ","hi"}, {"フ","fu"}, {"ヘ","he"}, {"ホ","ho"}};
    String[][] k6 = {{"マ","ma"}, {"ミ","mi"}, {"ム","mu"}, {"メ","me"}, {"モ","mo"}};
    String[][] k7 = {{"ヤ","ya"}, {"ユ","yu"}, {"ヨ","yo"}};
    String[][] k8 = {{"ラ","ra"}, {"リ","ri"}, {"ル","ru"}, {"レ","re"}, {"ロ","ro"}};
    String[][] k9 = {{"ワ","wa"}, {"ヲ","o"}};
    String[][] k10 = {{"ン","n"}};
    String[][] k11 = {{"ガ","ga"}, {"ギ","gi"}, {"グ","gu"}, {"ゲ","ge"}, {"ゴ","go"}};
    String[][] k12 = {{"ザ","za"}, {"ジ","ji"}, {"ズ","zu"}, {"ゼ","ze"}, {"ゾ","zo"}};
    String[][] k13 = {{"ダ","da"}, {"ヂ","ji"}, {"ヅ","zu"}, {"デ","de"}, {"ド","do"}};
    String[][] k14 = {{"バ","ba"}, {"ビ","bi"}, {"ブ","bu"}, {"ベ","be"}, {"ボ","bo"}};
    String[][] k15 = {{"パ","pa"}, {"ピ","pi"}, {"プ","pu"}, {"ペ","pe"}, {"ポ","po"}};
    String[][] k16 = {{"キャ","kya"}, {"キュ","kyu"}, {"キョ","kyo"}};
    String[][] k17 = {{"シャ","sha"}, {"シュ","shu"}, {"ショ","sho"}};
    String[][] k18 = {{"チャ","cha"}, {"チュ","chu"}, {"チョ","cho"}};
    String[][] k19 = {{"ニャ","nya"}, {"ニュ","nyu"}, {"ニョ","nyo"}};
    String[][] k20 = {{"ヒャ","hya"}, {"ヒュ","hyu"}, {"ヒョ","hyo"}};
    String[][] k21 = {{"ミャ","mya"}, {"ミュ","myu"}, {"ミョ","myo"}};
    String[][] k22 = {{"リャ","rya"}, {"リュ","ryu"}, {"リョ","ryo"}};
    String[][] k23 = {{"ギャ","gya"}, {"ギュ","gyu"}, {"ギョ","gyo"}};
    String[][] k24 = {{"ジャ","ja"}, {"ジュ","ju"}, {"ジョ","jo"}};
    String[][] k25 = {{"ヂャ","ja"}, {"ヂュ","ju"}, {"ヂョ","jo"}};
    String[][] k26 = {{"ビャ","bya"}, {"ビュ","byu"}, {"ビョ","byo"}};
    String[][] k27 = {{"ピャ","pya"}, {"ピュ","pyu"}, {"ピョ","pyo"}};

    SharedPreferences sharedPreferences;
    TextWatcher speedModeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(checkAnswer(syllableEditText.getText().toString(), curPair)) {
                curPair = generateNonDuplicatePair(selectedKana);
                displayKana(kanaTextView, hintTextView, curPair);
                shownTextView.setText(getString(R.string.total_shown, ++numShown));
                rightTextView.setText(getString(R.string.total_right, ++numRight));
                hintTextView.setVisibility(View.INVISIBLE);
                syllableEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    ArrayList<String[][]> availableKana = new ArrayList<>();
    ArrayList<String[][]> selectedKana = new ArrayList<>();
    String[] curPair;
    String[] prevPair = {"",""};
    TextView kanaTextView;
    EditText syllableEditText;
    TextView shownTextView;
    TextView rightTextView;
    TextView hintTextView;
    Random rand = new Random(System.currentTimeMillis());
    ArrayList<Typeface> selectedFonts = new ArrayList<>();
    Typeface defaultFont;
    Typeface soukouMincho;
    Typeface aozoraMincho;
    Typeface nukamiso;
    int numRight = 0;
    int numShown = 0;
    boolean alreadyPressedEnter = false;
    final int NUM_OF_HIRAGANA = 28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar("Kana Drill");
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            imm.showSoftInput(syllableEditText, InputMethodManager.SHOW_IMPLICIT);
        }
        sharedPreferences = this.getSharedPreferences("com.example.austin.kanadrill.sharedpreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("mustReload", false).apply();

        if(sharedPreferences.getBoolean("firstTime", true)) {
            sharedPreferences.edit().putBoolean("h0", true).apply();
            sharedPreferences.edit().putBoolean("firstTime", false).apply();
        }

        loadAvailableKana(availableKana);
        loadSelectedKana(selectedKana, availableKana);

        // init views
        kanaTextView = findViewById(R.id.kanaTextView);
        syllableEditText = findViewById(R.id.syllableEditText);
        shownTextView = findViewById(R.id.shownTextView);
        rightTextView = findViewById(R.id.rightTextView);
        hintTextView = findViewById(R.id.hintTextView);

        // init fonts
        defaultFont = Typeface.DEFAULT;
        soukouMincho = Typeface.createFromAsset(getAssets(), "fonts/soukoumincho-regular.otf");
        aozoraMincho = Typeface.createFromAsset(getAssets(), "fonts/aozoramincho-regular.otf");
        nukamiso = Typeface.createFromAsset(getAssets(), "fonts/nukamiso-regular.otf");
        loadSelectedFonts(selectedFonts);
        kanaTextView.setTextSize(60f);

        // adjust layout for screen size
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        // adjust if height < 900
        if(height < 900) {
            float d = getApplicationContext().getResources().getDisplayMetrics().density;
            ViewGroup.MarginLayoutParams shownTextViewMarginParams = (ViewGroup.MarginLayoutParams) shownTextView.getLayoutParams();
            shownTextViewMarginParams.setMargins(0, 0, 0, 0);
            ViewGroup.MarginLayoutParams rightTextViewMarginParams = (ViewGroup.MarginLayoutParams) rightTextView.getLayoutParams();
            rightTextViewMarginParams.setMargins(0, 0, 0, 0);
            ViewGroup.MarginLayoutParams syllableEditTextMarginParams = (ViewGroup.MarginLayoutParams) syllableEditText.getLayoutParams();
            syllableEditTextMarginParams.setMargins((int) (25 * d), 0, (int) (25 * d), 0);
        }


        // edittext listener
        syllableEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if((keyEvent != null && (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) && getResources().getConfiguration().keyboard == 0) ||
                   (i == EditorInfo.IME_ACTION_DONE)) {

                    if(!sharedPreferences.getBoolean("speedMode", false)) {

                        // if answer is correct
                        if (checkAnswer(syllableEditText.getText().toString(), curPair) && !alreadyPressedEnter) {
                            curPair = generateNonDuplicatePair(selectedKana);
                            displayKana(kanaTextView, hintTextView, curPair);
                            syllableEditText.setText("");
                            shownTextView.setText(getString(R.string.total_shown, ++numShown));
                            rightTextView.setText(getString(R.string.total_right, ++numRight));
                            hintTextView.setVisibility(View.INVISIBLE);
                            alreadyPressedEnter = false;

                        } else if (alreadyPressedEnter) {
                            curPair = generateNonDuplicatePair(selectedKana);
                            displayKana(kanaTextView, hintTextView, curPair);
                            syllableEditText.setText("");
                            shownTextView.setText(getString(R.string.total_shown, ++numShown));
                            hintTextView.setVisibility(View.INVISIBLE);
                            alreadyPressedEnter = false;

                        } else {
                            hintTextView.setVisibility(View.VISIBLE);
                            alreadyPressedEnter = true;
                        }
                    }
                    return true;
                }
                return false;
            }
        });

        // edittext speed mode listener
        syllableEditText.removeTextChangedListener(speedModeTextWatcher);
        if(sharedPreferences.getBoolean("speedMode", false)) {
            syllableEditText.addTextChangedListener(speedModeTextWatcher);
        }

        curPair = generateNonDuplicatePair(selectedKana);
        displayKana(kanaTextView, hintTextView, curPair);
    }

    public String[] generateNonDuplicatePair(ArrayList selectedKana) {
        String[] tempPair;

        // if no kana are selected
        if(selectedKana.isEmpty()) {
            return new String[] {"あ","a"};
        }

        // if there's only one kana
        String[][] tempArr = (String[][]) selectedKana.get(0);
        if(selectedKana.size() == 1 && tempArr[0][0].equals("ん") ||
           selectedKana.size() == 1 && tempArr[0][0].equals("ン")) {
            tempPair = generatePair(selectedKana);
            return tempPair;
        }

        // generate until not the same as last pair
        do {
            tempPair = generatePair(selectedKana);
        } while(tempPair[0].equals(prevPair[0]));
        prevPair[0] = tempPair[0];
        prevPair[1] = tempPair[1];
        return tempPair;
    }

    public String[] generatePair(ArrayList selectedKana) {
        int randomSet = rand.nextInt(selectedKana.size());
        String[][] kanaSet = (String[][]) selectedKana.get(randomSet);
        int randomKana = rand.nextInt(kanaSet.length);
        return new String[] {kanaSet[randomKana][0], kanaSet[randomKana][1]};
    }

    public void displayKana(TextView kanaTextView, TextView hintTextView, String[] curPair) {
        kanaTextView.setText(curPair[0]);
        hintTextView.setText(curPair[1]);
        loadSelectedFonts(selectedFonts);
        setKanaFont(selectedFonts);
        syllableEditText.setText("");
    }

    public boolean checkAnswer(String answer, String[] curPair) {
        boolean isSpecialCase = false;
        if(!answer.equals(curPair[1])) {
            if((curPair[0].equals("を") && answer.equals("wo")) ||
               (curPair[0].equals("ふ") && answer.equals("hu")) ||
               (curPair[0].equals("ヲ") && answer.equals("wo")) ||
               (curPair[0].equals("フ") && answer.equals("hu"))) {
                isSpecialCase = true;
            }
        }
        return answer.equals(curPair[1]) || isSpecialCase;
    }

    public void loadSelectedKana(ArrayList<String[][]> selectedKana, ArrayList<String[][]> availableKana) {
        selectedKana.clear();
        for(int i = 0; i < availableKana.size(); i++) {
            if(sharedPreferences.getBoolean("h"+i, false) ||
               sharedPreferences.getBoolean("k"+(i-NUM_OF_HIRAGANA), false))
                selectedKana.add(availableKana.get(i));
        }
    }

    public void loadAvailableKana(ArrayList<String[][]> availableKana) {
        availableKana.add(h0);
        availableKana.add(h1);
        availableKana.add(h2);
        availableKana.add(h3);
        availableKana.add(h4);
        availableKana.add(h5);
        availableKana.add(h6);
        availableKana.add(h7);
        availableKana.add(h8);
        availableKana.add(h9);
        availableKana.add(h10);
        availableKana.add(h11);
        availableKana.add(h12);
        availableKana.add(h13);
        availableKana.add(h14);
        availableKana.add(h15);
        availableKana.add(h16);
        availableKana.add(h17);
        availableKana.add(h18);
        availableKana.add(h19);
        availableKana.add(h20);
        availableKana.add(h21);
        availableKana.add(h22);
        availableKana.add(h23);
        availableKana.add(h24);
        availableKana.add(h25);
        availableKana.add(h26);
        availableKana.add(h27);
        availableKana.add(k0);
        availableKana.add(k1);
        availableKana.add(k2);
        availableKana.add(k3);
        availableKana.add(k4);
        availableKana.add(k5);
        availableKana.add(k6);
        availableKana.add(k7);
        availableKana.add(k8);
        availableKana.add(k9);
        availableKana.add(k10);
        availableKana.add(k11);
        availableKana.add(k12);
        availableKana.add(k13);
        availableKana.add(k14);
        availableKana.add(k15);
        availableKana.add(k16);
        availableKana.add(k17);
        availableKana.add(k18);
        availableKana.add(k19);
        availableKana.add(k20);
        availableKana.add(k21);
        availableKana.add(k22);
        availableKana.add(k23);
        availableKana.add(k24);
        availableKana.add(k25);
        availableKana.add(k26);
        availableKana.add(k27);
    }

    public void loadSelectedFonts(ArrayList<Typeface> selectedFonts) {
        selectedFonts.clear();
        if(sharedPreferences.getBoolean("f0", false)) selectedFonts.add(defaultFont);
        if(sharedPreferences.getBoolean("f1", false)) selectedFonts.add(soukouMincho);
        if(sharedPreferences.getBoolean("f2", false)) selectedFonts.add(aozoraMincho);
        if(sharedPreferences.getBoolean("f3", false)) selectedFonts.add(nukamiso);
    }

    // This is terrible, fix this font system sometime
    public void setKanaFont(ArrayList<Typeface> selectedFonts) {
        int randNum;
        if(selectedFonts.size() > 0) {
            randNum = rand.nextInt(selectedFonts.size());
            kanaTextView.setTypeface(selectedFonts.get(randNum));
        } else {
            kanaTextView.setTypeface(defaultFont);
        }
    }

    public void openSettings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(sharedPreferences.getBoolean("mustReload", true)) {
            loadSelectedKana(selectedKana, availableKana);
            //Toast.makeText(this, "Kana Reloaded", Toast.LENGTH_SHORT).show();
            curPair = generateNonDuplicatePair(selectedKana);
            displayKana(kanaTextView, hintTextView, curPair);
            numRight = 0;
            numShown = 0;
            rightTextView.setText(getString(R.string.total_right, numRight));
            shownTextView.setText(getString(R.string.total_shown, numShown));
            hintTextView.setVisibility(View.INVISIBLE);
            alreadyPressedEnter = false;
            syllableEditText.setText("");
            syllableEditText.removeTextChangedListener(speedModeTextWatcher);
            if(sharedPreferences.getBoolean("speedMode", false)) {
                syllableEditText.addTextChangedListener(speedModeTextWatcher);
            }
        }
        sharedPreferences.edit().putBoolean("mustReload", false).apply();
    }

    public void setActionBar(String heading) {
        if(getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(heading);
            actionBar.show();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER) {

            if(!sharedPreferences.getBoolean("speedMode", false)) {
                // if answer is correct
                if (checkAnswer(syllableEditText.getText().toString(), curPair) && !alreadyPressedEnter) {
                    curPair = generateNonDuplicatePair(selectedKana);
                    displayKana(kanaTextView, hintTextView, curPair);
                    syllableEditText.setText("");
                    shownTextView.setText(getString(R.string.total_shown, ++numShown));
                    rightTextView.setText(getString(R.string.total_right, ++numRight));
                    hintTextView.setVisibility(View.INVISIBLE);
                    alreadyPressedEnter = false;

                } else if (alreadyPressedEnter) {
                    curPair = generateNonDuplicatePair(selectedKana);
                    displayKana(kanaTextView, hintTextView, curPair);
                    syllableEditText.setText("");
                    shownTextView.setText(getString(R.string.total_shown, ++numShown));
                    hintTextView.setVisibility(View.INVISIBLE);
                    alreadyPressedEnter = false;

                } else {
                    hintTextView.setVisibility(View.VISIBLE);
                    alreadyPressedEnter = true;
                }
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
