package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText address, subject, message;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendBtn);
        address = findViewById(R.id.address);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);

        sendBtn.setOnClickListener(v -> {
            String userAddress = address.getText().toString();
            String userSubject = subject.getText().toString();
            String userMessage = message.getText().toString();

            sendEmail(userAddress, userSubject, userMessage);
        });

    }

    @SuppressLint("IntentReset")
    public void sendEmail(String userAddress, String userSubject, String userMessage){
        String[] emailAddress = {userAddress};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, userSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, userMessage);
        startActivity(Intent.createChooser(emailIntent, "email send"));

    }
}