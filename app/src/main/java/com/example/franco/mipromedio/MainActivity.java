package com.example.franco.mipromedio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    Integer auxPon=0;
    ImageView good,bad;
    TextView cant;
    SeekBar seek1;
    ImageButton btn_home;
    TextView situ;
    TextView txtpp;
    TextView nota;
    TextView txtpond;
    TextView txtex;
    EditText n1;
    Double notaAcu=0.0;
    Double notaExa=0.0;
    Double notaAux=0.0;
    Double notaFinal=0.0;
    int pondeExamen=0;
    int ponderaAux=0;
    Switch sw;
    Boolean estadoSw;


    Spinner p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;

    ImageView calculator;

    int pondeAcu=0;
    int posicion=0;
    int prevProgress;
    int diff;
    int ponderaGlobal=0;
    Boolean inicio=false;
    int ex=0;

    Spinner opcionesn1;
    Spinner opcionesn2;
    Spinner opcionesn3;
    Spinner opcionesn4;
    Spinner opcionesn5;
    Spinner opcionesn6;
    Spinner opcionesn7;
    Spinner opcionesn8;
    Spinner opcionesn9;
    Spinner opcionesn10;
    Spinner opcionesex;
    Spinner pex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switch1);



        estadoSw=sw.isChecked();




        situ =  findViewById(R.id.txtpondera);
        situ.setText("5");
        nota  =  findViewById(R.id.txtpromedio);
        nota.setText("0.0");

        good     = findViewById(R.id.imgOK);
        bad      = findViewById(R.id.imgBad);
        cant     =  findViewById(R.id.txtcant);
        seek1    =  findViewById(R.id.seekBar);
        btn_home =  findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(MainActivity.this, PrincipalPro.class);
                startActivities(new Intent[]{inte});
            }
        });

        good.setVisibility(View.INVISIBLE);
        bad.setVisibility(View.INVISIBLE);

        cant.setText("1");
        seek1.setProgress(0);

        LinearLayout l1 = findViewById(R.id.lista1);
        l1.setVisibility(View.VISIBLE);
        LinearLayout l2 =  findViewById(R.id.lista2);
        l2.setVisibility(View.INVISIBLE);
        LinearLayout l3 =  findViewById(R.id.lista3);
        l3.setVisibility(View.INVISIBLE);
        LinearLayout l4 =  findViewById(R.id.lista4);
        l4.setVisibility(View.INVISIBLE);
        LinearLayout l5 =  findViewById(R.id.lista5);
        l5.setVisibility(View.INVISIBLE);
        LinearLayout l6 =  findViewById(R.id.lista6);
        l6.setVisibility(View.INVISIBLE);
        LinearLayout l7 =  findViewById(R.id.lista7);
        l7.setVisibility(View.INVISIBLE);
        LinearLayout l8 =  findViewById(R.id.lista8);
        l8.setVisibility(View.INVISIBLE);
        LinearLayout l9 =  findViewById(R.id.lista9);
        l9.setVisibility(View.INVISIBLE);
        LinearLayout ll0 =  findViewById(R.id.lista10);
        ll0.setVisibility(View.INVISIBLE);
        final LinearLayout lex=  findViewById(R.id.listaex);
        lex.setVisibility(View.INVISIBLE);


        //--------------------DECLARACIÓN PARA EDITTEXT---------------------------

        txt1 =  findViewById(R.id.edit1);
        txt2 =  findViewById(R.id.edit2);
        txt3 =  findViewById(R.id.edit3);
        txt4 =  findViewById(R.id.edit4);
        txt5 =  findViewById(R.id.edit5);
        txt6 =  findViewById(R.id.edit6);
        txt7 =  findViewById(R.id.edit7);
        txt8 =  findViewById(R.id.edit8);
        txt9 =  findViewById(R.id.edit9);
        txt10 =  findViewById(R.id.edit10);
        txtex = findViewById(R.id.editnex);


        //-------------------------------------------------------------------

        //--------------------DECLARACIÓN PARA SPINNERS---------------------------

        opcionesn1  =  findViewById(R.id.spinner1);
        opcionesn2  =  findViewById(R.id.spinner2);
        opcionesn3  =  findViewById(R.id.spinner3);
        opcionesn4  =  findViewById(R.id.spinner4);
        opcionesn5  =  findViewById(R.id.spinner5);
        opcionesn6  =  findViewById(R.id.spinner6);
        opcionesn7  =  findViewById(R.id.spinner7);
        opcionesn8  =  findViewById(R.id.spinner8);
        opcionesn9  =  findViewById(R.id.spinner9);
        opcionesn10 =  findViewById(R.id.spinner10);
        opcionesex  =  findViewById(R.id.spinnerex);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ponderaciones, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapterEx = ArrayAdapter.createFromResource(this, R.array.ponderaExamen, android.R.layout.simple_spinner_item);

        opcionesn1.setAdapter(adapter);
        opcionesn2.setAdapter(adapter);
        opcionesn3.setAdapter(adapter);
        opcionesn4.setAdapter(adapter);
        opcionesn5.setAdapter(adapter);
        opcionesn6.setAdapter(adapter);
        opcionesn7.setAdapter(adapter);
        opcionesn8.setAdapter(adapter);
        opcionesn9.setAdapter(adapter);
        opcionesn10.setAdapter(adapter);
        opcionesex.setAdapter(adapterEx);

