package com.example.e_shop.ui.salePhones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;
import com.example.e_shop.ui.phonesParts.Parts;
import com.example.e_shop.ui.phonesParts.PartsDB;
import com.example.e_shop.ui.phonesParts.Parts_GetData;

public class SalePhoneActivity extends AppCompatActivity {
    EditText sphone_name, sphone_model;

    Button save, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_phone);

        sphone_name = findViewById(R.id.edt_sphone_name);
        sphone_model = findViewById(R.id.edt_sphone_model);
        save = findViewById(R.id.save_button);
        show = findViewById(R.id.show_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData3();
                startActivity(new Intent(getApplicationContext(), Sale_Phone_GetData.class));
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sale_Phone_GetData.class));

            }
        });
        //        getdata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), GetData.class));
//            }
//        });
    }
    private void saveData3(){

        String sphone_name_txt = sphone_name.getText().toString().trim();
        String sphone_model_txt = sphone_model.getText().toString().trim();


        SalePhones salephones = new SalePhones();
        salephones.setSphoneName(sphone_name_txt);
        salephones.setSphoneModel(sphone_model_txt);


        SalePhoneDB.getDatabase3(getApplicationContext()).getDao_salephone().insertAllData3(salephones);

        sphone_name.setText("");
        sphone_model.setText("");
        Toast.makeText(this, "Data successfilly saved", Toast.LENGTH_SHORT).show();

    }
}