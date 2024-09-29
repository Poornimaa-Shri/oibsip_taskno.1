package com.example.unit_converter_app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    EditText inputValue;
    Spinner unitSpinner;
    Button convertButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValue = findViewById(R.id.inputValue);
        unitSpinner = findViewById(R.id.unitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.conversion_types, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }
    private void performConversion(){
        String input = inputValue.getText().toString();
        if(input.isEmpty()){
            resultTextView.setText("Please enter a Value");
            return;
        }
        double value = Double.parseDouble(input);
        int selectedConversion = unitSpinner.getSelectedItemPosition();
        double result = 0.0;
        switch (selectedConversion) {
            case 0:
                result = value / 100;
                break;
            case 1:
                result = value * 100;
                break;
            case 2:
                result = value / 1000;
                break;
            case 3:
                result = value * 100;
                break;

        }
        resultTextView.setText(String.valueOf(result));
    }
}