package com.example.adolfo.practicatema2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    Switch sw_children;
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
        sw_children = findViewById(R.id.sw_childrens);
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
                if(check_values())
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
        return et_surname.getText().toString() + " "+ et_surname2.getText().toString() + ", " + et_name.getText().toString() + ", "+ legalAge()+ ", "+rb_values()+", "+sp_marital_status.getSelectedItem()+ ", "+ has_children();
    }
    public String legalAge()
    {
        int age = Integer.parseInt(et_age.getText().toString());
        String resultado;
        if(age > 18)
        {
            resultado =getResources().getString(R.string.legal_age);
        }
        else
            {
            resultado = getResources().getString(R.string.no_legal_age);
        }
        return resultado;
    }
    public String has_children()
    {
        String result;
        if (sw_children.isChecked())
        {
            result = getResources().getString(R.string.has_childrens_yes);
        }
        else
        {
            result = getResources().getString(R.string.childless);
        }
        return result;
    }
    public String rb_values()
    {
        String result="";
        if (rb_male.isChecked())
        {
            result = rb_male.getText().toString();
        }
        else if (rb_female.isChecked())
        {
            result = rb_female.getText().toString();
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
        sw_children.setChecked(false);
        sp_marital_status.setSelection(0);
        rb_female.setChecked(false);
        rb_male.setChecked(false);
    }
    public boolean check_values()
    {
        if (et_name.length()==0 || et_surname.length()==0 || et_surname2.length()==0 || et_age.length()==0 || !rb_male.isChecked() && !rb_female.isChecked())
        {
            Toast.makeText(this, getResources().getString(R.string.error_empty), Toast.LENGTH_SHORT).show();
            tv_generate_information.setText(getResources().getString(R.string.error_empty));
            return true;
        }
            return false;
    }
}
