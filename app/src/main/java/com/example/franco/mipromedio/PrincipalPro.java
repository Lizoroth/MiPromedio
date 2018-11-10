package com.example.franco.mipromedio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PrincipalPro extends AppCompatActivity {

    ImageButton btn_home;
    ImageView btn_nnotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_pro);

        btn_nnotas =  findViewById(R.id.btn_notas);
        btn_nnotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalPro.this, MainActivity.class);
                startActivities(new Intent[]{intent});
            }
        });


    }
}