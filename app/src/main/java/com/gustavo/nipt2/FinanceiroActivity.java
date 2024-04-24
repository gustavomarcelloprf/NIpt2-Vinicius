package com.gustavo.nipt2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class FinanceiroActivity extends AppCompatActivity {

    private EditText edtSalario;
    private TextView txtSalarioBruto, txtDescontoINSS, txtDescontoFGTS, txtSalarioLiquido;
    private Button btnCalcular, btnLimpar, btnEncerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        edtSalario = findViewById(R.id.edtSalario);
        txtSalarioBruto = findViewById(R.id.txtSalarioBruto);
        txtDescontoINSS = findViewById(R.id.txtDescontoINSS);
        txtDescontoFGTS = findViewById(R.id.txtDescontoFGTS);
        txtSalarioLiquido = findViewById(R.id.txtSalarioLiquido);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnEncerrar = findViewById(R.id.btnEncerrar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSalario();
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

    private void calcularSalario() {
        String salarioStr = edtSalario.getText().toString();
        if (!salarioStr.isEmpty()) {
            double salario = Double.parseDouble(salarioStr);
            double descontoINSS = calcularDescontoINSS(salario);
            double descontoFGTS = calcularDescontoFGTS(salario);
            double salarioLiquido = salario - descontoINSS - descontoFGTS;

            txtSalarioBruto.setText(String.format(Locale.getDefault(), "R$ %.2f", salario));
            txtDescontoINSS.setText(String.format(Locale.getDefault(), "R$ %.2f", descontoINSS));
            txtDescontoFGTS.setText(String.format(Locale.getDefault(), "R$ %.2f", descontoFGTS));
            txtSalarioLiquido.setText(String.format(Locale.getDefault(), "R$ %.2f", salarioLiquido));
        } else {
            Toast.makeText(this, "Por favor, insira o salário.", Toast.LENGTH_SHORT).show();
        }
    }

    private double calcularDescontoINSS(double salario) {
        return salario * 0.1;
    }

    private double calcularDescontoFGTS(double salario) {
        return salario * 0.08;
    }

    private void limparCampos() {
        edtSalario.setText("");
        txtSalarioBruto.setText("");
        txtDescontoINSS.setText("");
        txtDescontoFGTS.setText("");
        txtSalarioLiquido.setText("");
    }
}
