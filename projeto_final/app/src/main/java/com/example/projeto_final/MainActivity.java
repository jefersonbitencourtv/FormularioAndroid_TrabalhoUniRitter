package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText nome, email, dtnascimento, rg, celular, telefone, endereco, numero, complemento, bairro, bairro_escola, turma, edt_soma;
    private Double valor1 , valor2 , valor3 , valor4 , valor5 , valor6 ;
    private Spinner spinner, spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11, spinner12, spinner13, spinner14, spinner15, spinner16;
    private Spinner spinner17, spinner18, spinner19, spinner20, spinner21, spinner22, spinner23, spinner24, spinner25, spinner26, spinner27, spinner28, spinner29, spinner30, spinner31;
    private Spinner spinner32, spinner33, spinner34, spinner35, spinner36, spinner37, spinner38, spinner39, spinner40, spinner41, spinner42, spinner43, spinner44, spinner45, spinner46, spinner47;
    private Spinner spinner48, spinner49, spinner50, spinner51, spinner52, spinner53, spinner54, spinner55, spinner56, spinner57, spinner58, spinner59, spinner60, spinner61, spinner62;
    private Spinner spinner63, spinner64;
    private String Est, Cid, NomE, Ano, PerfE;
    private Button btn_enviar;

    private static String URL_REGIST = "http://192.168.0.23/android/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.edt_nome);
        email = findViewById(R.id.edt_email);
        dtnascimento = findViewById(R.id.edt_dtnascimento);
        rg = findViewById(R.id.edt_rg);
        celular = findViewById(R.id.edt_celular);
        telefone = findViewById(R.id.edt_telefone);
        endereco = findViewById(R.id.edt_endereco);
        numero = findViewById(R.id.edt_numero);
        complemento = findViewById(R.id.edt_complemento);
        bairro = findViewById(R.id.edt_bairro);
        bairro_escola = findViewById(R.id.edt_bairro_escola);
        turma = findViewById(R.id.edt_turma);
        edt_soma = findViewById(R.id.edt_soma);


        spinner = findViewById(R.id.estado);
        spinner1 = findViewById(R.id.ano_escola);
        spinner2 = findViewById(R.id.perfil_escola);
        spinner3 = findViewById(R.id.autentico);
        spinner4 = findViewById(R.id.timido);
        spinner5 = findViewById(R.id.intelectual);
        spinner6 = findViewById(R.id.persistente);
        spinner7 = findViewById(R.id.pessoas);
        spinner8 = findViewById(R.id.trabalhar);
        spinner9 = findViewById(R.id.aguentar);
        spinner10 = findViewById(R.id.dinheiro);
        spinner11 = findViewById(R.id.instrumentos);
        spinner12 = findViewById(R.id.aceito);
        spinner13 = findViewById(R.id.gosto);
        spinner14 = findViewById(R.id.impulsivo);
        spinner15 = findViewById(R.id.areas);
        spinner16 = findViewById(R.id.aprender);
        spinner17 = findViewById(R.id.racional);
        spinner18 = findViewById(R.id.organizado);
        spinner19 = findViewById(R.id.capaz);
        spinner20 = findViewById(R.id.senso);
        spinner21 = findViewById(R.id.decisoes);
        spinner22 = findViewById(R.id.habilidade);
        spinner23 = findViewById(R.id.aceitar);
        spinner24 = findViewById(R.id.viver);
        spinner25 = findViewById(R.id.sensivel);
        spinner26 = findViewById(R.id.idealista);
        spinner27 = findViewById(R.id.criar);
        spinner28 = findViewById(R.id.causar);
        spinner29 = findViewById(R.id.descobrir);
        spinner30 = findViewById(R.id.penso);
        spinner31 = findViewById(R.id.expressar);
        spinner32 = findViewById(R.id.atitudes);
        spinner33 = findViewById(R.id.liderar);
        spinner34 = findViewById(R.id.colaborar);
        spinner35 = findViewById(R.id.sensibilidade);
        spinner36 = findViewById(R.id.agradavel);
        spinner37 = findViewById(R.id.vida);
        spinner38 = findViewById(R.id.eticas);
        spinner39 = findViewById(R.id.responsavel);
        spinner40 = findViewById(R.id.dedicar);
        spinner41 = findViewById(R.id.relaciono);
        spinner42 = findViewById(R.id.ensinar);
        spinner43 = findViewById(R.id.firme);
        spinner44 = findViewById(R.id.convencer);
        spinner45 = findViewById(R.id.motivada);
        spinner46 = findViewById(R.id.desisto);
        spinner47 = findViewById(R.id.bens);
        spinner48 = findViewById(R.id.rapidamente);
        spinner49 = findViewById(R.id.especialmente);
        spinner50 = findViewById(R.id.aventuras);
        spinner51 = findViewById(R.id.oportunidades);
        spinner52 = findViewById(R.id.prefiro);
        spinner53 = findViewById(R.id.regras);
        spinner54 = findViewById(R.id.introvertido);
        spinner55 = findViewById(R.id.cuido);
        spinner56 = findViewById(R.id.calmo);
        spinner57 = findViewById(R.id.plano);
        spinner58 = findViewById(R.id.estavel);
        spinner59 = findViewById(R.id.respeito);
        spinner60 = findViewById(R.id.detalhista);
        spinner61 = findViewById(R.id.objetivos);
        spinner62 = findViewById(R.id.satisfazer);
        spinner63 = findViewById(R.id.nome_cidade);
        spinner64 = findViewById(R.id.nome_escola);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.estado, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.ano_escola, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.perfil_escola, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.autentico, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.timido, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.intelectual, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.persistente, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner6.setAdapter(adapter6);
        spinner6.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.pessoas, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner7.setAdapter(adapter7);
        spinner7.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.trabalhar, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner8.setAdapter(adapter8);
        spinner8.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.aguentar, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner9.setAdapter(adapter9);
        spinner9.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.dinheiro, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner10.setAdapter(adapter10);
        spinner10.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.instrumentos, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner11.setAdapter(adapter11);
        spinner11.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.aceito, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner12.setAdapter(adapter12);
        spinner12.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.gosto, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner13.setAdapter(adapter13);
        spinner13.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.impulsivo, android.R.layout.simple_spinner_item);
        adapter14.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner14.setAdapter(adapter14);
        spinner14.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.areas, android.R.layout.simple_spinner_item);
        adapter15.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner15.setAdapter(adapter15);
        spinner15.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.aprender, android.R.layout.simple_spinner_item);
        adapter16.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner16.setAdapter(adapter16);
        spinner16.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.racional, android.R.layout.simple_spinner_item);
        adapter17.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner17.setAdapter(adapter17);
        spinner17.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.organizado, android.R.layout.simple_spinner_item);
        adapter18.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner18.setAdapter(adapter18);
        spinner18.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.capaz, android.R.layout.simple_spinner_item);
        adapter19.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner19.setAdapter(adapter19);
        spinner19.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(this, R.array.senso, android.R.layout.simple_spinner_item);
        adapter20.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner20.setAdapter(adapter20);
        spinner20.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(this, R.array.decisoes, android.R.layout.simple_spinner_item);
        adapter21.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner21.setAdapter(adapter21);
        spinner21.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(this, R.array.habilidade, android.R.layout.simple_spinner_item);
        adapter22.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner22.setAdapter(adapter22);
        spinner22.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(this, R.array.aceitar, android.R.layout.simple_spinner_item);
        adapter23.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner23.setAdapter(adapter23);
        spinner23.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(this, R.array.viver, android.R.layout.simple_spinner_item);
        adapter24.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner24.setAdapter(adapter24);
        spinner24.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter25 = ArrayAdapter.createFromResource(this, R.array.sensivel, android.R.layout.simple_spinner_item);
        adapter25.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner25.setAdapter(adapter25);
        spinner25.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter26 = ArrayAdapter.createFromResource(this, R.array.idealista, android.R.layout.simple_spinner_item);
        adapter26.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner26.setAdapter(adapter26);
        spinner26.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter27 = ArrayAdapter.createFromResource(this, R.array.criar, android.R.layout.simple_spinner_item);
        adapter27.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner27.setAdapter(adapter27);
        spinner27.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter28 = ArrayAdapter.createFromResource(this, R.array.causar, android.R.layout.simple_spinner_item);
        adapter28.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner28.setAdapter(adapter28);
        spinner28.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter29 = ArrayAdapter.createFromResource(this, R.array.descobrir, android.R.layout.simple_spinner_item);
        adapter29.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner29.setAdapter(adapter29);
        spinner29.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter30 = ArrayAdapter.createFromResource(this, R.array.penso, android.R.layout.simple_spinner_item);
        adapter30.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner30.setAdapter(adapter30);
        spinner30.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter31 = ArrayAdapter.createFromResource(this, R.array.expressar, android.R.layout.simple_spinner_item);
        adapter31.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner31.setAdapter(adapter31);
        spinner31.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter32 = ArrayAdapter.createFromResource(this, R.array.atitudes, android.R.layout.simple_spinner_item);
        adapter32.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner32.setAdapter(adapter32);
        spinner32.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter33 = ArrayAdapter.createFromResource(this, R.array.liderar, android.R.layout.simple_spinner_item);
        adapter33.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner33.setAdapter(adapter33);
        spinner33.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter34 = ArrayAdapter.createFromResource(this, R.array.colaborar, android.R.layout.simple_spinner_item);
        adapter34.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner34.setAdapter(adapter34);
        spinner34.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter35 = ArrayAdapter.createFromResource(this, R.array.sensibilidade, android.R.layout.simple_spinner_item);
        adapter35.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner35.setAdapter(adapter35);
        spinner35.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter36 = ArrayAdapter.createFromResource(this, R.array.agradavel, android.R.layout.simple_spinner_item);
        adapter36.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner36.setAdapter(adapter36);
        spinner36.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter37 = ArrayAdapter.createFromResource(this, R.array.vida, android.R.layout.simple_spinner_item);
        adapter37.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner37.setAdapter(adapter37);
        spinner37.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter38 = ArrayAdapter.createFromResource(this, R.array.eticas, android.R.layout.simple_spinner_item);
        adapter38.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner38.setAdapter(adapter38);
        spinner38.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter39 = ArrayAdapter.createFromResource(this, R.array.responsavel, android.R.layout.simple_spinner_item);
        adapter39.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner39.setAdapter(adapter39);
        spinner39.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter40 = ArrayAdapter.createFromResource(this, R.array.dedicar, android.R.layout.simple_spinner_item);
        adapter40.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner40.setAdapter(adapter40);
        spinner40.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter41 = ArrayAdapter.createFromResource(this, R.array.relaciono, android.R.layout.simple_spinner_item);
        adapter41.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner41.setAdapter(adapter41);
        spinner41.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter42 = ArrayAdapter.createFromResource(this, R.array.ensinar, android.R.layout.simple_spinner_item);
        adapter42.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner42.setAdapter(adapter42);
        spinner42.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter43 = ArrayAdapter.createFromResource(this, R.array.firme, android.R.layout.simple_spinner_item);
        adapter43.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner43.setAdapter(adapter43);
        spinner43.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter44 = ArrayAdapter.createFromResource(this, R.array.convencer, android.R.layout.simple_spinner_item);
        adapter44.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner44.setAdapter(adapter44);
        spinner44.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter45 = ArrayAdapter.createFromResource(this, R.array.motivada, android.R.layout.simple_spinner_item);
        adapter45.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner45.setAdapter(adapter45);
        spinner45.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter46 = ArrayAdapter.createFromResource(this, R.array.desisto, android.R.layout.simple_spinner_item);
        adapter46.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner46.setAdapter(adapter46);
        spinner46.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter47 = ArrayAdapter.createFromResource(this, R.array.bens, android.R.layout.simple_spinner_item);
        adapter47.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner47.setAdapter(adapter47);
        spinner47.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter48 = ArrayAdapter.createFromResource(this, R.array.rapidamente, android.R.layout.simple_spinner_item);
        adapter48.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner48.setAdapter(adapter48);
        spinner48.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter49 = ArrayAdapter.createFromResource(this, R.array.especialmente, android.R.layout.simple_spinner_item);
        adapter49.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner49.setAdapter(adapter49);
        spinner49.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter50 = ArrayAdapter.createFromResource(this, R.array.aventuras, android.R.layout.simple_spinner_item);
        adapter50.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner50.setAdapter(adapter50);
        spinner50.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter51 = ArrayAdapter.createFromResource(this, R.array.oportunidades, android.R.layout.simple_spinner_item);
        adapter51.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner51.setAdapter(adapter51);
        spinner51.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter52 = ArrayAdapter.createFromResource(this, R.array.prefiro, android.R.layout.simple_spinner_item);
        adapter52.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner52.setAdapter(adapter52);
        spinner52.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter53 = ArrayAdapter.createFromResource(this, R.array.regras, android.R.layout.simple_spinner_item);
        adapter53.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner53.setAdapter(adapter53);
        spinner53.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter54 = ArrayAdapter.createFromResource(this, R.array.introvertido, android.R.layout.simple_spinner_item);
        adapter54.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner54.setAdapter(adapter54);
        spinner54.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter55 = ArrayAdapter.createFromResource(this, R.array.cuido, android.R.layout.simple_spinner_item);
        adapter55.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner55.setAdapter(adapter55);
        spinner55.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter56 = ArrayAdapter.createFromResource(this, R.array.calmo, android.R.layout.simple_spinner_item);
        adapter56.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner56.setAdapter(adapter56);
        spinner56.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter57 = ArrayAdapter.createFromResource(this, R.array.plano, android.R.layout.simple_spinner_item);
        adapter57.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner57.setAdapter(adapter57);
        spinner57.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter58 = ArrayAdapter.createFromResource(this, R.array.estavel, android.R.layout.simple_spinner_item);
        adapter58.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner58.setAdapter(adapter58);
        spinner58.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter59 = ArrayAdapter.createFromResource(this, R.array.respeito, android.R.layout.simple_spinner_item);
        adapter59.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner59.setAdapter(adapter59);
        spinner59.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter60 = ArrayAdapter.createFromResource(this, R.array.detalhista, android.R.layout.simple_spinner_item);
        adapter60.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner60.setAdapter(adapter60);
        spinner60.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter61 = ArrayAdapter.createFromResource(this, R.array.objetivos, android.R.layout.simple_spinner_item);
        adapter61.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner61.setAdapter(adapter61);
        spinner61.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter62 = ArrayAdapter.createFromResource(this, R.array.satisfazer, android.R.layout.simple_spinner_item);
        adapter62.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner62.setAdapter(adapter62);
        spinner62.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter63 = ArrayAdapter.createFromResource(this, R.array.nome_cidade, android.R.layout.simple_spinner_item);
        adapter63.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner63.setAdapter(adapter63);
        spinner63.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter64 = ArrayAdapter.createFromResource(this, R.array.nome_escola, android.R.layout.simple_spinner_item);
        adapter64.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner64.setAdapter(adapter64);
        spinner64.setOnItemSelectedListener(this);
    }

    private boolean isEmpty(EditText etText) {
        String text = etText.getText().toString();
        if (text.length() < 1)
            return true;
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void enviarDados(View view) {

        if (isEmpty(nome) == true) {

            Toast.makeText(MainActivity.this, "Nome obrigatorio", Toast.LENGTH_LONG).show();
        } else if (isEmpty(email) == true) {
            Toast.makeText(MainActivity.this, "Email obrigatorio", Toast.LENGTH_LONG).show();
        }
        else if (dtnascimento.length() < 10) {
            Toast.makeText(MainActivity.this, "Preencha toda a data", Toast.LENGTH_LONG).show();
        } else {
            DecimalFormat formato = new DecimalFormat("#.##");
            Intent intent = new Intent(getApplicationContext(), Tela.class);
            Bundle parametros = new Bundle();
            valor1 = 0.0;
            valor2 = 0.0;
            valor3 = 0.0;
            valor4 = 0.0;
            valor5 = 0.0;
            valor6 = 0.0;
            if (spinner3.getSelectedItemPosition() >= 1) {
                valor1 += (spinner3.getSelectedItemPosition() - 1);
            }
            if (spinner4.getSelectedItemPosition() >= 1) {
                valor1 += (spinner4.getSelectedItemPosition() - 1);
            }
            if (spinner5.getSelectedItemPosition() >= 1) {
                valor1 += (spinner5.getSelectedItemPosition() - 1);
            }
            if (spinner6.getSelectedItemPosition() >= 1) {
                valor1 += (spinner6.getSelectedItemPosition() - 1);
            }
            if (spinner7.getSelectedItemPosition() >= 1) {
                valor1 += (spinner7.getSelectedItemPosition() - 1);
            }
            if (spinner8.getSelectedItemPosition() >= 1) {
                valor1 += (spinner8.getSelectedItemPosition() - 1);
            }
            if (spinner9.getSelectedItemPosition() >= 1) {
                valor1 += (spinner9.getSelectedItemPosition() - 1);
            }
            if (spinner10.getSelectedItemPosition() >= 1) {
                valor1 +=  (spinner10.getSelectedItemPosition() - 1);
            }
            if (spinner11.getSelectedItemPosition() >= 1) {
                valor1 +=(spinner11.getSelectedItemPosition() - 1);
            }
            if (spinner12.getSelectedItemPosition() >= 1) {
                valor1 +=(spinner12.getSelectedItemPosition() - 1);
            }

            valor1 = valor1 * 100 / 30;
            valor1 = Double.valueOf(formato.format(valor1));


            if (spinner13.getSelectedItemPosition() >= 1) {
                valor2 += spinner13.getSelectedItemPosition() - 1;
            }
            if (spinner14.getSelectedItemPosition() >= 1) {
                valor2 += spinner14.getSelectedItemPosition() - 1;
            }
            if (spinner15.getSelectedItemPosition() >= 1) {
                valor2 += spinner15.getSelectedItemPosition() - 1;
            }
            if (spinner16.getSelectedItemPosition() >= 1) {
                valor2 += spinner16.getSelectedItemPosition() - 1;
            }
            if (spinner17.getSelectedItemPosition() >= 1) {
                valor2 += spinner17.getSelectedItemPosition() - 1;
            }
            if (spinner18.getSelectedItemPosition() >= 1) {
                valor2 += spinner18.getSelectedItemPosition() - 1;
            }
            if (spinner19.getSelectedItemPosition() >= 1) {
                valor2 += spinner19.getSelectedItemPosition() - 1;
            }
            if (spinner20.getSelectedItemPosition() >= 1) {
                valor2 += spinner20.getSelectedItemPosition() - 1;
            }
            if (spinner21.getSelectedItemPosition() >= 1) {
                valor2 += spinner21.getSelectedItemPosition() - 1;
            }
            if (spinner22.getSelectedItemPosition() >= 1) {
                valor2 += spinner22.getSelectedItemPosition() - 1;
            }
            valor2 = valor2 / 30 * 100;
            valor2 = Double.valueOf(formato.format(valor2));

            if (spinner23.getSelectedItemPosition() >= 1) {
                valor3 += spinner23.getSelectedItemPosition() - 1;
            }
            if (spinner24.getSelectedItemPosition() >= 1) {
                valor3 += spinner24.getSelectedItemPosition() - 1;
            }
            if (spinner25.getSelectedItemPosition() >= 1) {
                valor3 += spinner25.getSelectedItemPosition() - 1;
            }
            if (spinner26.getSelectedItemPosition() >= 1) {
                valor3 += spinner26.getSelectedItemPosition() - 1;
            }
            if (spinner27.getSelectedItemPosition() >= 1) {
                valor3 += spinner27.getSelectedItemPosition() - 1;
            }
            if (spinner28.getSelectedItemPosition() >= 1) {
                valor3 += spinner28.getSelectedItemPosition() - 1;
            }
            if (spinner29.getSelectedItemPosition() >= 1) {
                valor3 += spinner29.getSelectedItemPosition() - 1;
            }
            if (spinner30.getSelectedItemPosition() >= 1) {
                valor3 += spinner30.getSelectedItemPosition() - 1;
            }
            if (spinner31.getSelectedItemPosition() >= 1) {
                valor3 += spinner31.getSelectedItemPosition() - 1;
            }
            if (spinner32.getSelectedItemPosition() >= 1) {
                valor3 += spinner32.getSelectedItemPosition() - 1;
            }
            valor3 = valor3 / 30 * 100;
            valor3 = Double.valueOf(formato.format(valor3));


            if (spinner33.getSelectedItemPosition() >= 1) {
                valor4 += spinner33.getSelectedItemPosition() - 1;
            }
            if (spinner34.getSelectedItemPosition() >= 1) {
                valor4 += spinner34.getSelectedItemPosition() - 1;
            }
            if (spinner35.getSelectedItemPosition() >= 1) {
                valor4 += spinner35.getSelectedItemPosition() - 1;
            }
            if (spinner36.getSelectedItemPosition() >= 1) {
                valor4 += spinner36.getSelectedItemPosition() - 1;
            }
            if (spinner37.getSelectedItemPosition() >= 1) {
                valor4 += spinner37.getSelectedItemPosition() - 1;
            }
            if (spinner38.getSelectedItemPosition() >= 1) {
                valor4 += spinner38.getSelectedItemPosition() - 1;
            }
            if (spinner39.getSelectedItemPosition() >= 1) {
                valor4 += spinner39.getSelectedItemPosition() - 1;
            }
            if (spinner40.getSelectedItemPosition() >= 1) {
                valor4 += spinner40.getSelectedItemPosition() - 1;
            }
            if (spinner41.getSelectedItemPosition() >= 1) {
                valor4 += spinner41.getSelectedItemPosition() - 1;
            }
            if (spinner42.getSelectedItemPosition() >= 1) {
                valor4 += spinner42.getSelectedItemPosition() - 1;
            }
            valor4 = valor4 / 30 * 100;
            valor4 = Double.valueOf(formato.format(valor4));

            if (spinner43.getSelectedItemPosition() >= 1) {
                valor5 += spinner43.getSelectedItemPosition() - 1;
            }
            if (spinner44.getSelectedItemPosition() >= 1) {
                valor5 += spinner44.getSelectedItemPosition() - 1;
            }
            if (spinner45.getSelectedItemPosition() >= 1) {
                valor5 += spinner45.getSelectedItemPosition() - 1;
            }
            if(spinner46.getSelectedItemPosition() >= 1) {
                valor5 += spinner46.getSelectedItemPosition() - 1;
            }
            if(spinner47.getSelectedItemPosition() >= 1) {
                valor5 += spinner47.getSelectedItemPosition() - 1;
            }
            if(spinner48.getSelectedItemPosition() >= 1) {
                valor5 += spinner48.getSelectedItemPosition() - 1;
            }
            if(spinner49.getSelectedItemPosition() >= 1) {
                valor5 += spinner49.getSelectedItemPosition() - 1;
            }
            if(spinner50.getSelectedItemPosition() >= 1) {
                valor5 += spinner50.getSelectedItemPosition() - 1;
            }
            if(spinner51.getSelectedItemPosition() >= 1) {
                valor5 += spinner51.getSelectedItemPosition() - 1;
            }
            if(spinner52.getSelectedItemPosition() >= 1) {
                valor5 += spinner52.getSelectedItemPosition() - 1;
            }
            valor5 = valor5 / 30 * 100;
            valor5 = Double.valueOf(formato.format(valor5));

            if(spinner53.getSelectedItemPosition() >= 1) {
                valor6 += spinner53.getSelectedItemPosition() - 1;
            }
            if(spinner54.getSelectedItemPosition() >= 1) {
                valor6 += spinner54.getSelectedItemPosition() - 1;
            }
            if(spinner55.getSelectedItemPosition() >= 1) {
                valor6 += spinner55.getSelectedItemPosition() - 1;
            }
            if(spinner56.getSelectedItemPosition() >= 1) {
                valor6 += spinner56.getSelectedItemPosition() - 1;
            }
            if(spinner57.getSelectedItemPosition() >= 1) {
                valor6 += spinner57.getSelectedItemPosition() - 1;
            }
            if(spinner58.getSelectedItemPosition() >= 1) {
                valor6 += spinner58.getSelectedItemPosition() - 1;
            }
            if(spinner59.getSelectedItemPosition() >= 1) {
                valor6 += spinner59.getSelectedItemPosition() - 1;
            }
            if(spinner60.getSelectedItemPosition() >= 1) {
                valor6 += spinner60.getSelectedItemPosition() - 1;
            }
            if(spinner61.getSelectedItemPosition() >= 1) {
                valor6 += spinner61.getSelectedItemPosition() - 1;
            }
            if(spinner62.getSelectedItemPosition() >= 1) {
                valor6 += spinner62.getSelectedItemPosition() - 1;
            }
            valor6 = valor6 / 30 * 100;
            valor6 = Double.valueOf(formato.format(valor6));

            int b = spinner.getSelectedItemPosition();
            Est = spinner.getItemAtPosition(b).toString();
            int c = spinner63.getSelectedItemPosition();
            Cid = spinner63.getItemAtPosition(c).toString();
            int d = spinner64.getSelectedItemPosition();
            NomE = spinner64.getItemAtPosition(d).toString();
            int e = spinner1.getSelectedItemPosition();
            Ano = spinner1.getItemAtPosition(e).toString();
            int f = spinner2.getSelectedItemPosition();
            PerfE = spinner2.getItemAtPosition(f).toString();


            String nome1 = nome.getText().toString();
            String email1 = email.getText().toString();
            String dtnascimento1 = dtnascimento.getText().toString();
            String rg1 = rg.getText().toString();
            String celular1 = celular.getText().toString();
            String telefone1 = telefone.getText().toString();
            String endereco1 = endereco.getText().toString();
            String numero1 = numero.getText().toString();
            String complemento1 = complemento.getText().toString();
            String bairro1 = bairro.getText().toString();
            String bairro_escola1 = bairro_escola.getText().toString();
            String turma1 = turma.getText().toString();
            String edt_soma1 = edt_soma.getText().toString();

            parametros.putString("Est", Est);
            parametros.putString("Cid", Cid);
            parametros.putString("NomE", NomE);
            parametros.putString("Ano", Ano);
            parametros.putString("PerfE", PerfE);
            parametros.putDouble("valor1", valor1);
            parametros.putDouble("valor2", valor2);
            parametros.putDouble("valor3", valor3);
            parametros.putDouble("valor4", valor4);
            parametros.putDouble("valor5", valor5);
            parametros.putDouble("valor6", valor6);

            parametros.putString("nome", nome1);
            parametros.putString("email", email1);
            parametros.putString("dtnascimento", dtnascimento1);
            parametros.putString("rg", rg1);
            parametros.putString("celular", celular1);
            parametros.putString("telefone", telefone1);
            parametros.putString("endereco", endereco1);
            parametros.putString("numero", numero1);
            parametros.putString("complemento", complemento1);
            parametros.putString("bairro", bairro1);
            parametros.putString("bairro_escola", bairro_escola1);
            parametros.putString("turma", turma1);
            parametros.putString("edt_soma", edt_soma1);
            Regist();
            intent.putExtras(parametros);
            startActivity(intent);
        }

    }

    private void Regist() {
        int b = spinner.getSelectedItemPosition();
        Est = spinner.getItemAtPosition(b).toString();
        int c = spinner63.getSelectedItemPosition();
        Cid = spinner63.getItemAtPosition(c).toString();
        int d = spinner64.getSelectedItemPosition();
        NomE = spinner64.getItemAtPosition(d).toString();
        int e = spinner1.getSelectedItemPosition();
        Ano = spinner1.getItemAtPosition(e).toString();
        int f = spinner2.getSelectedItemPosition();
        PerfE = spinner2.getItemAtPosition(f).toString();

        final String var_nome = this.nome.getText().toString();
        final String var_email = this.email.getText().toString();
        final String dtnascimento1 = this.dtnascimento.getText().toString();
        final String rg1 = this.rg.getText().toString();
        final String celular1 = this.celular.getText().toString();
        final String telefone1 = this.telefone.getText().toString();
        final String endereco1 = this.endereco.getText().toString();
        final String estado1 = this.Est;
        final String cidade1 = this.Cid;
        final String ano1 = this.Ano;
        final String nomeescola1 = this.NomE;
        final String perfilescola1 = this.PerfE;
        final String numero1 = this.numero.getText().toString();
        final String complemento1 = this.complemento.getText().toString();
        final String bairro1 = this.bairro.getText().toString();

        final String bairro_escola1 = this.bairro_escola.getText().toString();
        final String turma1 = this.turma.getText().toString();
        final String edt_soma1 = this.edt_soma.getText().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this, "Feito", Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "Erro" + e.getMessage(), Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Voley ERROR: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nome", var_nome);
                params.put("email", var_email);
                params.put("datanascimento", dtnascimento1);
                params.put("identidade", rg1);
                params.put("celular", celular1);
                params.put("telefone", telefone1);
                params.put("endereco", endereco1);
                params.put("numero", numero1);
                params.put("complemento", complemento1);
                params.put("bairro", bairro1);
                params.put("estado", estado1);
                params.put("cidade", cidade1);
                params.put("nome_escola", nomeescola1);
                params.put("bairro_escola", bairro_escola1);
                params.put("ano", ano1);
                params.put("turma", turma1);
                params.put("perfil_escola", perfilescola1);
                params.put("realistico", valor1.toString());
                params.put("investigativo", valor2.toString());
                params.put("empreendedor", valor3.toString());
                params.put("convencional", valor4.toString());
                params.put("artistico", valor5.toString());
                params.put("social", valor6.toString());

                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}


