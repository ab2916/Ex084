package com.example.ex084;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ex084.R;
import com.example.ex084.custom_adapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner s;
    TextView tv1, tv2, tv3;
    int[] imgid = {0, R.drawable.brazil, R.drawable.denmark, R.drawable.britain, R.drawable.greece, R.drawable.israel, R.drawable.italy, R.drawable.niger};
    String[] names = {"choose a country!", "brazil", "denmark", "britain", "greece", "israel", "italy", "niger"};
    String[] capitals = {"", "brazilia", "copenhagen", "london", "athens", "jerusalem", "rome", "niamey"};
    String[] pupolation = {"0", "46,160,619", "1,227,804", "56,489,800",
            "9,620,114", "0", "10,127,597", "3,501,728"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = (Spinner) findViewById(R.id.spinner);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        s.setOnItemSelectedListener(this);
        custom_adapter customadp = new custom_adapter(getApplicationContext(),
                names, imgid,capitals);
        s.setAdapter(customadp);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0)
        {
            tv1.setText("");
            tv2.setText("");
            tv3.setText("");
        }
        else
        {
            tv1.setText(names[i]);
            tv3.setText(capitals[i]);
            tv2.setText(pupolation[i]);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
    }
}