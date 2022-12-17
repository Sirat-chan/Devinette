package com.example.examdevinette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioButton btnfac,btndif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=this.findViewById(R.id.button);
        btnfac=this.findViewById(R.id.btnfac);
        btndif=this.findViewById(R.id.btndif);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnfac.isChecked()){
                    Intent i = new Intent(MainActivity.this, FacileActivity.class);
                    i.putExtra("Start", "facile");
                    startActivity(i);
                }
                else if (btndif.isChecked()){
                    Intent i = new Intent(MainActivity.this, DifficileActivity.class);
                    i.putExtra("Start", "difficile");
                    startActivity(i);
                }

                else{
                    Toast.makeText(MainActivity.this, "Enter Your Name Please", Toast.LENGTH_LONG).show();
                }
            }
        });

     /*  btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if(btnfac.isChecked()){
                    Intent i = new Intent(MainActivity.this,GameActivity.class);
                    i.putExtra("Start", i);
                    startActivity(i);
                }

                else{
                    Toast.makeText(MainActivity.this, "Enter Your Name Please", Toast.LENGTH_LONG).show();
                }
            }*/


    }
}