//------------------------------------------------------------------

//-----------------------------METODO EDITTEXT-----------------------
txt1.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        sacaNota();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt2.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});


txt3.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt4.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt5.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt6.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt7.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt8.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt9.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txt10.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sacaNota();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});

txtex.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (txtex.length()>0) {
            int na;
            na = Integer.parseInt(String.valueOf(txtex.getText()));
            if (txtex.length()>1) {
                if (na >=10 && na <= 70) {
                    //********************
                    sacaPonderaExa();
                    sacaNotaExa();
                    //************************
                } else {
                    Toast.makeText(MainActivity.this, "Nota Examen debe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});
//------------------------------------------------------------------

//-----------------------------METODO SEEKBAR-----------------------

        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             int aux1=progress+1;
                cant.setText(String.valueOf(aux1));
                inicio=true;


                diff = progress - prevProgress;
                // con este if identifico si el seekbar sube o baja
                if(diff > 0 && progress!=0){ //si se cunple la condición el seekbar esta subiendo

                    while(progress>prevProgress){

                        System.out.println("sube");
                        prevProgress++;// le sumo uno  solo para no trabajar con el cero
                        switch (prevProgress) {
                            case 1:

                                situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                    Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))
                            ));

                                break ;
                            case 2: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                    Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                    Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))
                            ));

                            break ;
                            case 3: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))
                            ));

                            break ;
                            case 4: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))
                            ));

                            break ;
                            case 5: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()))
                            ));

                            break ;
                            case 6: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString()))
                            ));

                            break ;
                            case 7: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p8.getSelectedItem().toString()))
                            ));

                            break ;
                            case 8: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p8.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p9.getSelectedItem().toString()))
                            ));

                            break ;

                            case 9: situ.setText( String.valueOf(
                                    Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p8.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p9.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p10.getSelectedItem().toString()))
                            ));

                            break ;
                        }
                        }
                    }

                else{ // si el seekbar no esta subiendo esta bajando aju!

                    while(progress<prevProgress){
                        System.out.println(""+progress+" < "+prevProgress);
                        System.out.println("valor de i >>"+prevProgress);
                        prevProgress--;
                        System.out.println("despues de resta >>"+prevProgress);

                            switch (prevProgress ) {

                                case 0:

                                int v1=Integer.parseInt(String.valueOf(situ.getText().toString())),
                                    v2=Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())),
                                        aux=v1-v2;

                                  //  Toast.makeText(MainActivity.this, "v1 >>"+v1, Toast.LENGTH_SHORT).show();
                                  //  Toast.makeText(MainActivity.this, "v2 >>"+v2, Toast.LENGTH_SHORT).show();
                                  //  auxPon=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()));
                                  //  Toast.makeText(MainActivity.this, "auxpon >>"+auxPon, Toast.LENGTH_SHORT).show();
                                  //  situ.setText(String.valueOf(v1-v2));
                                  //  Toast.makeText(MainActivity.this, "situ >>"+situ.getText(), Toast.LENGTH_SHORT).show();
                                    p2.setSelection(0,true);

                                   situ.setText(String.valueOf(aux));
                                    Toast.makeText(MainActivity.this, String.valueOf(situ.getText().toString()), Toast.LENGTH_SHORT).show();
                                case 1:

                                    auxPon=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()));
                                    situ.setText(String.valueOf(auxPon));
                                    p3.setSelection(0,true);
                                    break;
                                case 2:
                                  //  auxPon= Integer.parseInt(String.valueOf(situ.getText()));
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p4.setSelection(0,true);
                                    break;
                                case 3:
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p5.setSelection(0,true);
                                    break;
                                case 4:
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p6.setSelection(0,true);
                                    break;
                                case 5: //************************
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p7.setSelection(0,true);
                                    break;
                                case 6:
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p8.setSelection(0,true);
                                    break;
                                case 7:
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p8.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p9.setSelection(0,true);
                                    break;
                                case 8:
                                    auxPon= Integer.parseInt(String.valueOf(p1.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p2.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p3.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p4.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p5.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p6.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p7.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p8.getSelectedItem().toString())) +
                                            Integer.parseInt(String.valueOf(p9.getSelectedItem().toString()))
                                    ;
                                    situ.setText(String.valueOf(auxPon));
                                    p10.setSelection(0,true);
                                    break;


                            }

                    }
                }
                prevProgress = progress;

                posicion=progress;

                LinearLayout list1 =  findViewById(R.id.lista1);
                LinearLayout list2 =  findViewById(R.id.lista2);
                LinearLayout list3 =  findViewById(R.id.lista3);
                LinearLayout list4 =  findViewById(R.id.lista4);
                LinearLayout list5 =  findViewById(R.id.lista5);
                LinearLayout list6 =  findViewById(R.id.lista6);
                LinearLayout list7 =  findViewById(R.id.lista7);
                LinearLayout list8 =  findViewById(R.id.lista8);
                LinearLayout list9 =  findViewById(R.id.lista9);
                LinearLayout list10 = findViewById(R.id.lista10);
