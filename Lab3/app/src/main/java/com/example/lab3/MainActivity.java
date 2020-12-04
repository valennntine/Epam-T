package com.example.lab3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private MainService service;

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            MainService.MainServiceBinder binder = (MainService.MainServiceBinder) service;
            MainActivity.this.service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MainService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textViewForOutNumber = findViewById(R.id.TextView_ToOutString);

        switch (item.getItemId()) {
            case R.id.menu_germany:
                textViewForOutNumber.setText(service.getHelloWorldOnGermany());
                return true;
            case R.id.menu_japanese:
                textViewForOutNumber.setText(service.getHelloWorldOnJapanese());
                return true;
            case R.id.menu_russia:
                textViewForOutNumber.setText(service.getHelloWorldOnRussia());
                return true;
            case R.id.menu_spain:
                textViewForOutNumber.setText(service.getHelloWorldOnSpain());
                return true;
            case R.id.menu_сhinese:
                textViewForOutNumber.setText(service.getHelloWorldOnChinese());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}