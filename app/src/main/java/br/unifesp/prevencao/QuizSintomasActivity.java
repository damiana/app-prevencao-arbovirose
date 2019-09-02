package br.unifesp.prevencao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.unifesp.prevencao.R;

public class QuizSintomasActivity extends AppCompatActivity {

    private RadioGroup rgSintomas;

    //Sintomas
    private RadioGroup rgSintomasFebre;
    private RadioGroup rgSintomasDoresArticulacoes;
    private RadioGroup rgSintomasManchas;
    private RadioGroup rgSintomasCoceira;
    private RadioGroup rgSintomasVermelhidao;

    private RadioButton rbSintomasFebre;
    private RadioButton rbSintomasDoresArticulacoes;
    private RadioButton rbSintomasManchas;
    private RadioButton rbSintomasCoceira;
    private RadioButton rbSintomasVermelhidao;

    private Button btnQualMosquito;
    private int mosquitoZika = 0;
    private int mosquitoChiku = 0;
    private int mosquitoDengue = 0;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sintomas);

        rgSintomas = (RadioGroup) findViewById(R.id.rgSintomas);

        //febre
        rgSintomasFebre = (RadioGroup) findViewById(R.id.rgSintomasFebre);
        rgSintomasFebre.setVisibility(View.INVISIBLE);
        rbSintomasFebre = (RadioButton) findViewById(R.id.rbFebre);

        //dores nas articulacoes
        rgSintomasDoresArticulacoes = (RadioGroup) findViewById(R.id.rgSintomasDoresArticulacoes);
        rgSintomasDoresArticulacoes.setVisibility(View.INVISIBLE);
        rbSintomasDoresArticulacoes = (RadioButton) findViewById(R.id.rbDores);

        //manchas
        rgSintomasManchas = (RadioGroup) findViewById(R.id.rgSintomasManchas);
        rgSintomasManchas.setVisibility(View.INVISIBLE);
        rbSintomasManchas = (RadioButton) findViewById(R.id.rbManchas);

        //coceira
        rgSintomasCoceira = (RadioGroup) findViewById(R.id.rgSintomasCoceira);
        rgSintomasCoceira.setVisibility(View.INVISIBLE);
        rbSintomasCoceira = (RadioButton) findViewById(R.id.rbCoceira);

        //vermelhidao
        rgSintomasVermelhidao = (RadioGroup) findViewById(R.id.rgSintomasVermelhidao);
        rgSintomasVermelhidao.setVisibility(View.INVISIBLE);
        rbSintomasVermelhidao = (RadioButton) findViewById(R.id.rbVermelhidao);

        btnQualMosquito = (Button) findViewById(R.id.btnQualMosquito);

        addListenerSintomasClicked();

        btnQualMosquito.setOnClickListener(new View.OnClickListener() {
            String mosquito = "";
            @Override
            public void onClick(View v) {
                // Toast.makeText(SintomasActivity.this, "acao botton", Toast.LENGTH_SHORT).show();
                System.out.println("zica: " + mosquitoZika);
                System.out.println("chiku: " + mosquitoChiku);
                System.out.println("dengue: " + mosquitoDengue);

                if (mosquitoZika > mosquitoChiku || mosquitoZika > mosquitoDengue) {
                    //Toast.makeText(QuizSintomasActivity.this, "Suspeita de Zika", Toast.LENGTH_SHORT).show();
                    mosquito = "Zika";
                } else if (mosquitoChiku > mosquitoZika || mosquitoChiku > mosquitoDengue) {
                    //Toast.makeText(QuizSintomasActivity.this, "Suspeita de Chikungunya", Toast.LENGTH_SHORT).show();
                    mosquito = "Chikungunya";
                } else if (mosquitoDengue > mosquitoZika || mosquitoDengue > mosquitoChiku) {
                    //Toast.makeText(QuizSintomasActivity.this, "Suspeita de Dengue", Toast.LENGTH_SHORT).show();
                    mosquito = "Dengue";
                }

                Intent i = new Intent(QuizSintomasActivity.this, ResultadoSintomasActivity.class);
                i.putExtra("mosquito", mosquito);
                startActivity(i);
                finish();
            }
        });
    }

    public void addListenerSintomasClicked() {

        rgSintomas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);
                //String resposta = respostaSelecionada.getText().toString();

                if (respostaSelecionada.getId() == R.id.rbFebre) {
                    rgSintomas.setVisibility(View.INVISIBLE);
                    rgSintomasFebre.setVisibility(View.VISIBLE);
                }

                if (respostaSelecionada.getId() == R.id.rbDores) {
                    rgSintomas.setVisibility(View.INVISIBLE);
                    rgSintomasDoresArticulacoes.setVisibility(View.VISIBLE);
                }

                if (respostaSelecionada.getId() == R.id.rbManchas) {
                    rgSintomas.setVisibility(View.INVISIBLE);
                    rgSintomasManchas.setVisibility(View.VISIBLE);
                }

                if (respostaSelecionada.getId() == R.id.rbCoceira) {
                    rgSintomas.setVisibility(View.INVISIBLE);
                    rgSintomasCoceira.setVisibility(View.VISIBLE);
                }

                if (respostaSelecionada.getId() == R.id.rbVermelhidao) {
                    rgSintomas.setVisibility(View.INVISIBLE);
                    rgSintomasVermelhidao.setVisibility(View.VISIBLE);
                }
            }
        });

        rgSintomasFebre.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);
                //String resposta = respostaSelecionada.getText().toString();

                rgSintomasFebre.setVisibility(View.INVISIBLE);
                rgSintomas.setVisibility(View.VISIBLE);
                rbSintomasFebre.setEnabled(false);

                //Toast.makeText(SintomasActivity.this, resposta, Toast.LENGTH_SHORT).show();

                if (respostaSelecionada.getId() == R.id.rbFebreResposta1) {
                    mosquitoZika = mosquitoZika +1;
                }

                if (respostaSelecionada.getId() == R.id.rbFebreResposta2) {
                    mosquitoChiku = mosquitoChiku +1;
                }

                if (respostaSelecionada.getId() == R.id.rbFebreResposta3) {
                    mosquitoDengue = mosquitoDengue +1;
                }
            }
        });

        rgSintomasDoresArticulacoes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);
                // String resposta = respostaSelecionada.getText().toString();

