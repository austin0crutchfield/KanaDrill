package com.example.austin.kanadrill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;

public class SettingsAdapter extends BaseAdapter {

    final int TYPE_ITEM = 0;
    final int TYPE_CHECKBOX_ITEM = 1;
    final int TYPE_MAX_COUNT = 2;
    Context ctx;

    ArrayList mData = new ArrayList();
    LayoutInflater mInflator;
    TreeSet mCheckBoxSet = new TreeSet();

    public SettingsAdapter(Context context) {
        ctx = context;
        mInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addCheckBoxItem(final String item) {
        mData.add(item);
        mCheckBoxSet.add(mData.size()-1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mCheckBoxSet.contains(position) ? TYPE_CHECKBOX_ITEM : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return (String) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);

        if(convertView == null) {
            holder = new ViewHolder();
            switch(type) {
                case TYPE_ITEM:
                    convertView = mInflator.inflate(android.R.layout.simple_list_item_1, null);
                    holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
                    break;
                case TYPE_CHECKBOX_ITEM:
                    convertView = mInflator.inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
                    holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText((String)mData.get(position));
        return convertView;

    }

    private static class ViewHolder {
        public TextView textView;
    }

}
