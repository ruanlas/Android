package com.example.ruan.calculadora3;

import android.os.Bundle;
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

    private EditText edtValor1, edtValor2;
    private Button btnAdicao, btnSubtracao, btnMultiplicacao, btnDivisao;
    private double resultado = 0, valor1, valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        edtValor1 = (EditText)findViewById(R.id.edtValor1);
        edtValor2 = (EditText)findViewById(R.id.edtValor2);

        btnAdicao = (Button)findViewById(R.id.btnAdicao);
        btnDivisao = (Button)findViewById(R.id.btnDivisao);
        btnMultiplicacao = (Button)findViewById(R.id.btnMultiplicacao);
        btnSubtracao = (Button)findViewById(R.id.btnSubtracao);

        btnDivisao.setOnClickListener(this);
        btnMultiplicacao.setOnClickListener(this);
        btnSubtracao.setOnClickListener(this);
        btnAdicao.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (edtValor1.getText().toString().isEmpty()&& edtValor2.getText().toString().isEmpty()){
            this.setAmbosValoresNulo();
        }else if (edtValor1.getText().toString().isEmpty()&& !(edtValor2.getText().toString().isEmpty())){
            this.setValor1Nulo();
            this.setValor2Edt();
        }else if (!(edtValor1.getText().toString().isEmpty()) && edtValor2.getText().toString().isEmpty()){
            this.setValor1Edt();
            this.setValor2Nulo();
        }else{
            this.setValor1Edt();
            this.setValor2Edt();
        }

        if (btnAdicao.isPressed()){
            resultado = valor1 + valor2;
        }
        if (btnSubtracao.isPressed()){
            resultado = valor1 - valor2;
        }
        if (btnMultiplicacao.isPressed()){
            resultado = valor1 * valor2;
        }
        if (btnDivisao.isPressed()){
            resultado = valor1 / valor2;
        }
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("Resultado: " + resultado);
        dlg.setNeutralButton("OK", null);
        dlg.show();

        this.limpaCampos();
        this.setAmbosValoresNulo();
        this.resultado = 0;
    }

    private void limpaCampos(){
        edtValor1.getText().clear();
        edtValor2.getText().clear();
    }
    private void setValor1Edt(){
        this.valor1 = Double.parseDouble(edtValor1.getText().toString());
    }
    private void setValor2Edt(){
        this.valor2 = Double.parseDouble(edtValor2.getText().toString());
    }
    private void setValor1Nulo(){
        this.valor1 = 0;
    }
    private void setValor2Nulo(){
        this.valor2 = 0;
    }
    private void setAmbosValoresNulo(){
        this.setValor1Nulo();
        this.setValor2Nulo();
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
