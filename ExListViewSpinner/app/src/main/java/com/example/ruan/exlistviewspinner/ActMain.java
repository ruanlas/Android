package com.example.ruan.exlistviewspinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class ActMain extends AppCompatActivity implements View.OnClickListener{

    private EditText edtValor;
    private Spinner spnOpcoes;
    private Button btnAdicionar, btnExcluir;
    private ListView lstDados;
    //Para adicionarmos algumas informações/itens nos objetos do tipo 'Spinner' ou 'ListView'
    //para o usuário poder selecionar, devemos utilizar a classe 'ArrayAdapter', pois será somente
    //através desta classe que será possível armazenar informações nestes componentes mencionados
    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        edtValor = (EditText)findViewById(R.id.edtValor);
        spnOpcoes = (Spinner)findViewById(R.id.spnOpcoes);
        btnAdicionar = (Button)findViewById(R.id.btnAdicionar);
        btnExcluir = (Button)findViewById(R.id.btnExcluir);
        lstDados = (ListView)findViewById(R.id.lstDados);

        btnExcluir.setOnClickListener(this);
        btnAdicionar.setOnClickListener(this);

        //Instanciando os objetos do ArrayAdapter
        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        //Nos construtores do objeto 'ArrayAdapter', um dos primeiros parâmetros é do tipo 'Context',
        //onde ele pede uma referência de uma classe 'Context'. Já que o 'Activity' é filha da classe
        //'Context', iremos passar este activity como referência.
        //O segundo parâmetro é passado o layout que será utilizado para desenhar o componente visual
        //(Spinner ou ListView) -> forma como o componente será apresentado para o usuário
        //
        //Os componentes Spinner e o ListView funcionam como se estivesse sendo definido um outro layout
        //em específico para a exibição destes componentes, pois podemos customizar a exibição destes
        //componentes para o usuário
        //
        //  'Context' -> É utilizada para recuperar informações do seu sistema, do seu projeto, como
        //      por exemplo recuperar algumas informações que estão na pasta de recursos do projeto
        //      (pasta 'res'), como imagens, informações sobre o arquivo strings.xml, etc..
        //  'android.R.layout.simple_spinner_item' -> acessa a pasta de layouts padrão da plataforma
        //      android. Neste caso, acessamos o layout 'simple_spinner_item'. Este layout irá
        //      criar um Spinner e irá exibir apenas um valor por linha
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //o método acima define um outro layout de como o Spinner será exibido na tela ao ser clicado,
        //ou seja, o layout onde ficarão os itens do spinner

        //o trecho abaixo irá vincular o 'ArrayAdapter' ao spinner
        spnOpcoes.setAdapter(adpOpcoes);

        //Adicionando informações ao Spinner através do objeto 'ArrayAdapter'
        adpOpcoes.add("Opção 1");
        adpOpcoes.add("Opção 2");
        adpOpcoes.add("Opção 3");
        adpOpcoes.add("Opção 4");

        //Repetiremos o processo anterior para o ListView
        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
                                            // este layout vai exbir uma única linha para o listview


    }

    @Override
    public void onClick(View v) {

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
