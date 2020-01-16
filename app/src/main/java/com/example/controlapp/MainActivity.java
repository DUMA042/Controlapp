package com.example.controlapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private Button mSendate ;
TextView Solar;
TextView Temperature;
TextView Humidity;
DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
DatabaseReference cond=mRootRef.child("Solar");
DatabaseReference cond1=mRootRef.child("Humidity");
DatabaseReference cond2=mRootRef.child("Temperature");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSendate=findViewById(R.id.button6);
        Solar =findViewById(R.id.solar_id);
        Temperature=findViewById(R.id.temp1);
        Humidity=findViewById(R.id.Hum1);


    }


    @Override
    protected void onStart(){
        super.onStart();
        cond2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Temperature.setText(dataSnapshot.getValue(String.class)+ "'C");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        cond1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                 Humidity.setText(dataSnapshot.getValue(String.class)+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        cond.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Solar.setText(dataSnapshot.getValue(String.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mSendate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_to_activity();
            }
        });

        //////////


    }
    public void go_to_activity(){
        Intent move_to_anthoer_ACT=new Intent(this,Main2Activity.class);
        startActivity(move_to_anthoer_ACT);
    }

}
