package com.example.pc.dashboard;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlanVisit extends AppCompatActivity {
    private static final String TAG = PlanVisit.class.getSimpleName();
    EditText ed1, ed2, ed3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_visit);
        ed1 = (EditText) findViewById(R.id.editText_enter_name);
        ed2 = (EditText) findViewById(R.id.editText_enter_username);
        ed3 = (EditText) findViewById(R.id.editText_enter_password);
        b1 = (Button) findViewById(R.id.button_sms);
        b2 = (Button) findViewById(R.id.button_mail);

    }

    public void sendSms(View view) {
        String name = ed1.getText().toString();
        String purpose = ed2.getText().toString();
        String materials = ed3.getText().toString();
        String sms = new StringBuilder(25).append("Name :").append(name).append("\n").append("Purpose of Visit :").append(purpose).append("\n")
                .append(" Materials Req :").append(purpose).append(materials).toString();
        ActivityCompat.requestPermissions(PlanVisit.this,
                new String[]{Manifest.permission.SEND_SMS},
                1);

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+9779849902150", null, sms, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.d(TAG,"Failed");
            e.printStackTrace();
        }


    }

    public void sendEmail(View view) {
        Log.i("Send email", "");

        String name = ed1.getText().toString();
        String purpose = ed2.getText().toString();
        String materials = ed3.getText().toString();
        String email = new StringBuilder(25).append("Name :").append(name).append("\n").append("Purpose of Visit :").append(purpose).append("\n")
                .append(" Materials Req :").append(materials).toString();


        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Visiting Organization");
        emailIntent.putExtra(Intent.EXTRA_TEXT, email);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}