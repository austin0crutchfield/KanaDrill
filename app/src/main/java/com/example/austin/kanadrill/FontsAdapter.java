package com.example.austin.kanadrill;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FontsAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private int mResource;
    private ArrayList<String> mLabelsArrayList;
    private Typeface soukouMincho;
    private Typeface japanSans;
    private Typeface shigotoMemogaki;
    private Typeface defaultFont;
    private Typeface aozoraMincho;
    private Typeface nukamiso;

    public FontsAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        mLabelsArrayList = objects;
        defaultFont = Typeface.DEFAULT;
        soukouMincho = Typeface.createFromAsset(mContext.getAssets(), "fonts/soukoumincho-regular.otf");
        aozoraMincho = Typeface.createFromAsset(mContext.getAssets(), "fonts/aozoramincho-regular.otf");
        nukamiso = Typeface.createFromAsset(mContext.getAssets(), "fonts/nukamiso-regular.otf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater mInflator = LayoutInflater.from(mContext);
            String label = mLabelsArrayList.get(position);
            convertView = mInflator.inflate(mResource, parent, false);

            TextView labelTextView = (TextView) convertView.findViewById(android.R.id.text1);

            switch (position) {
                case 2:
                    labelTextView.setTypeface(defaultFont);
                    break;
                case 3:
                    labelTextView.setTypeface(soukouMincho);
                    break;
                case 4:
                    labelTextView.setTypeface(aozoraMincho);
                    break;
                case 5:
                    labelTextView.setTypeface(nukamiso);
            }

            labelTextView.setText(label);
        }

        return convertView;

    }
}
