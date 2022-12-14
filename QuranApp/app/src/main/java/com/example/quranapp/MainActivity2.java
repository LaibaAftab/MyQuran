package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLOutput;
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
        QuranArabicText ayaat = new QuranArabicText();
        ArrayList<String> ayyats = new ArrayList<>();
        if(i.getIntExtra("name",0)!=113)
        {
            startindex = arr[i.getIntExtra("name",0)];
            endindex = arr[i.getIntExtra("name",0)+1];
            endindex--;
        }
        else
        {
            startindex = ayaat.QuranArabicText.length-6;
            endindex =ayaat.QuranArabicText.length;
        }

        for(int j =startindex - 1;j<endindex;j++ )
        {
            ayyats.add(ayaat.QuranArabicText[j]);
        }

        ArrayAdapter<String> a = new ArrayAdapter<>(MainActivity2.this,android.R.layout.simple_list_item_1,ayyats);
        list.setAdapter(a);

    }
}