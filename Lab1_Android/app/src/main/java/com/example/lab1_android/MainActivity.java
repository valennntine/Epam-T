package com.example.lab1_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et1 = (EditText) findViewById(R.id.et1);
                TextView tv1 = (TextView) findViewById(R.id.tv1);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("text", tv1.getText().toString());
                intent.putExtra("num", et1.getText().toString());
                startActivityForResult(intent, 100);
            }
        });
    }

    Integer getInt(Intent data, String field) {
        return Integer.parseInt(data.getStringExtra(field));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100) {
            if(resultCode == Activity.RESULT_OK) {
                Integer text = getInt(data, "text");
                Integer num = getInt(data, "num");
                Integer finalInteger = text + num;
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                tv1.setText(finalInteger.toString());
            }
        }
    }
}