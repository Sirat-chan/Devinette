package com.example.examdevinette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class DifficileActivity extends AppCompatActivity {
    EditText edt2;
    Button btnConfirm;
    int userChoice,nbreessaie=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficile);
        edt2=this.findViewById(R.id.edt2);
        btnConfirm=this.findViewById(R.id.btnConf);
        Random r = new Random();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
           int choicePc= r.nextInt(900)+100;
            @Override
            public void onClick(View view) {
                String editText1 = edt2.getText().toString();
                userChoice = Integer.valueOf(editText1);
                nbreessaie = nbreessaie+1;

                if (userChoice<100 || userChoice>900){
                    Toast.makeText(DifficileActivity.this, "Please enter a number between 100 and 900!", Toast.LENGTH_LONG).show();

                }
                else if(userChoice<choicePc){
                    Toast.makeText(DifficileActivity.this, "Nombre recherché plus grand!", Toast.LENGTH_LONG).show();
                }
                else if(userChoice>choicePc)
                {Toast.makeText(DifficileActivity.this, "Nombre recherché plus petit!", Toast.LENGTH_LONG).show();
                }else if(userChoice==choicePc){
                    Toast.makeText(DifficileActivity.this, "Congratulation!", Toast.LENGTH_LONG).show();
                    win(view);
                }
                else {
                    Toast.makeText(DifficileActivity.this, "please enter a value!", Toast.LENGTH_LONG).show();
                }

                if (nbreessaie==5){
                    Toast.makeText(DifficileActivity.this, "Game over ! Correct number is ="+choicePc, Toast.LENGTH_LONG).show();
                   loss(view);
                    btnConfirm.setEnabled(false);
                }

            }
        });
    }

    public void win(View v ){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragplace, WinFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
    public void loss(View v ){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragplace, LossFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
}