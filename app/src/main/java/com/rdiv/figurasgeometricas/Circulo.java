package com.rdiv.figurasgeometricas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Circulo extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;
    private Button calcular;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        radio = findViewById(R.id.et_radio);
        resultado = findViewById(R.id.tv_resultado);
        calcular = findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(v -> {
            double r = Double.parseDouble(radio.getText().toString());

            double area = Math.PI * r * r;
            double perimetro = 2 * Math.PI * r;

            resultado.setText("Área: " + area + "\nPerímetro: " + perimetro);
        });
    }
}
