package com.example.calculadora;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // ATRIBUTOS
    private TextView display;
    private Button buttonClear;
    private Button buttonPlus;
    private Button buttonLess;
    private Button buttonMultiply;
    private Button buttonSplit;
    private Double operando;
    private Operador operador;
    private Button buttonEquals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        buttonClear = findViewById(R.id.buttonClear);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonLess = findViewById(R.id.buttonLess);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonSplit = findViewById(R.id.buttonSplit);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonClear.setOnClickListener (view -> display.setText("0"));

        // BOTÓN SUMA
        buttonPlus.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.SUMA;
            display.setText("0");
        });

        // BOTÓN RESTA
        buttonLess.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.RESTA;
            display.setText("0");
        });

        // BOTÓN MULTIPLICACIÓN
        buttonMultiply.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.MULTIPLICACION;
            display.setText("0");
        });

        // BOTÓN DIVISIÓN
        buttonSplit.setOnClickListener(view -> {
            operando = Double.parseDouble(display.getText().toString());
            operador = Operador.DIVISION;
            display.setText("0");
        });

        // BOTÓN IGUAL
        buttonEquals.setOnClickListener(view -> {
            if (operador == Operador.SUMA) {
                Double resultado = operando + Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            } else if (operador == Operador.RESTA) {
                Double resultado = operando - Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            } else if (operador == Operador.MULTIPLICACION) {
                Double resultado = operando * Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            } else {
                Double resultado = operando / Double.parseDouble(display.getText().toString());
                display.setText(resultado.toString());
            }
        });
    }

    public void onClick (View view) {
        if (display.getText().equals("0"))
            display.setText(((Button)view).getText());
        else
            display.setText(String.valueOf(display.getText())+((Button)view).getText
                    ());
    }
}
