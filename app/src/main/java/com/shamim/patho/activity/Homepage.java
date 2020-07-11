package com.shamim.patho.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shamim.patho.Broadcast.InternetDetector;
import com.shamim.patho.R;
import com.shamim.patho.service.CountingService;

public class Homepage extends AppCompatActivity {
 Button phone;
TextView number;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        phone = findViewById(R.id.read);
      number = findViewById(R.id.number);

        //Broadcast Receiver
        InternetDetector internetDetector = new InternetDetector();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(internetDetector, intentFilter);
    }

    public void startbutton(View view) {
        Intent intent = new Intent(this, CountingService.class);
        startService(intent);
    }

    //Read contact number
    public void contact(View view) {
        StringBuilder contactBuilder = new StringBuilder("");

        String [] projection={
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
        };
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,projection,
                null,null,null);

        if (cursor !=null && cursor.getCount()>0){
            while(cursor.moveToNext()){
                contactBuilder.append(cursor.getString(0)+"\n");
            }


        }
      number.setText(contactBuilder.toString());
    }
}