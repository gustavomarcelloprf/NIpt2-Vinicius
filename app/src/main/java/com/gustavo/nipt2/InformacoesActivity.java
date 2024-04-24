package com.gustavo.nipt2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformacoesActivity extends AppCompatActivity {

    private TextView txtSalarioBruto, txtDescontoINSS, txtDescontoFGTS, txtSalarioLiquido;
    private TextView txtMedia, txtStatus;
    private TextView txtPeso, txtAltura, txtIMC, txtClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        txtSalarioBruto = findViewById(R.id.txtSalarioBruto);
        txtDescontoINSS = findViewById(R.id.txtDescontoINSS);
        txtDescontoFGTS = findViewById(R.id.txtDescontoFGTS);
        txtSalarioLiquido = findViewById(R.id.txtSalarioLiquido);
        txtMedia = findViewById(R.id.txtMedia);
        txtStatus = findViewById(R.id.txtStatus);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtIMC = findViewById(R.id.txtIMC);
        txtClassificacao = findViewById(R.id.txtClassificacao);

        Intent intent = getIntent();

        double salarioBruto = intent.getDoubleExtra("salarioBruto", 0.0);
        double descontoINSS = intent.getDoubleExtra("descontoINSS", 0.0);
        double descontoFGTS = intent.getDoubleExtra("descontoFGTS", 0.0);
        double salarioLiquido = intent.getDoubleExtra("salarioLiquido", 0.0);

        double media = intent.getDoubleExtra("media", 0.0);
        String status = intent.getStringExtra("status");

        double peso = intent.getDoubleExtra("peso", 0.0);
        double altura = intent.getDoubleExtra("altura", 0.0);
        double imc = intent.getDoubleExtra("imc", 0.0);
        String classificacao = intent.getStringExtra("classificacao");

        txtSalarioBruto.setText("Salário Bruto: " + salarioBruto);
        txtDescontoINSS.setText("Desconto INSS: " + descontoINSS);
        txtDescontoFGTS.setText("Desconto FGTS: " + descontoFGTS);
        txtSalarioLiquido.setText("Salário Líquido: " + salarioLiquido);

        txtMedia.setText("Média: " + media);
        txtStatus.setText("Status: " + status);

        txtPeso.setText("Peso: " + peso);
        txtAltura.setText("Altura: " + altura);
        txtIMC.setText("IMC: " + imc);
        txtClassificacao.setText("Classificação: " + classificacao);
    }
}
