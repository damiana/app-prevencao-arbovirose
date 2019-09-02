package br.unifesp.prevencao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import br.unifesp.prevencao.R;

public class MainActivity extends AppCompatActivity {

    Button btnQuizSintomas = null;
    Button btnArbovirose = null;
    Button btnEscalaDor = null;
    Button btnOrientacao = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuizSintomas = (Button) findViewById(R.id.btnQuizSintomas);
        btnArbovirose = (Button) findViewById(R.id.btnArbovirose);
        btnEscalaDor = (Button) findViewById(R.id.btnEscalaDor);
        btnOrientacao = (Button) findViewById(R.id.btnOrientacao);

        btnQuizSintomas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuizSintomasActivity.class);
                startActivity(i);
                finish();
            }

        });
        btnArbovirose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ArboviroseActivity.class);
                startActivity(i);
                finish();
            }

        });

        btnEscalaDor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EscalaDorActivity.class);
                startActivity(i);
                finish();
            }

        });

        btnOrientacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OrientacaoAbasActivity.class);
                startActivity(i);
                finish();
            }

        });
    }
}
