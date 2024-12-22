package com.rdiv.figurasgeometricas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Trapecio extends AppCompatActivity {
    private EditText base1, base2, altura, lado1, lado2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapecio);

        base1 = findViewById(R.id.etBase1);
        base2 = findViewById(R.id.etBase2);
        lado1 = findViewById(R.id.etLado1);
        lado2 = findViewById(R.id.etLado2);
        altura = findViewById(R.id.etAltura);
        resultado = findViewById(R.id.tvResult);
        Button calcular = findViewById(R.id.btnCalculate);

        calcular.setOnClickListener(v -> {
            String b1 = base1.getText().toString();
            String b2 = base2.getText().toString();
            String h = altura.getText().toString();
            String l1 = lado1.getText().toString();
            String l2 = lado2.getText().toString();

            String url = "http://10.10.22.233:3000/trapecio/" + b1 + "/" + b2 + "/" + h + "/" + l1 + "/" + l2;

            if (b1.isEmpty() || b2.isEmpty() || h.isEmpty() || l1.isEmpty() || l2.isEmpty()) {
                resultado.setText("Por favor, completa todos los campos");
                return;
            }


            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.GET, url,
                    response -> resultado.setText(response),
                    error -> resultado.setText("Error: " + error.getMessage()));


            queue.add(request);
        });
    }
}
