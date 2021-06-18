package com.example.calculateyourbmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//public class bmiactivity extends AppCompatActivity
public class bmiactivity extends Fragment {

    android.widget.Button mrecalculatebmi;
    Button seeRecord;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageviews;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;



    public bmiactivity(String height){this.height=height;}

    public bmiactivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mrecalculatebmi = findViewById(R.id.recalculatebmi);
        seeRecord = findViewById(R.id.viewrecord);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;
        intbmi = intweight / (intheight * intheight);
        mbmi = Float.toString(intbmi);

        if (intbmi < 16)
        {
            mbmicategory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
        }
        else if (intbmi < 16.9 && intbmi > 16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
        }
        else if (intbmi < 18.4 && intbmi > 17)
        {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
        }
        else if (intbmi < 25 && intbmi > 18.4)
        {
            mbmicategory.setText("Normal");
            // mbackground.setBackgroundColor(Color.YELLOW);
        }
        else if (intbmi < 29.4 && intbmi > 25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
        }
        else
        {
            mbmicategory.setText("Obese");
            mbackground.setBackgroundColor(Color.RED);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);



        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        seeRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}