package com.example.charusathostelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bookings extends AppCompatActivity {
    EditText name,id,phone,email,add,hostel,room,sem;
    Button submit;

    FirebaseDatabase root;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        name = (EditText) findViewById(R.id.name);
        id = (EditText)findViewById(R.id.id);
        phone =(EditText) findViewById(R.id.p);
        email = (EditText)findViewById(R.id.e);
        add = (EditText)findViewById(R.id.a);
        hostel = (EditText)findViewById(R.id.h);
        room = (EditText)findViewById(R.id.r);
        sem = (EditText)findViewById(R.id.no);
    }



            public void sub(View v) {
                root=FirebaseDatabase.getInstance();
                ref=root.getReference("users");

                String n1 = name.getText().toString();
                String i1 = id.getText().toString();
                String p1 = phone.getText().toString();
                String e1 = email.getText().toString();
                String a1 = add .getText().toString();
                String h1 = hostel.getText().toString();
                String r1 = room.getText().toString();
                String s1 = sem.getText().toString();

                Userhelper userhelper = new Userhelper(n1,i1,p1,e1,a1,h1,r1,s1);

                ref.child(i1).setValue(userhelper);

            }
        }


