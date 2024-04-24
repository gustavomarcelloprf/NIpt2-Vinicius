package com.gustavo.nipt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFinanceiro = findViewById(R.id.btnFinanceiro);
        btnFinanceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FinanceiroActivity.class);
                startActivity(intent);
            }
        });

        Button btnEducacao = findViewById(R.id.btnEducacao);
        btnEducacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EducacaoActivity.class);
                startActivity(intent);
            }
        });

        Button btnSaude = findViewById(R.id.btnSaude);
        btnSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaudeActivity.class);
                startActivity(intent);
            }
        });

        Button btnInformacoes = findViewById(R.id.btnInformacoes);
        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InformacoesActivity.class);
                startActivity(intent);
            }
        });
    }

}