package com.example.xun.coolweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> provinces = Arrays.asList(new String []{"北京","上海","辽宁","天津","重庆","浙江","香港","澳门","台湾","黑龙江","吉林","内蒙古","河北",
            "河北","山西","山东","江苏","福建","江西","安徽","湖北","湖南","广东","广西","海南","贵州"});
    private List<String> cityBj=Arrays.asList(new String[]{"海淀", "朝阳", "顺义", "怀柔", "通州", "昌平", "延庆", "丰台", "石景山", "大兴", "房山", "密云", "门头沟", "平谷"});
    private List<String> cityZj=Arrays.asList(new String[]{"杭州","湖州","嘉兴","宁波","绍兴","台州","温州","丽水","金华","衢州","舟山"});
    private List<String> countyWz=Arrays.asList(new String[]{"瓯海", "永嘉","鹿城"});
    private List<String> dataList=new ArrayList<>();
    private TextView textView=null;
    private Button backBtn=null;
    private ListView listView=null;
    private ArrayAdapter adapter;
    /**
     * 当前选中的等级
     */
    private int currentLevel=1;
    private static int selectedProvinceIndex=0;
    private static int selectedCityIndex=0;
    public static final int LEVEL_PROVINCE=1;
    public static final int LEVEL_CITY=2;
    public static final int LEVEL_COUNTY=3;

    private void showCities(int position){
        currentLevel=2;
        backBtn.setVisibility(View.VISIBLE);
        dataList.clear();
        if(provinces.get(position).equals("北京")){
            dataList.addAll(cityBj);
            textView.setText("北京");
        }else if(provinces.get(position).equals("浙江")){
            dataList.addAll(cityZj);
            textView.setText("浙江");
        }
        adapter.notifyDataSetChanged();
    }
    private void showCounties(int position){
        currentLevel=3;
        dataList.clear();
        backBtn.setVisibility(View.VISIBLE);
        if(cityZj.get(position).equals("温州")){
            dataList.addAll(countyWz);
            textView.setText("温州");
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.ptitle);
        backBtn= (Button) findViewById(R.id.title_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LEVEL_COUNTY==currentLevel) {
                    showCities(selectedProvinceIndex);
                }else if(LEVEL_CITY==currentLevel) {
                    textView.setText("省份");
                    currentLevel=1;
                    backBtn.setVisibility(View.GONE);
                    dataList.clear();
                    dataList.addAll(provinces);
                    adapter.notifyDataSetChanged();;
                }

            }
        });
        listView=(ListView)findViewById(R.id.list_view);
        dataList.addAll(provinces);
         adapter=new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(LEVEL_PROVINCE==currentLevel){
                    selectedProvinceIndex=position;
                    showCities(selectedProvinceIndex);
                }else if(LEVEL_CITY==currentLevel){
                    selectedCityIndex=position;
                    showCounties(selectedCityIndex);
                }
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
