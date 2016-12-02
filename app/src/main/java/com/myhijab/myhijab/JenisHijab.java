package com.myhijab.myhijab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class JenisHijab extends AppCompatActivity {
    Button bergo, instan, jilbabmotif, pashmina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_hijab);

        //menginisiasi dan memanggil widget button pada file layout
        bergo = (Button) findViewById(R.id.bergo);
        instan = (Button) findViewById(R.id.instan);
        jilbabmotif = (Button) findViewById(R.id.jilbabmotif);
        pashmina = (Button) findViewById(R.id.pashmina);

        bergo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argO) {
                //TODO Auto-generated method stub
                Intent pindah1 = new Intent(JenisHijab.this, Bergo.class);
                startActivity(pindah1);
                //menghubungkan antar activity dengan inten
            }
        });

        instan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argO) {
                //TODO Auto-generated method stub
                Intent pindah2 = new Intent(JenisHijab.this, Instan.class);
                startActivity(pindah2);
                //menghubungkan antar activity dengan inten
            }
        });

        jilbabmotif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argO) {
                //TODO Auto-generated method stub
                Intent pindah3 = new Intent(JenisHijab.this, Jilbabmotif.class);
                startActivity(pindah3);
                //menghubungkan antar activity dengan inten
            }
        });

        pashmina.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View argO) {
                //TODO Auto-generated method stub
                Intent pindah3 = new Intent(JenisHijab.this, Pashmina.class);
                startActivity(pindah3);
                //menghubungkan antar activity dengan inten
            }
        });

    }
}


