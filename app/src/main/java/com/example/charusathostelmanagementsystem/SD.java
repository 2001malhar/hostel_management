package com.example.charusathostelmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SD extends AppCompatActivity {

    FirebaseDatabase root;
    DatabaseReference ref;
    TextView name,phone,email,add,hostel,room,sem;
    EditText gid;
    Button saerch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root=FirebaseDatabase.getInstance();
        ref=root.getReference("users");

        setContentView(R.layout.activity_sd);
        gid = (EditText)findViewById(R.id.search);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.p);
        email = findViewById(R.id.e);
        add = findViewById(R.id.a);
        hostel = findViewById(R.id.h);
        room = findViewById(R.id.r);
        sem =findViewById(R.id.no);

    }

    public void search(View v){
        final String ueid = gid.getText().toString().trim();

        Query checkID = ref.orderByChild("id").equalTo(ueid);

        checkID.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                gid.setError(null);

                    String namedb = dataSnapshot.child(ueid).child("name").getValue(String.class);
                    String phonedb= dataSnapshot.child(ueid).child("phone").getValue(String.class);
                    String emaildb = dataSnapshot.child(ueid).child("email").getValue(String.class);
                    String adddb = dataSnapshot.child(ueid).child("address").getValue(String.class);
                    String hosteldb = dataSnapshot.child(ueid).child("hostel").getValue(String.class);
                    String roomdb = dataSnapshot.child(ueid).child("room").getValue(String.class);
                    String semdb = dataSnapshot.child(ueid).child("sem").getValue(String.class);

                    name.setText(namedb);
                    add.setText(adddb);
                    phone.setText(phonedb);
                    email.setText(emaildb);
                    hostel.setText(hosteldb);
                    room.setText(roomdb);
                    sem.setText(semdb);





                }
                else
                {
                    gid.setError("No Such User exist");
                    gid.requestFocus();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}