package com.example.ruan.segundoexemplo;

import android.app.Activity;
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

public class MainActivity extends Activity { //Mudamos de AppCompatActivity para Activity

    private EditText edtNome;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Este método carrega a interface na memória

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //Recuperando as referencias dos objetos da interface
        this.edtNome = (EditText) findViewById(R.id.edtNome);
        this.btnOk = (Button) findViewById(R.id.btnOk);

        //Atribuindo evento ao botão ok
        btnOk.setOnClickListener(new View.OnClickListener() {
            //Método com o evento onClick implementado
            @Override
            public void onClick(View v) {
                //Exibirá uma mensagem
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); //No construtor desta classe é esperado
                //como parâmetro uma referência do Activity que está chamando esta classe em questão
                dlg.setMessage(edtNome.getText().toString());
                dlg.setNeutralButton("OK", null) ; //Permite adicionar um botão à sua caixa de mensagem
                    //-> Primeiro parâmetro define o rótulo do botão
                    //-> Segundo parâmetro permite executar um evento quando este botão for clicado
                dlg.show();


            }
        });
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
