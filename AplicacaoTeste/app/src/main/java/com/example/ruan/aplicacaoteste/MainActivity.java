package com.example.ruan.aplicacaoteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruan.models.Pessoa;

public class MainActivity extends AppCompatActivity {

    private Button btnConfirmar;

    private EditText txtNome, txtRg, txtCpf;

    private TextView txtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirmar = (Button)findViewById(R.id.btnConfirmar);
        txtNome = (EditText)findViewById(R.id.txtNome);
        txtCpf = (EditText)findViewById(R.id.txtCpf);
        txtRg = (EditText)findViewById(R.id.txtRg);
        txtMensagem = (TextView)findViewById(R.id.txtMensagem);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(txtNome.getText().toString());
                pessoa.setRg(txtRg.getText().toString());
                pessoa.setCpf(txtCpf.getText().toString());

                txtMensagem.setText("Mensagem: " + pessoa.getNome());
            }
        });
    }
}
