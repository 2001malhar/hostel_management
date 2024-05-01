package com.example.charusathostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class hostel extends AppCompatActivity {
    ImageButton pre,next;
    ImageView p;
    int currentpic =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel);


    }
    public void pre(View v)
    {
        String idx="p"+currentpic;
        int x=this.getResources().getIdentifier(idx,"id",getPackageName());
        p=findViewById(x);
        p.setAlpha(0f);

        currentpic=(7+currentpic-1) % 7 ;
        String idy="p"+currentpic;
        int y=this.getResources().getIdentifier(idy,"id",getPackageName());
        p=findViewById(y);
        p.setAlpha(1f);

    }
    public void next(View v)
    {
        String idx="p"+currentpic;
        int x=this.getResources().getIdentifier(idx,"id",getPackageName());
        p=findViewById(x);
        p.setAlpha(0f);

        currentpic=(currentpic+1) % 7;
        String idy="p"+currentpic;
        int y=this.getResources().getIdentifier(idy,"id",getPackageName());
        p=findViewById(y);
        p.setAlpha(1f);

    }
}