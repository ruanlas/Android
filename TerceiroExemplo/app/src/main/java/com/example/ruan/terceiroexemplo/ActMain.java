package com.example.ruan.terceiroexemplo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Ruan on 03/02/2017.
 */

public class ActMain extends Activity {

    //Método responsável por criar o activity (vincula o Activity (classe) à interface)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //O método abaixo vai carregar a interface e vai dizer que esta Activity está vinculada ao
        //layout act_main.xml
        setContentView(R.layout.act_main);

    }
}
