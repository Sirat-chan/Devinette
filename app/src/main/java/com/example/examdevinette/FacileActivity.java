package com.example.examdevinette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class FacileActivity extends AppCompatActivity {
    EditText edt2;
    Button btnConfirm;
    int choicePc,userChoice,nbreessaie=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facile);
        edt2=this.findViewById(R.id.edt2);
        btnConfirm=this.findViewById(R.id.btnConf);

        Random r = new Random();
        choicePc = r.nextInt(90)+10;



            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String editText1 = edt2.getText().toString();
                    userChoice = Integer.valueOf(editText1);
                    nbreessaie = nbreessaie+1;
                    if (userChoice<10 || userChoice>90){
                        Toast.makeText(FacileActivity.this, "Please enter a number between 10 and 90!", Toast.LENGTH_LONG).show();

                    }
                    else if(userChoice<choicePc){
                        Toast.makeText(FacileActivity.this, "Nombre recherché plus grand!", Toast.LENGTH_LONG).show();
                    }
                    else if(userChoice>choicePc)
                    {Toast.makeText(FacileActivity.this, "Nombre recherché plus petit!", Toast.LENGTH_LONG).show();
                    }else if(userChoice==choicePc){
                        Toast.makeText(FacileActivity.this, "Congratulation!", Toast.LENGTH_LONG).show();
                        win(view);
                    }
                    else {
                        Toast.makeText(FacileActivity.this, "please enter a value!", Toast.LENGTH_LONG).show();
                    }

                    if (nbreessaie==5){
                        Toast.makeText(FacileActivity.this, "Game over ! Correct number is ="+choicePc, Toast.LENGTH_LONG).show();
                        loss(view);
                        btnConfirm.setEnabled(false);
                    }

                }
            });
}
    public void win(View v ){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragplacefac, WinFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
    public void loss(View v ){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragplacefac, LossFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
}