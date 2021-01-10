package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela extends AppCompatActivity {
    private TextView text, text2, text3, text4, text5, text6, text7, text8, text9, text10, texto11, texto12, texto13;
    private TextView texto14, texto15, texto16, texto17, texto18,texto19,texto20,texto21,texto22,texto23,texto24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();
        Double valor1 = parametros.getDouble("valor1");
        Double valor2 = parametros.getDouble("valor2");
        Double valor3 = parametros.getDouble("valor3");
        Double valor4 = parametros.getDouble("valor4");
        Double valor5 = parametros.getDouble("valor5");
        Double valor6 = parametros.getDouble("valor6");

        String est = parametros.getString("Est");
        String cid = parametros.getString("Cid");
        String nomE = parametros.getString("NomE");
        String ano = parametros.getString("Ano");
        String perfE = parametros.getString("PerfE");
        String nome = parametros.getString("nome");
        String email = parametros.getString("email");
        String dtnascimento = parametros.getString("dtnascimento");
        String rg = parametros.getString("rg");
        String celular = parametros.getString("celular");
        String telefone = parametros.getString("telefone");
        String endereco = parametros.getString("endereco");
        String numero = parametros.getString("numero");
        String complemento = parametros.getString("complemento");
        String bairro = parametros.getString("bairro");
        String bairro_escola = parametros.getString("bairro_escola");
        String turma = parametros.getString("turma");
        String edt_soma = parametros.getString("edt_soma");

        text = (TextView) findViewById(R.id.text11);
        text2 = (TextView) findViewById(R.id.text12);
        text3 = (TextView) findViewById(R.id.text13);
        text4 = (TextView) findViewById(R.id.text14);
        text5 = (TextView) findViewById(R.id.text15);
        text6 = (TextView) findViewById(R.id.text16);
        text7 = (TextView) findViewById(R.id.text17);
        text8 = (TextView) findViewById(R.id.text18);
        text9 = (TextView) findViewById(R.id.text19);
        text10 = (TextView) findViewById(R.id.text20);
        texto11 = (TextView) findViewById(R.id.text21);
        texto12 = (TextView) findViewById(R.id.text22);
        texto13 = (TextView) findViewById(R.id.text23);
        texto14 = (TextView) findViewById(R.id.text24);
        texto15 = (TextView) findViewById(R.id.text25);
        texto16 = (TextView) findViewById(R.id.text26);
        texto17 = (TextView) findViewById(R.id.text27);
        texto18 = (TextView) findViewById(R.id.text28);
        texto19 = (TextView) findViewById(R.id.text29);
        texto20 = (TextView) findViewById(R.id.text30);
        texto21 = (TextView) findViewById(R.id.text31);
        texto22 = (TextView) findViewById(R.id.text32);
        texto23 = (TextView) findViewById(R.id.text33);
        texto24 = (TextView) findViewById(R.id.text34);

        text.setText("Nome:  " + nome);
        text2.setText("Email: " + email);
        text3.setText("Data de nascimento: " + dtnascimento);
        text4.setText("RG: " + rg);
        text5.setText("Celular: " + celular);
        text6.setText("Telefone: " + telefone);
        text7.setText("Endereco: " + endereco);
        text8.setText("Numero: " + numero);
        text9.setText("Complemento: " + complemento);
        text10.setText("Bairro: " + bairro);
        texto11.setText("Bairro escola: " + bairro_escola);
        texto12.setText("Turma: " + turma);
        texto13.setText("Soma: " + edt_soma);
        texto14.setText("Estado: " + est);
        texto15.setText("Cidade: " + cid);
        texto16.setText("Nome Escola: " + nomE);
        texto17.setText("Ano: " + ano);
        texto18.setText("Perfil da escola: " + perfE);
        texto19.setText("Realístico: " + valor1 +"%");
        texto20.setText("Investigativo: " + valor2 +"%");
        texto21.setText("Empreendedor: " + valor3 +"%");
        texto22.setText("Convencional: " + valor4 +"%");
        texto23.setText("Artístico: " + valor5 +"%");
        texto24.setText("Social: " + valor6 +"%");


    }
}