package com.example.e_shop.ui.phonesParts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;
import com.example.e_shop.ui.fixPhones.FixPhonesDB;
import com.example.e_shop.ui.fixPhones.Fix_Phones_UpdateData;

public class Parts_UpdateData extends AppCompatActivity {

    EditText part_name, phone_part;

    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_update_data);

            part_name = findViewById(R.id.edt_part_name);
            phone_part = findViewById(R.id.edt_phone_part);
            update = findViewById(R.id.sp_update_button);

            //Get data

            part_name.setText(getIntent().getExtras().getString("partname"));
            phone_part.setText(getIntent().getExtras().getString("phonepart"));
            String id = getIntent().getExtras().getString("partsid");



            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String partname_txt = part_name.getText().toString().trim();
                    String phonepart_txt = phone_part.getText().toString().trim();

                    if (partname_txt.isEmpty() || phonepart_txt.isEmpty()){
                        Toast.makeText(Parts_UpdateData.this, "All field is required...", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        PartsDB.getDatabase2(getApplicationContext()).getDao().updateData2(partname_txt, phonepart_txt, Integer.parseInt(id));
                        Toast.makeText(Parts_UpdateData.this, "Changes saved", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
            });
        }

}