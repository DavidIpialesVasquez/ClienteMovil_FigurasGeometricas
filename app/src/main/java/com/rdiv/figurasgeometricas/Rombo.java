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

public class Rombo extends AppCompatActivity {
    private EditText diagonalMayor, diagonalMenor, lado;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);

        diagonalMayor = findViewById(R.id.et_diagonalMayor);
        diagonalMenor = findViewById(R.id.et_diagonalMenor);
        lado = findViewById(R.id.et_lado);
        resultado = findViewById(R.id.tv_resultado);
        Button calcular = findViewById(R.id.btn_calcular);

        calcular.setOnClickListener(v -> {
            String dMayor = diagonalMayor.getText().toString();
            String dMenor = diagonalMenor.getText().toString();
            String l = lado.getText().toString();

            String url = "http://10.10.22.233:3000/rombo/" + dMayor + "/" + dMenor + "/" + l;

            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.GET, url,
                    response -> resultado.setText(response),
                    error -> resultado.setText("Error: " + error.getMessage()));

            queue.add(request);
        });
    }
}
