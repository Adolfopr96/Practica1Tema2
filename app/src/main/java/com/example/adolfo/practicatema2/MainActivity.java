package com.example.adolfo.practicatema2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_delete;
    Button btn_generate;
    Spinner sp_marital_status;
    TextView tv_generate_information;
    EditText et_name;
    EditText et_surname;
    EditText et_surname2;
    EditText et_age;
    Switch sw_childrens;
    RadioButton rb_male;
    RadioButton rb_female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_delete = findViewById(R.id.btn_delete);
        btn_generate = findViewById(R.id.btn_generate);
        sp_marital_status = findViewById(R.id.sp_marital_status);
        tv_generate_information = findViewById(R.id.tv_generate_information);
        et_name = findViewById(R.id.et_firts_name);
        et_surname = findViewById(R.id.et_surname);
        et_surname2 = findViewById(R.id.et_surname2);
        et_age = findViewById(R.id.et_age);
        sw_childrens = findViewById(R.id.sw_childrens);
        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Main_A", "Se ha borrado información");
                delete_information();
            }
        });

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_values()== true)
                {
                        Log.i("Main_A", "Error, Campos vacios");
                }
                else{
                        Log.i("Main_A", "Se ha generado información");

                        tv_generate_information.setText(generateInformation());
                }
                }
        });
    }
    public String generateInformation()
    {
        String resultado=et_surname.getText().toString() + " "+ et_surname2.getText().toString() + ", " + et_name.getText().toString() + ", "+ mayorEdad()+ ", "+rb_values()+", "+sp_marital_status.getSelectedItem()+ ", "+ has_childrends();
        return resultado;
    }
    public String mayorEdad()
    {
        int age = Integer.parseInt(et_age.getText().toString());
        String resultado;
        if(age > 18)
        {
            resultado ="Mayor de edad";
        }
        else
            {
            resultado = "Menor de edad";
        }
        return resultado;
    }
    public String has_childrends()
    {
        String result;
        if (sw_childrens.isSelected())
        {
            result = "Con hijos";
        }
        else
        {
            result = "Sin hijos";
        }
        return result;
    }
    public String rb_values()
    {
        String result="";
        if (rb_male.isChecked())
        {
            result = "Hombre";
        }
        else if (rb_female.isChecked())
        {
            result = "Mujer";
        }
        return result;
    }
    public void delete_information()
    {
        tv_generate_information.setText("");
        et_name.setText("");
        et_surname.setText("");
        et_surname2.setText("");
        et_age.setText("");
        sw_childrens.setChecked(false);
        sp_marital_status.setSelection(0);
        rb_female.setChecked(false);
        rb_male.setChecked(false);
    }
    public boolean check_values()
    {
        ;
        if (et_age.length()==0 || et_surname.length()==0 || et_surname2.length()==0 || et_age.length()==0)
        {
            Toast.makeText(this, "Error, los campos deben estar rellenos.", Toast.LENGTH_SHORT).show();
            return true;
        }
            return false;
    }
}
