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

public class TrinomioCuadradoPerfecto extends AppCompatActivity {
    private EditText etA, etB;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trinomio_cuadrado_perfecto);

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        tvResult = findViewById(R.id.tvResult);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            String a = etA.getText().toString();
            String b = etB.getText().toString();

            if (a.isEmpty() || b.isEmpty()) {
                tvResult.setText("Por favor, ingresa ambos valores.");
                return;
            }

            String url = "http://192.168.1.5:3000/trinomio/" + a + "/" + b;

            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.GET, url,
                    response -> tvResult.setText("Resultado: " + response),
                    error -> tvResult.setText("Error: " + error.getMessage()));

            queue.add(request);
        });
    }
}
