package com.gudongguangfo.listviewdiffitems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview = (ListView) findViewById(R.id.lv);
        String[] contectName = {"张三", "李四", "王五", "啊啊"};
        int[] photoid= {R.drawable.bee,R.drawable.cat,R.drawable.pig,R.drawable.woniu};
        //创建需要的adapter
        ManyItemTypesAdapter adapter = new ManyItemTypesAdapter(this,contectName,photoid);
        mListview.setAdapter(adapter);

    }
}
