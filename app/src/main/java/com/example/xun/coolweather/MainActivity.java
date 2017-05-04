package com.example.xun.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] data={"北京","上海","辽宁","天津","重庆","浙江","香港","澳门","台湾","黑龙江","吉林","内蒙古","河北",
                            "河北","山西","山东","江苏","福建","江西","安徽","湖北","湖南","广东","广西","海南","贵州"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
