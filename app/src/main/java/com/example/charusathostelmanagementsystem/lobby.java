package com.example.charusathostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lobby extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looby);

        findViewById(R.id.Room).setOnClickListener(this);
        findViewById(R.id.Mess).setOnClickListener(this);
        findViewById(R.id.Bookings).setOnClickListener(this);
        findViewById(R.id.sd).setOnClickListener(this);
        findViewById(R.id.hostel).setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Room:
                startActivity(new Intent(lobby.this, room.class));
                break;

            case R.id.hostel:

                startActivity(new Intent(lobby.this, hostel.class));

                break;

            case R.id.Bookings:

                startActivity(new Intent(lobby.this, Bookings.class));

                break;
            case R.id.Mess:
                startActivity(new Intent(lobby.this, Mess.class));

                break;
            case R.id.sd:
                startActivity(new Intent(lobby.this, SD.class));

                break;


        }
    }

}