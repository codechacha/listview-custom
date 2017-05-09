package com.example.listview2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {
    private ArrayList<SampleItem> mSampleItems;

    public CustomListViewAdapter(ArrayList<SampleItem> items) {
        mSampleItems = items;
    }

    @Override
    public int getCount() {
        return mSampleItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mSampleItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        ImageView ivImage = (ImageView) convertView.findViewById(R.id.iv_image);
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_content);
        Button btnDelete = (Button) convertView.findViewById(R.id.btn_delete);
        btnDelete.setTag(position);

        Drawable dr =  mSampleItems.get(position).getThumbnail();
        String content = mSampleItems.get(position).getTitle();
        ivImage.setImageDrawable(dr);
        tvContent.setText(content);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = getCount();

                if (count > 0) {
                    int selectedIndex = (int)v.getTag();
                    mSampleItems.remove(selectedIndex);
                    notifyDataSetChanged();
                }
            }
        });

        return convertView;
    }

    public void addItem(SampleItem item) {
        mSampleItems.add(item);
    }


}


