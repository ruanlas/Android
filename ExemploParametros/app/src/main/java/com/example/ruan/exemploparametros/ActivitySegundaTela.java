package com.example.ruan.exemploparametros;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivitySegundaTela extends AppCompatActivity implements View.OnClickListener{

    private Button btnFechar;
    private EditText edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        edtValor = (EditText)findViewById(R.id.edtValor);
        btnFechar = (Button)findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(this);

        //Para recuperar o conteúdo que foi passado da classe anterior utilizaremos a classe "Bundle"
        Bundle bundle = getIntent().getExtras();
        //Está pegando a referencia do Intent que foi passado como parâmetro que foi utilizado
        //na classe que chamou esta Activity, e está sendo recuperado um objeto do tipo Bundle (.getExtras())
        //O objeto Bundle irá conter todos os parâmetros que foram passados entre um Activity e outro

        if(bundle.containsKey("VALOR")){ //trecho que irá verificar se o parâmetro realmente foi passado, recebendo
            // como parâmetro do método o nome (id) do parâmetro/conteudo que foi passado
            String valor = bundle.getString("VALOR");
            //este trecho acima está recuperando o valor/conteúdo do parâmetro que foi passado da Activity anterior
            edtValor.setText(valor);
        }

    }

    @Override
    public void onClick(View v) {
        //comando para finalizar a tela
        finish();
    }
}
