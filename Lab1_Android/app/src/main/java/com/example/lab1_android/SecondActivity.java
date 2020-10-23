package com.example.lab1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Integer getInt(Intent data, String field) {
        return Integer.parseInt(data.getStringExtra(field));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent receivedIntent = getIntent();
        Integer text = getInt(receivedIntent, "text");
        Integer num = getInt(receivedIntent, "num");
        Integer finalInteger = text + num;

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText(finalInteger.toString());

        EditText et2 = (EditText) findViewById(R.id.et2);

        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToReturn = new Intent();
                intentToReturn.putExtra("text", tv2.getText().toString());
                intentToReturn.putExtra("num", et2.getText().toString());
                setResult(Activity.RESULT_OK, intentToReturn);
                finish();
            }
        });
    }
}