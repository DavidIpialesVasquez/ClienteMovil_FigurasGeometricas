package com.rdiv.figurasgeometricas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class Trapecio extends AppCompatActivity {

    private EditText etBase1, etBase2, etAltura;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapecio);

        etBase1 = findViewById(R.id.etBase1);
        etBase2 = findViewById(R.id.etBase2);
        etAltura = findViewById(R.id.etAltura);
        tvResult = findViewById(R.id.tvResult);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculateArea());
    }

    private void calculateArea() {
        String base1 = etBase1.getText().toString();
        String base2 = etBase2.getText().toString();
        String altura = etAltura.getText().toString();

        String url = "http://<TU_IP>:3000/trapecio/" + base1 + "/" + base2 + "/" + altura;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> tvResult.setText(response),
                error -> tvResult.setText("Error: " + error.getMessage()));

        queue.add(request);
    }
}
