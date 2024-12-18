package com.rdiv.figurasgeometricas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Circulo extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        radio = findViewById(R.id.et_radio);
        resultado = findViewById(R.id.tv_resultado);
        calcular = findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(v -> calcularArea());
    }

    private void calcularArea() {
        String r = radio.getText().toString();

        String url = "http://10.10.22.233:3000/circulo/" + r;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> resultado.setText(response),
                error -> resultado.setText("Error: " + error.getMessage()));

        queue.add(request);
    }
}
