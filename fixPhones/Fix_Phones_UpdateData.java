package com.example.e_shop.ui.fixPhones;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;
import com.example.e_shop.ui.phonesParts.PartsDB;
import com.example.e_shop.ui.phonesParts.Parts_UpdateData;

public class Fix_Phones_UpdateData extends AppCompatActivity {
    EditText phone_name, phone_model;

    Button pupdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_phones_update_data);

        phone_name = findViewById(R.id.edt_fphone_name);
        phone_model = findViewById(R.id.edt_fphone_model);
//        phone_prob = findViewById(R.id.edt_fphone_prob);
        pupdate = findViewById(R.id.pupdate_button);

        //Get data

        phone_name.setText(getIntent().getExtras().getString("phoneName"));
        phone_model.setText(getIntent().getExtras().getString("phoneModel"));
//        phone_prob.setText(getIntent().getExtras().getString("phoneProb"));
        String fid = getIntent().getExtras().getString("phoneid");



        pupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonename_txt = phone_name.getText().toString().trim();
                String phonemodel_txt = phone_model.getText().toString().trim();
//                String phoneprob_txt = phone_prob.getText().toString().trim();

                if (phonename_txt.isEmpty() || phonemodel_txt.isEmpty()){
                    Toast.makeText(Fix_Phones_UpdateData.this, "All field is required...", Toast.LENGTH_SHORT).show();
                }
                else {

                    FixPhonesDB.getDatabase(getApplicationContext()).getDao_FixPhones().updateData(phonename_txt, phonemodel_txt, parseInt(fid));
                    Toast.makeText(Fix_Phones_UpdateData.this, "Changes saved", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}