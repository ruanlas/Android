package com.example.ruan.calculadora;

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

public class ActMain extends AppCompatActivity implements View.OnClickListener{
                                                //Interface 'View.OnClickListener' => Responsável por
                                                //implementar um método para disparar uma ação para o
                                                //botão

    private EditText edtValor1, edtValor2;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        edtValor1 = (EditText)findViewById(R.id.edtValor1);
        edtValor2 = (EditText)findViewById(R.id.edtValor2);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        //Registrando o evento (ação) para o botão
        btnCalcular.setOnClickListener(this);
        //Este método espera uma referência da Activity (Classe) que implementou o método onCLick da
        //Interface 'View.OnClickListener' (onde se tem acesso ao método onClick por polimorfismo);
        //ou espera-se que se crie um objeto anônimo da Interface View.OnClickListener que implemente
        //o método onClick

    }

    @Override
    public void onClick(View v) {
        //Metodo da interface View.OnClickListener responsável por atribuir uma ação ao botão

        String v1 = edtValor1.getText().toString();
        String v2 = edtValor2.getText().toString();

        //tratamento de campos em branco
        if(v1.trim().isEmpty() || v2.trim().isEmpty()){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Existem dados em branco");
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }else{

            double valor1 = Double.parseDouble(edtValor1.getText().toString());
            double valor2 = Double.parseDouble(edtValor2.getText().toString());

            double resultado = valor1 + valor2;

            //Apresentar o resultado para o usuário através de uma mensagem
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            //no contrutor desta classe 'AlertDialog.Builder' é passada a referencia do
            //Activity que exibirá a mensagem, que no caso, será esta Activity
            dlg.setMessage("O resultado da soma é: " + resultado);
            dlg.setNeutralButton("OK", null);
            // o metodo 'setNeutralButton(parametro1, parametro2)' espera receber dois parâmetros:
            // parametro1 => nome do botão
            // parametro2 => ação a ser disparada quando o botão for acionado
            // Neste ultimo parâmetro pode-se criar um evento, colocando um ouvinte de eventos para quando
            // o botão 'OK' for precionado executar uma determinada ação
            dlg.show();

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main, menu);
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
