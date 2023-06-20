package com.example.e_shop.ui.fixPhones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;

public class FixPhonesActivity extends AppCompatActivity {

    EditText phone_name, phone_model;

    Button save, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_phones);

        phone_name = findViewById(R.id.edt_fphone_name);
        phone_model = findViewById(R.id.edt_fphone_model);
//        phone_prob = findViewById(R.id.edt_fphone_prob);
        save = findViewById(R.id.save_button);
        show = findViewById(R.id.show_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                startActivity(new Intent(getApplicationContext(), FixPhoneGetData.class));
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FixPhoneGetData.class));

            }
        });

    }

    private void saveData(){

        String phone_name_txt = phone_name.getText().toString().trim();
        String phone_model_txt = phone_model.getText().toString().trim();
//        String phone_prob_txt = phone_prob.getText().toString().trim();


        FixPhones fixPhones = new FixPhones();
        fixPhones.setPhoneName(phone_name_txt);
        fixPhones.setPhoneModel(phone_model_txt);
//        fixPhones.setPhoneProb(phone_prob_txt);

        FixPhonesDB.getDatabase(getApplicationContext()).getDao_FixPhones().insertAllData(fixPhones);

        phone_name.setText("");
        phone_model.setText("");
//        phone_prob.setText("");

        Toast.makeText(this, "Data successfilly saved", Toast.LENGTH_SHORT).show();

    }
}