//                LinearLayout listex = findViewById(R.id.listaex);

                switch (progress){

                    case 0 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.INVISIBLE);
                        list3.setVisibility(View.INVISIBLE);
                        list4.setVisibility(View.INVISIBLE);
                        list5.setVisibility(View.INVISIBLE);
                        list6.setVisibility(View.INVISIBLE);
                        list7.setVisibility(View.INVISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 1 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.INVISIBLE);
                        list4.setVisibility(View.INVISIBLE);
                        list5.setVisibility(View.INVISIBLE);
                        list6.setVisibility(View.INVISIBLE);
                        list7.setVisibility(View.INVISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 2 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.INVISIBLE);
                        list5.setVisibility(View.INVISIBLE);
                        list6.setVisibility(View.INVISIBLE);
                        list7.setVisibility(View.INVISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 3 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.INVISIBLE);
                        list6.setVisibility(View.INVISIBLE);
                        list7.setVisibility(View.INVISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 4 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.VISIBLE);
                        list6.setVisibility(View.INVISIBLE);
                        list7.setVisibility(View.INVISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);

                        break;
                    case 5 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.VISIBLE);
                        list6.setVisibility(View.VISIBLE);
                        list7.setVisibility(View.INVISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 6 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.VISIBLE);
                        list6.setVisibility(View.VISIBLE);
                        list7.setVisibility(View.VISIBLE);
                        list8.setVisibility(View.INVISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 7 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.VISIBLE);
                        list6.setVisibility(View.VISIBLE);
                        list7.setVisibility(View.VISIBLE);
                        list8.setVisibility(View.VISIBLE);
                        list9.setVisibility(View.INVISIBLE);
                        list10.setVisibility(View.INVISIBLE);


                        break;
                    case 8 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.VISIBLE);
                        list6.setVisibility(View.VISIBLE);
                        list7.setVisibility(View.VISIBLE);
                        list8.setVisibility(View.VISIBLE);
                        list9.setVisibility(View.VISIBLE);
                        list10.setVisibility(View.INVISIBLE);
                        break;
                    case 9 :
                        list1.setVisibility(View.VISIBLE);
                        list2.setVisibility(View.VISIBLE);
                        list3.setVisibility(View.VISIBLE);
                        list4.setVisibility(View.VISIBLE);
                        list5.setVisibility(View.VISIBLE);
                        list6.setVisibility(View.VISIBLE);
                        list7.setVisibility(View.VISIBLE);
                        list8.setVisibility(View.VISIBLE);
                        list9.setVisibility(View.VISIBLE);
                        list10.setVisibility(View.VISIBLE);
                        break;
                }

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        p1 = findViewById(R.id.spinner1) ;
        p2 =  findViewById(R.id.spinner2) ;
        p3 =  findViewById(R.id.spinner3) ;
        p4 =  findViewById(R.id.spinner4) ;
        p5 =  findViewById(R.id.spinner5) ;
        p6 =  findViewById(R.id.spinner6) ;
        p7 =  findViewById(R.id.spinner7) ;
        p8 =  findViewById(R.id.spinner8) ;
        p9 =  findViewById(R.id.spinner9) ;
        p10 =  findViewById(R.id.spinner10) ;
        pex = findViewById(R.id.spinnerex);
        n1 =  findViewById(R.id.edit1);
        txtpp =  findViewById(R.id.txtpromedio);
        txtpond = findViewById(R.id.txtpondera);


