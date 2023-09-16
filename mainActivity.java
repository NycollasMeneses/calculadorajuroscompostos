package com.example.calculadorajuroscompostos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPresentValue;
    private EditText editTextMonthlyInvestment;
    private EditText editTextInterestRate;
    private EditText editTextDuration;
    private Button buttonCalculate;
    private Button buttonClear;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPresentValue = findViewById(R.id.editTextPresentValue);
        editTextMonthlyInvestment = findViewById(R.id.editTextMonthlyInvestment);
        editTextInterestRate = findViewById(R.id.editTextInterestRate);
        editTextDuration = findViewById(R.id.editTextDuration);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClear = findViewById(R.id.buttonClear);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateVF();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void calculateVF() {
        try {
            double presentValue = Double.parseDouble(editTextPresentValue.getText().toString());
            double monthlyInvestment = Double.parseDouble(editTextMonthlyInvestment.getText().toString());
            double interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
            double duration = Double.parseDouble(editTextDuration.getText().toString());

            double i = interestRate / 100;
            double vf = presentValue * Math.pow(1 + i, duration) + monthlyInvestment * ((Math.pow(1 + i, duration) - 1) / i);

            textViewResult.setText(getString(R.string.result_label) + " " + vf);
        } catch (NumberFormatException e) {
            textViewResult.setText("Por favor, insira valores válidos.");
        }
    }

    private void clearFields() {
        editTextPresentValue.setText("");
        editTextMonthlyInvestment.setText("");
        editTextInterestRate.setText("");
        editTextDuration.setText("");
        textViewResult.setText("");
    }
}

