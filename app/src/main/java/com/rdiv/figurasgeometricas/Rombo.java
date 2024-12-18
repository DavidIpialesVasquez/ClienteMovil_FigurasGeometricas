package com.rdiv.figurasgeometricas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Rombo extends AppCompatActivity {
    private EditText diagonalMayor, diagonalMenor, lado;
    private TextView resultado;
    private Button calcular;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);

        diagonalMayor = findViewById(R.id.et_diagonalMayor);
        diagonalMenor = findViewById(R.id.et_diagonalMenor);
        lado = findViewById(R.id.et_lado);
        resultado = findViewById(R.id.tv_resultado);
        calcular = findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(v -> {
            double dMayor = Double.parseDouble(diagonalMayor.getText().toString());
            double dMenor = Double.parseDouble(diagonalMenor.getText().toString());
            double l = Double.parseDouble(lado.getText().toString());

            double area = (dMayor * dMenor) / 2;
            double perimetro = 4 * l;

            resultado.setText("Área: " + area + "\nPerímetro: " + perimetro);
        });
    }
}
