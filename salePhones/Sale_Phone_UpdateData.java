package com.example.e_shop.ui.salePhones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;
import com.example.e_shop.ui.phonesParts.PartsDB;
import com.example.e_shop.ui.phonesParts.Parts_UpdateData;

public class Sale_Phone_UpdateData extends AppCompatActivity {

    EditText sphone_name, sphone_model;

    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_phone_update_data);

        sphone_name = findViewById(R.id.edt_sphone_name);
        sphone_model = findViewById(R.id.edt_sphone_model);
        update = findViewById(R.id.update_button);

        //Get data

        sphone_name.setText(getIntent().getExtras().getString("sphoneName"));
        sphone_model.setText(getIntent().getExtras().getString("sphoneModel"));
        String sid = getIntent().getExtras().getString("sphoneid");



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphonename_txt = sphone_name.getText().toString().trim();
                String sphonemodel_txt = sphone_model.getText().toString().trim();

                if (sphonename_txt.isEmpty() || sphonemodel_txt.isEmpty()){
                    Toast.makeText(Sale_Phone_UpdateData.this, "All field is required...", Toast.LENGTH_SHORT).show();
                }
                else {
                    SalePhoneDB.getDatabase3(getApplicationContext()).getDao_salephone().updateData3(sphonename_txt, sphonemodel_txt, Integer.parseInt(sid));
                    Toast.makeText(Sale_Phone_UpdateData.this, "Changes saved", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}