//*********************LISTENER DE SPINNER***************************************************/
        p1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                    muestraImagen();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        p2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                    muestraImagen();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        p10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (inicio) {
                    sacaPondera();
                    validaPonderacion();
                    sacaNota();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (inicio && txtex.length()>0){
                    sacaPonderaExa();
                    sacaNotaExa();
                    ex++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw.isChecked()){
                    notaAux=(Double.parseDouble(String.valueOf(txtpp.getText())));
                    ponderaGlobal = Integer.parseInt(String.valueOf(situ.getText()));
                    lex.setVisibility(View.VISIBLE);

                } else  {
                    notaExa=0.0;
                    nota.setText(String.valueOf(notaAux));
                    situ.setText(String.valueOf("100"));
                    txtex.setText("");
                    pex.setSelection(0,true);
                    lex.setVisibility(View.INVISIBLE);

                }

            }
        });
    }
public void sacaPonderaExa(){


            pondeExamen = Integer.parseInt(String.valueOf(pex.getSelectedItem().toString()));
            ponderaAux = 100 - Integer.parseInt(String.valueOf(pex.getSelectedItem().toString()));



}

public void sacaNotaExa(){

        notaExa = Double.parseDouble(String.valueOf(txtex.getText()));
        notaFinal=(notaExa*pondeExamen)/100;
        notaFinal= notaFinal+((notaAux*ponderaAux)/100);
        nota.setText(String.valueOf(notaFinal));



}

