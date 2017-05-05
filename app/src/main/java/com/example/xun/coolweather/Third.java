package com.example.xun.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Third extends AppCompatActivity {
    private String[] countyWz={"温州","泰顺","文成","平阳","瑞安","洞头","乐清","永嘉","苍南"};
    private String[] countyHz={"杭州","萧山","桐庐","淳安","建德","余杭","临安","富阳"};
    String[] county={""};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String data=intent.getStringExtra("city");
        TextView textView= (TextView) findViewById(R.id.ptitle);
        textView.setText(data);
        if (data.equals("温州")){
            county=countyWz;
        }else if(data.equals("杭州")){
            county=countyHz;
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                Third.this,android.R.layout.simple_list_item_1,county);
        ListView listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
