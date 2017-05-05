package com.example.xun.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] data={"北京","上海","辽宁","天津","重庆","浙江","香港","澳门","台湾","黑龙江","吉林","内蒙古","河北",
                            "河北","山西","山东","江苏","福建","江西","安徽","湖北","湖南","广东","广西","海南","贵州"};
//    private List<Provice> proviceList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
//        initProvice();
//        ProviceAdapter adapter = new ProviceAdapter(MainActivity.this, R.layout.provice_item,proviceList);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Provice provice=proviceList.get(position);
                Toast.makeText(MainActivity.this,data[position],Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Second.class);
                intent.putExtra("provice",data[position]);
                startActivity(intent);
            }
        });
    }
//    private void initProvice(){
//        for (int i=0;i<4;i++){
//            Provice zj=new Provice("浙江");
//            proviceList.add(zj);
//            Provice bj=new Provice("北京");
//            proviceList.add(bj);
//            Provice gd=new Provice("广东");
//            proviceList.add(gd);
//            Provice js=new Provice("江苏");
//            proviceList.add(js);
//            Provice fj=new Provice("福建");
//            proviceList.add(fj);
//
//        }
//
//    }
}
