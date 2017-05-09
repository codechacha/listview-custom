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
    private ArrayList<SampleItem> mSampleItems = new ArrayList<SampleItem>();
    private CustomListViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildListViewItems();

        ListView listView = (ListView) findViewById(R.id.lv_listview);
        mAdapter = new CustomListViewAdapter(mSampleItems);
        listView.setAdapter(mAdapter);

        Button btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSampleItems.add(new SampleItem("새로 추가된 Sample입니다.", getResource(R.drawable.sample8)));
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void buildListViewItems() {
        mSampleItems.add(new SampleItem("Sample1 입니다.", getResource(R.drawable.sample1)));
        mSampleItems.add(new SampleItem("Sample2 입니다.", getResource(R.drawable.sample2)));
        mSampleItems.add(new SampleItem("Sample3 입니다.", getResource(R.drawable.sample3)));
        mSampleItems.add(new SampleItem("Sample4 입니다.", getResource(R.drawable.sample4)));
        mSampleItems.add(new SampleItem("Sample5 입니다.", getResource(R.drawable.sample5)));
        mSampleItems.add(new SampleItem("Sample6 입니다.", getResource(R.drawable.sample6)));
        mSampleItems.add(new SampleItem("Sample7 입니다.", getResource(R.drawable.sample7)));
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
