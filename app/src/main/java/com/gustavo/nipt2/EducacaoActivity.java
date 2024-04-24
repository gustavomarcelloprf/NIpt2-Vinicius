package com.gustavo.nipt2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class EducacaoActivity extends AppCompatActivity {

    private EditText edtNI1, edtNI2, edtPI, edtPO;
    private TextView txtMedia, txtStatus;
    private Button btnCalcular, btnLimpar, btnEncerrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);

        edtNI1 = findViewById(R.id.edtNI1);
        edtNI2 = findViewById(R.id.edtNI2);
        edtPI = findViewById(R.id.edtPI);
        edtPO = findViewById(R.id.edtPO);
        txtMedia = findViewById(R.id.txtMedia);
        txtStatus = findViewById(R.id.txtStatus);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnEncerrar = findViewById(R.id.btnEncerrar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        btnEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularMedia() {
        String ni1Str = edtNI1.getText().toString();
        String ni2Str = edtNI2.getText().toString();
        String piStr = edtPI.getText().toString();
        String poStr = edtPO.getText().toString();

        if (!ni1Str.isEmpty() && !ni2Str.isEmpty() && !piStr.isEmpty() && !poStr.isEmpty()) {
            double ni1 = Double.parseDouble(ni1Str);
            double ni2 = Double.parseDouble(ni2Str);
            double pi = Double.parseDouble(piStr);
            double po = Double.parseDouble(poStr);

            double media = (ni1 * 0.1) + (ni2 * 0.1) + (pi * 0.3) + (po * 0.5);

            txtMedia.setText(String.format(Locale.getDefault(), "Média: %.2f", media));
            if (media >= 6.0) {
                txtStatus.setText("Aprovado");
            } else {
                txtStatus.setText("Reprovado");
            }
        } else {
            Toast.makeText(this, "Por favor, insira todas as notas.", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        edtNI1.setText("");
        edtNI2.setText("");
        edtPI.setText("");
        edtPO.setText("");
        txtMedia.setText("");
        txtStatus.setText("");
    }
}

