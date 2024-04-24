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

public class SaudeActivity extends AppCompatActivity {

    private EditText edtPeso, edtAltura;
    private TextView txtPeso, txtAltura, txtIMC, txtClassificacao;
    private Button btnCalcular, btnLimpar, btnEncerrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtIMC = findViewById(R.id.txtIMC);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnEncerrar = findViewById(R.id.btnEncerrar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
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

    private void calcularIMC() {
        String pesoStr = edtPeso.getText().toString();
        String alturaStr = edtAltura.getText().toString();

        if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
            double peso = Double.parseDouble(pesoStr);
            double altura = Double.parseDouble(alturaStr);
            double imc = peso / (altura * altura);
            String classificacao;

            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc < 25) {
                classificacao = "Peso normal";
            } else if (imc < 30) {
                classificacao = "Sobrepeso";
            } else {
                classificacao = "Obesidade";
            }

            txtPeso.setText(String.format(Locale.getDefault(), "Peso: %.2f kg", peso));
            txtAltura.setText(String.format(Locale.getDefault(), "Altura: %.2f m", altura));
            txtIMC.setText(String.format(Locale.getDefault(), "IMC: %.2f", imc));
            txtClassificacao.setText("Classificação: " + classificacao);
        } else {
            Toast.makeText(this, "Por favor, insira o peso e a altura.", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        edtPeso.setText("");
        edtAltura.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
        txtIMC.setText("");
        txtClassificacao.setText("");
    }
}

