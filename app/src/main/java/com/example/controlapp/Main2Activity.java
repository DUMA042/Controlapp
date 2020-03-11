package com.example.controlapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    Switch bulb,air_con,oven,charger;
    DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference device_bulb=mRootRef.child("bulb");
    DatabaseReference device_air_con=mRootRef.child("aircon");
    DatabaseReference device_oven=mRootRef.child("oven");
    DatabaseReference device_charger=mRootRef.child("charger");
    int  Temp_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bulb=findViewById(R.id.switch1);
        air_con=findViewById(R.id.switch2);
        oven=findViewById(R.id.switch3);
        charger=findViewById(R.id.switch4);




        bulb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //  Log.v("Switch State=", ""+isChecked);
                if(isChecked){
                    bulb.setText("ON");
                   device_bulb.setValue(1);
                }
                else{
                    bulb.setText("OFF");
                device_bulb.setValue(0);
                }

            }

        });

        oven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //  Log.v("Switch State=", ""+isChecked);
                if(isChecked){
                    oven.setText("ON");
                    device_oven.setValue(1);
                }
                else{
                    oven.setText("OFF");
                device_oven.setValue(0);
                }
            }

        });


        charger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //  Log.v("Switch State=", ""+isChecked);
                if(isChecked){
                    charger.setText("ON");
                   device_charger.setValue(1);
                }
                else{
                    charger.setText("OFF");
                device_charger.setValue(0);
                    }
            }

        });

        air_con.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            //  Log.v("Switch State=", ""+isChecked);
            if(isChecked){
                air_con.setText("ON");
                device_air_con.setValue(1);

            }
            else{
                air_con.setText("OFF");
            device_air_con.setValue(0);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        ////////
        device_bulb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Temp_check=dataSnapshot.getValue(Integer.class);
                if(Temp_check==1){
                    bulb.setText("ON");
                    bulb.setChecked(true);
                }
                else
                    bulb.setText("OFF");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        device_air_con.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Temp_check=dataSnapshot.getValue(Integer.class);
                if(Temp_check==1){
                    air_con.setText("ON");
                    air_con.setChecked(true);
                }
                else
                    air_con.setText("OFF");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        device_charger.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Temp_check=dataSnapshot.getValue(Integer.class);
                if(Temp_check==1){
                    charger.setText("ON");
                    charger.setChecked(true);
                }
                else
                    charger.setText("OFF");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        device_oven.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Temp_check=dataSnapshot.getValue(Integer.class);
                if(Temp_check==1){
                    oven.setText("ON");
                    oven.setChecked(true);
                }
                else
                    oven.setText("OFF");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
