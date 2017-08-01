package com.example.ruan.calculadora2;

import android.os.Bundle;
import android.renderscript.Double2;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnCalcular, btnAdicao, btnSubtracao, btnDivisao, btnMultiplicacao;
    private EditText edtValor1, edtValor2;
    private double valor1 = 0, valor2 = 0, resultado = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor1 = (EditText)findViewById(R.id.edtValor1);
        edtValor2 = (EditText)findViewById(R.id.edtValor2);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnAdicao = (Button)findViewById(R.id.btnAdicao);
        btnSubtracao = (Button)findViewById(R.id.btnSubtracao);
        btnDivisao = (Button)findViewById(R.id.btnDivisao);
        btnMultiplicacao = (Button)findViewById(R.id.btnMultiplicacao);

        btnCalcular.setOnClickListener(this);
        btnDivisao.setOnClickListener(this);
        btnMultiplicacao.setOnClickListener(this);
        btnSubtracao.setOnClickListener(this);
        btnAdicao.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {

        if (edtValor1.getText().toString().isEmpty() && edtValor2.getText().toString().isEmpty()){
            valor1 = 0;
            valor2 = 0;
        }else if (edtValor1.getText().toString().isEmpty() && !(edtValor2.getText().toString().isEmpty())){
            valor1 = 0;
            valor2 = Double.parseDouble(edtValor2.getText().toString());
        }else if (edtValor2.getText().toString().isEmpty() && !(edtValor1.getText().toString().isEmpty())){
            valor1 = Double.parseDouble(edtValor1.getText().toString());
            valor2 = 0;
        }else {
            valor1 = Double.parseDouble(edtValor1.getText().toString());
            valor2 = Double.parseDouble(edtValor2.getText().toString());
        }

        if (btnAdicao.isPressed()){
            resultado = valor1 + valor2;
        }if (btnSubtracao.isPressed()){
            resultado = valor1 - valor2;
        }if (btnMultiplicacao.isPressed()){
            resultado = valor1 * valor2;
        }if (btnDivisao.isPressed()){
            resultado = valor1 / valor2;
        }if (btnCalcular.isPressed()){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Resultado = " + resultado);
            dlg.setNeutralButton("Ok", null);
            dlg.show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
