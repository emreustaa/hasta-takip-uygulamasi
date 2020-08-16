package com.example.nabizprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.UFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Write a message to the database


    private static final String TAG = "MainActivity";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private Toolbar toolbaranaSayfa;
    private LineChart lineChart;
    private Button buttonBasla, buttonBitis, buttonAnaliz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbaranaSayfa = findViewById(R.id.toolbarAnaSayfa);
        toolbaranaSayfa.setTitle("Grafik");
        toolbaranaSayfa.setTitleTextColor(Color.WHITE);
        buttonBasla = findViewById(R.id.buttonBasla);
        buttonBitis = findViewById(R.id.buttonBitir);
        buttonAnaliz = findViewById(R.id.buttonAnaliz);


        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lineChart = findViewById(R.id.linechart);
                lineChart.setDragEnabled(true);

                lineChart.setScaleEnabled(false);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        ArrayList<Entry> yValues = new ArrayList<>();
                        int i = 1;

                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            //Log.e("", String.valueOf(dataSnapshot1.getValue()));
                            yValues.add(new Entry(i, Float.parseFloat(String.valueOf(dataSnapshot1.getValue()))));
                            i++;

                        }

                        Log.e("i değerleri", String.valueOf(i));
                        LineDataSet set1 = new LineDataSet(yValues, "Data Set 1");
                        set1.setFillAlpha(110);

                        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                        dataSets.add(set1);
                        LineData lineData = new LineData(dataSets);
                        lineChart.setData(lineData);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        buttonBitis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        buttonAnaliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, KisiAnaliz.class);
                startActivity(i);
            }
        });

    }


}