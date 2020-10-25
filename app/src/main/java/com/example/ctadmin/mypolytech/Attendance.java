package com.example.ctadmin.mypolytech;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        BarChart chart = (BarChart) findViewById(R.id.barchart);

        ArrayList<BarEntry> NoOfEmp = new ArrayList<>();


        NoOfEmp.add(new BarEntry(40, 0));
        NoOfEmp.add(new BarEntry(45, 1));
        NoOfEmp.add(new BarEntry(30, 2));
        NoOfEmp.add(new BarEntry(25, 3));
        NoOfEmp.add(new BarEntry(20, 4));

        ArrayList<String> year = new ArrayList<>();


        year.add("MC");
        year.add("PMSE");
        year.add("IS");
        year.add("PR");
        year.add("DS");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "Subjects");
        chart.animateY(10000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}
