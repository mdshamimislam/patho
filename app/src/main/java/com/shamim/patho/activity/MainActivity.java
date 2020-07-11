package com.shamim.patho.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shamim.patho.Broadcast.InternetDetector;
import com.shamim.patho.R;

public class MainActivity extends AppCompatActivity {
    TextView name, password;
    ProgressDialog progressDialog;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Password = password.getText().toString();

                if (Name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Your User Name", Toast.LENGTH_SHORT).show();

                } else if (Password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (Name.equals("bangladesh") && Password.equals("123")) {

                        Intent intent = new Intent(MainActivity.this, Homepage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "UserName = bangladesh and password= 123", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}