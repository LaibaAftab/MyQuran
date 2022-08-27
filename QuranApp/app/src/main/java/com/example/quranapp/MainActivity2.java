package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        list = findViewById(R.id.list2);
        suratName s = new suratName();
        int[] arr =s.SSP;
        int startindex,endindex;
        if(i.getIntExtra("name",0)<143)
        {
            startindex = arr[i.getIntExtra("name",0)];
            endindex = arr[i.getIntExtra("name",0)+1];
        }
        else
        {
            startindex = arr[i.getIntExtra("name",0)];
            endindex = 6342;
        }
        endindex--;
        QuranArabicText ayaat = new QuranArabicText();
        ArrayList<String> ayyats = new ArrayList<>();

        for(int j =startindex -1;j<endindex;j++ )
        {
            ayyats.add(ayaat.QuranArabicText[j]);
        }
        ArrayAdapter<String> a = new ArrayAdapter<>(MainActivity2.this,android.R.layout.simple_list_item_1,ayyats);
        list.setAdapter(a);

    }
}