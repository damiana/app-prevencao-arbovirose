package br.unifesp.prevencao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import br.unifesp.prevencao.R;

public class ArboviroseActivity extends AppCompatActivity {

    Toolbar mToolbar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbovirose);

        mToolbar = (Toolbar) findViewById(R.id.toolbarArbovirose);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //onBackPressed();
        Intent intent = new Intent(ArboviroseActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
