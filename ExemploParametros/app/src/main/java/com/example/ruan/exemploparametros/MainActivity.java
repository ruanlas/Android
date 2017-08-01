package com.example.ruan.exemploparametros;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnOk;
    private EditText edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        edtValor = (EditText)findViewById(R.id.edtValor);
        btnOk = (Button)findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Classe responsável por "chamar outra tela" -> Intent
        //A classe Intent é muito importante para o desenvolvimento de app
        //Esta classe pode ser utilizada para outras finalidades, como executar um recurso do android
        //que poderia ser um comando de voz
        //Neste caso ela será usado para a 'intenção' de chamar outra tela

        Intent it = new Intent(this, ActivitySegundaTela.class);
        //no construtor desta classe é esperado dois parâmetros:
        // - O primeiro parâmetro é a referência da classe que irá chamar outra tela;
        // - O segundo parâmetro é a referência da Activity que será chamada
        // (a classe que será chamada para carregar a segunda tela)


        it.putExtra("VALOR", edtValor.getText().toString());
        //este método faz a passagem de parâmetros (valores) para a Activity que será chamada
        //é esperado dois valores como parâmetro do método:
        // - o primeiro parâmetro é o nome do valor/parâmetro (id), que será utilizado na outra Activity
        // que será chamada para recuperar este conteúdo que foi passado
        // - o segundo parâmetro é o próprio valor que será passado (o conteúdo)

        startActivity(it); //metódo que faz a chamada do activity, que espera como parâmetro
        // o objeto da classe Intent
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
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