public void sacaNota(){
        notaAcu=0.0;
    int na;
        switch (posicion){
            case 0:
                if (txt1.length()>0) {
                    na = Integer.parseInt(String.valueOf(txt1.getText()));
                    if (na >=10 && na <= 70) {
                        notaAcu = notaAcu + ((Double.parseDouble(txt1.getText().toString()) *
                                (Double.parseDouble(p1.getSelectedItem().toString())))
                                / 100);
                        nota.setText(String.valueOf(notaAcu));
                        muestraImagen();

                    } else {
                        if (txt1.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {

                    notaCero();
                }
                break;
            case 1:
                if (txt2.length()>0 && txt1.length()>0 ){
                    na = Integer.parseInt(String.valueOf(txt2.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt2.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    notaCero();
                }

                break;
            case 2:
                if (txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt3.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt3.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    notaCero();
                }
                break;
            case 3:
                if (txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt4.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt4.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    notaCero();
                }
                break;
            case 4:
                if (txt5.length()>0 && txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt5.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt5.getText().toString()) *
                            (Double.parseDouble(p5.getSelectedItem().toString())))
                            /100);

                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt5.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    notaCero();
                }
                break;
            case 5:
                if (txt6.length()>0 && txt5.length()>0 && txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt6.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt5.getText().toString()) *
                            (Double.parseDouble(p5.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt6.getText().toString()) *
                            (Double.parseDouble(p6.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt6.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    notaCero();
                }
                break;
            case 6:
                if (txt7.length()>0 && txt6.length()>0 && txt5.length()>0 && txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt7.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt5.getText().toString()) *
                            (Double.parseDouble(p5.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt6.getText().toString()) *
                            (Double.parseDouble(p6.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt7.getText().toString()) *
                            (Double.parseDouble(p7.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt7.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    notaCero();
                }
                break;
            case 7:
                if (txt8.length()>0 && txt7.length()>0 && txt6.length()>0 && txt5.length()>0 && txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt8.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt5.getText().toString()) *
                            (Double.parseDouble(p5.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt6.getText().toString()) *
                            (Double.parseDouble(p6.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt7.getText().toString()) *
                            (Double.parseDouble(p7.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt8.getText().toString()) *
                            (Double.parseDouble(p8.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt8.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    notaCero();
                }
                break;
            case 8:
                if (txt9.length()>0 && txt8.length()>0 && txt7.length()>0 && txt6.length()>0 && txt5.length()>0 && txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt9.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt5.getText().toString()) *
                            (Double.parseDouble(p5.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt6.getText().toString()) *
                            (Double.parseDouble(p6.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt7.getText().toString()) *
                            (Double.parseDouble(p7.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt8.getText().toString()) *
                            (Double.parseDouble(p8.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt9.getText().toString()) *
                            (Double.parseDouble(p9.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt9.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    notaCero();
                }
                break;
            case 9:
                if (txt10.length()>0 && txt9.length()>0 && txt8.length()>0 && txt7.length()>0 && txt6.length()>0 && txt5.length()>0 && txt4.length()>0 && txt3.length()>0 && txt2.length()>0 && txt1.length()>0){
                    na = Integer.parseInt(String.valueOf(txt9.getText()));
                    if (na >=10 && na <= 70) {
                    notaAcu= notaAcu+ ((Double.parseDouble(txt1.getText().toString()) *
                            (Double.parseDouble(p1.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt2.getText().toString()) *
                            (Double.parseDouble(p2.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt3.getText().toString()) *
                            (Double.parseDouble(p3.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt4.getText().toString()) *
                            (Double.parseDouble(p4.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt5.getText().toString()) *
                            (Double.parseDouble(p5.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt6.getText().toString()) *
                            (Double.parseDouble(p6.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt7.getText().toString()) *
                            (Double.parseDouble(p7.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt8.getText().toString()) *
                            (Double.parseDouble(p8.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt9.getText().toString()) *
                            (Double.parseDouble(p9.getSelectedItem().toString())))
                            /100);
                    notaAcu= notaAcu+ ((Double.parseDouble(txt10.getText().toString()) *
                            (Double.parseDouble(p10.getSelectedItem().toString())))
                            /100);
                    nota.setText(String.valueOf(notaAcu));
                    muestraImagen();
                    } else {
                        if (txt10.length()>1) {
                            System.out.println("txt1 > a 70");
                            Toast.makeText(MainActivity.this, "Nota ndebe ser  entre 10 a 70", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else {
                    notaCero();
                }
                break;
        }
}

 public void sacaPondera(){

      pondeAcu=0;

     switch (posicion+1){

         case 1:
             pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
             txtpond.setText(String.valueOf(pondeAcu));
         break;

         case 2:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()));
                 ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu));
         break;
         case 3:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu));

             break;
         case 4:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu)) ;
             break;
         case 5:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu)) ;

             break;
         case 6:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu)) ;

             break;
         case 7: pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p7.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu)) ;


             break;
         case 8:
                     pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p7.getSelectedItem().toString()))+
                     Integer.parseInt(String.valueOf(p8.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                     txtpond.setText(String.valueOf(pondeAcu)) ;

             break;
         case 9:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p7.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p8.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p9.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu)) ;

             break;
         case 10:
                 pondeAcu=Integer.parseInt(String.valueOf(p1.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p2.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p3.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p4.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p5.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p6.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p7.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p8.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p9.getSelectedItem().toString()))+
                 Integer.parseInt(String.valueOf(p10.getSelectedItem().toString()));
             ponderaGlobal=pondeAcu;
                 txtpond.setText(String.valueOf(pondeAcu));
             break;
     }
 }

 public void validaPonderacion(){
     if (Integer.parseInt(String.valueOf(pondeAcu)) !=100){
         Toast.makeText(MainActivity.this, "Ponderación debe sumar 100% ", Toast.LENGTH_SHORT).show();
     }


 }

 public void notaCero() {
        nota.setText("0.0");
    }

 public void muestraImagen(){

        if (notaAcu>=39.5 && ponderaGlobal == 100) {
            good.setVisibility(View.VISIBLE);
            bad.setVisibility(View.INVISIBLE);
        } else {
            good.setVisibility(View.INVISIBLE);
            bad.setVisibility(View.VISIBLE);
        }
 }


}
