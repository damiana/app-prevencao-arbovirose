package br.unifesp.prevencao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.unifesp.prevencao.R;

public class ResultadoSintomasActivity extends AppCompatActivity {

    private TextView txtMosquitoSuspeito;

    private TextView txtZika;
    private TextView txtChiku;
    private TextView txtDengue;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_quiz_sintomas);

        txtMosquitoSuspeito = (TextView) findViewById(R.id.txtMosquitoSuspeito);
        txtZika = (TextView) findViewById(R.id.txtZika);
        txtChiku = (TextView) findViewById(R.id.txtChiku);
        txtDengue = (TextView) findViewById(R.id.txtDengue);

        txtChiku.setVisibility(View.INVISIBLE);
        txtDengue.setVisibility(View.INVISIBLE);
        txtZika.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("mosquito")!= null) {
            String mosquito = bundle.getString("mosquito");

            if (mosquito.equalsIgnoreCase("Zika")) {
                txtChiku.setVisibility(View.INVISIBLE);
                txtDengue.setVisibility(View.INVISIBLE);
                txtZika.setVisibility(View.VISIBLE);

                txtMosquitoSuspeito.setText("Suspeita de: " + mosquito);
            }
            else if (mosquito.equalsIgnoreCase("Chikungunya")) {
                txtZika.setVisibility(View.INVISIBLE);
                txtDengue.setVisibility(View.INVISIBLE);
                txtChiku.setVisibility(View.VISIBLE);

                txtMosquitoSuspeito.setText("Suspeita de: " + mosquito);
            }
            else if (mosquito.equalsIgnoreCase("Dengue")) {
                txtZika.setVisibility(View.INVISIBLE);
                txtChiku.setVisibility(View.INVISIBLE);
                txtDengue.setVisibility(View.VISIBLE);

                txtMosquitoSuspeito.setText("Suspeita de: " + mosquito);
            }
        }

        mToolbar = (Toolbar) findViewById(R.id.toolbarResultadoSintomas);

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
        Intent intent = new Intent(ResultadoSintomasActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
