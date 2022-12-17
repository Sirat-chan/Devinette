package com.example.examdevinette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edttxt;
    Button btnplay;
    TextView txtdef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edttxt = this.findViewById(R.id.edttxt);
        btnplay = this.findViewById(R.id.btnplay);
        txtdef = this.findViewById(R.id.tvdef);

        this.txtdef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linternaute.fr/dictionnaire/fr/definition/devinette/"));
                startActivity(i);
            }
        });

        btnplay.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String EditText = edttxt.getText().toString();
        if(!(EditText.equals(""))){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            i.putExtra("login", EditText);
            startActivity(i);
        }
        else{
            Toast.makeText(LoginActivity.this, "Enter Your Name Please", Toast.LENGTH_LONG).show();
        }
    }
}
