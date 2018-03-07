package com.example.samirvega.formularioderegistro;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner idSpinner;
    EditText idFecha;
    int dia,mes,ano;
    String nombre,pass,passconfirm,correo,fecha;
    String sexo="Masculino",pasatiempos="",ciudad1="";
    RadioButton idMasculino,idFemenino;
    CheckBox cine,leer,TV,pasear;
    EditText idNombreIn,idContrasena1In,idContrasena2In,idCorreoIn;
    TextView resultados;
    String[] items;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idNombreIn=findViewById(R.id.idNombreIn);
        idContrasena1In=findViewById(R.id.idContrasena1In);
        idContrasena2In=findViewById(R.id.idContrasena2In);
        idCorreoIn=findViewById(R.id.idCorreoIn);
        resultados=findViewById(R.id.resultados);

        idSpinner=findViewById(R.id.idSpinner);
        idFecha=findViewById(R.id.idFecha);
        idMasculino=findViewById(R.id.idSexo1);
        idFemenino=findViewById(R.id.idSexo2);

        cine=findViewById(R.id.IdGusto1);
        leer=findViewById(R.id.IdGusto2);
        TV=findViewById(R.id.IdGusto3);
        pasear=findViewById(R.id.IdGusto4);


        idFecha.setOnClickListener(this);

        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.arreglociudades,R.layout.support_simple_spinner_dropdown_item);
        idSpinner.setAdapter(adapter);
        /*
        idSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ciudad1=parent.getItemAtPosition(position).toString();

            }
        });*/
    }

    @Override
    public void onClick(View v) {
        if(v==idFecha){
            final Calendar C=Calendar.getInstance();
            dia=C.get(Calendar.DAY_OF_MONTH);
            mes=C.get(Calendar.MONTH);
            ano=C.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    idFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
    /*************************************************************************************************************************/


    /*************************************************************************************************************************/
    //botonenviar
    public void clickEnviar(View view) {
        nombre= idNombreIn.getText().toString();
        pass=idContrasena1In.getText().toString();
        passconfirm=idContrasena2In.getText().toString();
        correo= idCorreoIn.getText().toString();
        fecha=idFecha.getText().toString();

        if(TextUtils.isEmpty(nombre.trim())){
            idNombreIn.setError("Ingresa un dato");
            idNombreIn.requestFocus();
        }
        else if(TextUtils.isEmpty(pass.trim())){
            idContrasena1In.setError("Ingresa una contraseña");
            idContrasena1In.requestFocus();
        }
        else if(TextUtils.isEmpty(passconfirm.trim())){
            idContrasena2In.setError("Ingresa la contraseña nuevamente");
            idContrasena2In.requestFocus();
        }
        else if(TextUtils.isEmpty(correo.trim())){
            idCorreoIn.setError("Ingresa una dirección de Correo");
            idCorreoIn.requestFocus();
        }
        else if(TextUtils.isEmpty(fecha.trim())){
            idFecha.setError("Escoge una fecha");
            idFecha.requestFocus();
        }
        else{
            if(pass.equals(passconfirm)){
                resultados.setText("Datos Ingresados:"+"\nNombre: "+nombre +"\nContraseña: " + pass +"\nCorreo: "
                        +correo+ "\nFecha de Nacimiento: "+fecha+ "" +"\nSexo: "+sexo+ "\nHobbies: " + pasatiempos);
            }
            else{
                resultados.setText("Las contraseñas no coinciden");

            }

        }

    }
    //radiobutton



    public void clickRadio(View view) {
        int id=view.getId();
        if(id==R.id.idSexo1){
            sexo="Masculino";
        }
        if(id==R.id.idSexo2){
            sexo="Femenino";
        }
    }

    //checkbox
    public void clickBox(View view) {
        pasatiempos="";
        if(cine.isChecked()){
            pasatiempos=pasatiempos+" "+"Ir a cine";
        }
        if(leer.isChecked()){
            pasatiempos=pasatiempos+" "+ "Leer";
        }
        if (TV.isChecked()) {
            pasatiempos=pasatiempos+" "+"Ver TV";
        }
        if(pasear.isChecked()){
            pasatiempos=pasatiempos+" "+"Salir a pescar";
        }
    }
}


















     /*
        idFecha = findViewById(R.id.idFecha);

        idFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();


            }
        });
        */
//BASURERO
/*
    private void showDatePickerDialog() {
        DataPickerFragment newFragment = DataPickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                idFecha.setText("1"+selectedDate);
            }
        });
        idFecha.setText("1");
        newFragment.show(this.getFragmentManager(), "datePicker");
    }
    */