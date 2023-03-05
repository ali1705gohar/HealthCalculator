package com.example.mc_lab_healthcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class acbmi extends AppCompatActivity {

    String typeofuser="0";
    EditText txtage,txtheightft,txtheightinc,txtweight;
    Button btnbmicalc;
    TextView resutbmi;
    ConstraintLayout clres,maillay,femaillay;

    int age=0;
    int heft=0;
    int heinc=0;
    int wt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acbmi);



        maillay=findViewById(R.id.manlayout);
        femaillay=findViewById(R.id.femaillayout);

        txtage=findViewById(R.id.agetxt);
        txtheightft=findViewById(R.id.heightfttxt);
        txtheightinc=findViewById(R.id.heightinctxt);
        txtweight=findViewById(R.id.weighttxt);
        btnbmicalc=findViewById(R.id.btnbmical);
        resutbmi=findViewById(R.id.bmiresult);
        clres=findViewById(R.id.resultlayout);


    maillay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            maillay.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.genderfocus));
            femaillay.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gendernonfocus));
            typeofuser="Male";
        }
    });

    femaillay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            femaillay.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.genderfocus));
            maillay.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gendernonfocus));
            typeofuser="Femail";
        }
    });

        btnbmicalc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (typeofuser.equals("0")) {
                    Toast.makeText(acbmi.this, "Please Select Your Gender", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(txtage.getText().toString())) {
                    Toast.makeText(acbmi.this, "Please Enter Your Correct Age", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(txtheightft.getText())) {
                    Toast.makeText(acbmi.this, "Please Enter Your Correct Height", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(txtheightinc.getText())){
                    txtheightinc.setText("0");
                }
                if (TextUtils.isEmpty(txtweight.getText())) {
                    Toast.makeText(acbmi.this, "Please Enter Your Correct Weight", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    age = Integer.parseInt(txtage.getText().toString());
                    if(age<=0){
                        Toast.makeText(acbmi.this, "Please Enter Your Correct Age (age can't be 0)", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    wt = Integer.parseInt(txtweight.getText().toString());
                    if(wt<=0){
                        Toast.makeText(acbmi.this, "Please Enter Your Correct Weight", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    heft = Integer.parseInt(txtheightft.getText().toString());
                    if (heft<=0||heft>10){
                        Toast.makeText(acbmi.this, "Please Enter Your Correct Height (can't be <0 or >10)", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    heinc = Integer.parseInt(txtheightinc.getText().toString());

                    int totalinc = heft * 12 + heinc;
                    double totalcm = (totalinc * 2.53);
                    double totalmeter = totalcm / 100;
                    double bmi = wt / (totalmeter * totalmeter);

                    if (bmi>=25){
                        resutbmi.setText("You're Overweight");
                        resutbmi.setTextColor(Color.parseColor("#DF2E38"));
                    } else if (bmi<=18) {
                        resutbmi.setText("You're Underweight");
                        resutbmi.setTextColor(Color.parseColor("#E7B10A"));
                    }else {
                        resutbmi.setText("You're Healthy");
                        resutbmi.setTextColor(Color.parseColor("#539165"));
                    }


                }
            }
        });


    }
}