//                if (respostaSelecionada.getId() == R.id.rbFebreResposta1) {
//
                rgSintomasDoresArticulacoes.setVisibility(View.INVISIBLE);
                rgSintomas.setVisibility(View.VISIBLE);
                rbSintomasDoresArticulacoes.setEnabled(false);
//
                //Toast.makeText(SintomasActivity.this, resposta, Toast.LENGTH_SHORT).show();
//                }

                if (respostaSelecionada.getId() == R.id.rbDoresResposta1) {
                    mosquitoZika = mosquitoZika +1;
                }

                if (respostaSelecionada.getId() == R.id.rbDoresResposta2) {
                    mosquitoChiku = mosquitoChiku +1;
                }

                if (respostaSelecionada.getId() == R.id.rbDoresResposta3) {
                    mosquitoDengue = mosquitoDengue +1;
                }
            }
        });

        rgSintomasManchas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);
                //String resposta = respostaSelecionada.getText().toString();

//                if (respostaSelecionada.getId() == R.id.rbFebreResposta1) {
//
                rgSintomasManchas.setVisibility(View.INVISIBLE);
                rgSintomas.setVisibility(View.VISIBLE);
                rbSintomasManchas.setEnabled(false);
//
                //Toast.makeText(SintomasActivity.this, resposta, Toast.LENGTH_SHORT).show();
//                }

                if (respostaSelecionada.getId() == R.id.rbManchasResposta1) {
                    mosquitoZika = mosquitoZika +1;
                }

                if (respostaSelecionada.getId() == R.id.rbManchasResposta2) {
                    mosquitoChiku = mosquitoChiku +1;
                }

                if (respostaSelecionada.getId() == R.id.rbManchasResposta3) {
                    mosquitoDengue = mosquitoDengue +1;
                }
            }
        });

        rgSintomasCoceira.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);
                //String resposta = respostaSelecionada.getText().toString();

//                if (respostaSelecionada.getId() == R.id.rbFebreResposta1) {
//
                rgSintomasCoceira.setVisibility(View.INVISIBLE);
                rgSintomas.setVisibility(View.VISIBLE);
                rbSintomasCoceira.setEnabled(false);
//
                //Toast.makeText(SintomasActivity.this, resposta, Toast.LENGTH_SHORT).show();
//                }

                if (respostaSelecionada.getId() == R.id.rbCoceiraResposta1) {
                    mosquitoZika = mosquitoZika +1;
                }

                if (respostaSelecionada.getId() == R.id.rbCoceiraResposta2) {
                    mosquitoChiku = mosquitoChiku +1;
                }

                if (respostaSelecionada.getId() == R.id.rbCoceiraResposta3) {
                    mosquitoDengue = mosquitoDengue +1;
                }
            }
        });

        rgSintomasVermelhidao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);
                //String resposta = respostaSelecionada.getText().toString();

//                if (respostaSelecionada.getId() == R.id.rbFebreResposta1) {
//
                rgSintomasVermelhidao.setVisibility(View.INVISIBLE);
                rgSintomas.setVisibility(View.VISIBLE);
                rbSintomasVermelhidao.setEnabled(false);
//
                //Toast.makeText(SintomasActivity.this, resposta, Toast.LENGTH_SHORT).show();
//                }

                if (respostaSelecionada.getId() == R.id.rbVermelhidaoResposta1) {
                    mosquitoZika = mosquitoZika +1;
                }

                if (respostaSelecionada.getId() == R.id.rbVermelhidaoResposta2) {
                    mosquitoChiku = mosquitoChiku +1;
                }

                if (respostaSelecionada.getId() == R.id.rbVermelhidaoResposta3) {
                    mosquitoDengue = mosquitoDengue +1;
                }
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbarQuizSintomas);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(QuizSintomasActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
