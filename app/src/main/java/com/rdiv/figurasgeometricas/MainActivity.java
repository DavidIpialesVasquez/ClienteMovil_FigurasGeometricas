package com.rdiv.figurasgeometricas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTrapecio = findViewById(R.id.btnTrapecio);
        Button btnRombo = findViewById(R.id.btnRombo);
        Button btnCirculo = findViewById(R.id.btnCirculo);
        Button btnTrinomio = findViewById(R.id.btnTrinomio);

        btnTrapecio.setOnClickListener(v -> startActivity(new Intent(this, Trapecio.class)));
        btnRombo.setOnClickListener(v -> startActivity(new Intent(this, Rombo.class)));
        btnCirculo.setOnClickListener(v -> startActivity(new Intent(this, Circulo.class)));
        btnTrinomio.setOnClickListener(v -> startActivity(new Intent(this, TrinomioCuadradoPerfecto.class)));
    }
}
