package com.example.listview2;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private ArrayList<ListViewItem> mListViewItems = new ArrayList<ListViewItem>();
    private CustomListViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();
        buildListViewItems();

        ListView listView = (ListView) findViewById(R.id.lv_listview);
        mAdapter = new CustomListViewAdapter(mListViewItems);
        listView.setAdapter(mAdapter);

        Button btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListViewItems.add(new ListViewItem(getResource(R.drawable.sample8), "새로 추가된 Sample입니다."));
                mAdapter.notifyDataSetChanged();
            }
        });
    }


    private void buildListViewItems() {
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample1), "Sample1에 대한 설명입니다."));
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample2), "Sample2에 대한 설명입니다."));
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample3), "Sample3에 대한 설명입니다."));
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample4), "Sample4에 대한 설명입니다."));
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample5), "Sample5에 대한 설명입니다."));
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample6), "Sample6에 대한 설명입니다."));
        mListViewItems.add(new ListViewItem(getResource(R.drawable.sample7), "Sample7에 대한 설명입니다."));
    }

    private Drawable getResource(int resourceId) {
        Drawable dr = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dr = getDrawable(resourceId);
        } else {
            dr = getResources().getDrawable(resourceId);
        }

        return dr;
    }


}
