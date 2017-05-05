package com.example.xun.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    private String[] citybj={"海淀", "朝阳", "顺义", "怀柔", "通州", "昌平", "延庆", "丰台", "石景山", "大兴", "房山", "密云", "门头沟", "平谷"};
    private String[] cityzj={"杭州","湖州","嘉兴","宁波","绍兴","台州","温州","丽水","金华","衢州","舟山"};
    String[] city={""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String data=intent.getStringExtra("provice");
        TextView textView= (TextView) findViewById(R.id.ptitle);
        textView.setText(data);
        if (data.equals("北京")){
            city=citybj;
        }else if(data.equals("浙江")){
            city=cityzj;
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                Second.this,android.R.layout.simple_list_item_1,city);
        ListView listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Second.this, city[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Second.this, Third.class);
                intent.putExtra("city", city[position]);
                startActivity(intent);
            }

        });
    }
}