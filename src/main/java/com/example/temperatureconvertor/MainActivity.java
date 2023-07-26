package com.example.temperatureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Spinner sp1;
    EditText et1;
    Button b1;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        sp1=findViewById(R.id.sp1);
        et1=findViewById(R.id.et1);
        b1=findViewById(R.id.b1);

        String arr[]={"Celsius", "Fahrenheit"};


        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(ad);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=sp1.getSelectedItem().toString();
                if (s.equals("Fahrenheit")){
                    if (et1.getText().toString().equals("")){
                        tv3.setText("Enter Temperature!");
                    }else{
                        int c=Integer.parseInt(et1.getText().toString());
                        int f= ((c*9)/5)+32;
                        tv3.setText(""+f+"°F");
                    }

                }
                else if (s.equals("Celsius")){
                    if (et1.getText().toString().equals("")) {
                        tv3.setText("Enter Temperature!");
                    } else {
                        int f = Integer.parseInt(et1.getText().toString());
                        int c = ((f - 32) * 5) / 9;
                        tv3.setText("" + c + "°C");
                    }
                }
            }
        });


    }
}