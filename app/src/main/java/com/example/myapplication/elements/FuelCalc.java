package com.example.myapplication.elements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class FuelCalc extends AppCompatActivity {
    private EditText distance,price,mileage;
    private Button calculate,button2;
    private TextView result;
    private double fuelConsumption = 0;
    private double fuelConsumption2 = 0;
    private double fuelCost = 0;
    private double fuelCost2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_calc);
        distance = findViewById(R.id.Distance);
        price = findViewById(R.id.fuel);
        mileage = findViewById(R.id.editTextTextPersonName3);
        calculate = findViewById(R.id.button4);
        result = findViewById(R.id.result);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float distanceInt = Float.parseFloat(distance.getText().toString());
                float priceInt = Float.parseFloat(price.getText().toString());
                float fuelInt = Float.parseFloat(mileage.getText().toString());

                if (distanceInt >0 && fuelInt > 0){
                    fuelConsumption = fuelInt / distanceInt * 100 ;
                    fuelConsumption2 = distanceInt / fuelInt  ;
                    fuelCost = priceInt / fuelConsumption;
                    fuelCost2 = 1 / fuelCost;
                    result.setText("Fuel consumption: " + String.format("%.2f",fuelConsumption) + " Liters per 100km ("+String.format("%.2f",fuelConsumption2) +" km per liter)\nFuel cost: " + String.format("%.2f",fuelCost) +" per km ("+String.format("%.2f",fuelCost2)+" km per Ruppees)");
                }

            }
        });
        button2 = findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FuelCalc.this, FuelPrice.class));
            }
        });
    }


}


