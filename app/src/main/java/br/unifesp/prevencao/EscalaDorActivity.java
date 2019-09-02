package br.unifesp.prevencao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.unifesp.prevencao.R;

public class EscalaDorActivity extends AppCompatActivity {

    private RadioGroup rgEscalaDor;
    private ImageView imgEscalaDesconforto;
    private ImageView imgEscalaAngustiante;
    private ImageView imgEscalaIntensa;

    private TextView txtConteudoEscala;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escala_dor);

        rgEscalaDor = (RadioGroup) findViewById(R.id.rgEscalaDor);
        imgEscalaDesconforto = (ImageView) findViewById(R.id.imgEscalaDesconforto);
        imgEscalaAngustiante = (ImageView) findViewById(R.id.imgEscalaAngustiante);
        imgEscalaIntensa = (ImageView) findViewById(R.id.imgEscalaIntensa);

        txtConteudoEscala = (TextView) findViewById(R.id.txtConteudoEscala);

        imgEscalaDesconforto.setVisibility(View.INVISIBLE);
        imgEscalaAngustiante.setVisibility(View.INVISIBLE);
        imgEscalaIntensa.setVisibility(View.INVISIBLE);

        rgEscalaDor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton respostaSelecionada = (RadioButton) group.findViewById(checkedId);

                if (respostaSelecionada.getId() == R.id.rbEntre0e2) {
                    txtConteudoEscala.setText("Desconforto");
                    imgEscalaDesconforto.setVisibility(View.VISIBLE);
                }

                if (respostaSelecionada.getId() == R.id.rbEntre3e7) {
                    txtConteudoEscala.setText("Angustiante");
                    imgEscalaAngustiante.setVisibility(View.VISIBLE);
                }

                if (respostaSelecionada.getId() == R.id.rbEntre8e10) {
                    txtConteudoEscala.setText("Intensa");
                    imgEscalaIntensa.setVisibility(View.VISIBLE);
                }
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbarEscala);

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
        Intent intent = new Intent(EscalaDorActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
