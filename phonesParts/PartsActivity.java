package com.example.e_shop.ui.phonesParts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;
import com.example.e_shop.ui.fixPhones.FixPhoneGetData;
import com.example.e_shop.ui.fixPhones.FixPhones;
import com.example.e_shop.ui.fixPhones.FixPhonesDB;

public class PartsActivity extends AppCompatActivity {

    EditText part_name, phone_part;

    Button save, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        part_name = findViewById(R.id.edt_part_name);
        phone_part = findViewById(R.id.edt_phone_part);
        save = findViewById(R.id.save_button);
        show = findViewById(R.id.show_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                startActivity(new Intent(getApplicationContext(), Parts_GetData.class));

                NotificationChannel channel = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    channel = new NotificationChannel(
                            "1",
                            "channel1",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    //create the notification manager
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);

                    //create the notification
                    NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "1")
                            .setSmallIcon(android.R.drawable.btn_star)
                            .setContentTitle("Hello from Parts Database")
                            .setContentText("Your Part just land in database")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManagerCompat notifyAdmin = NotificationManagerCompat.from(getApplicationContext());
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    notifyAdmin.notify(1, notification.build());

                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Parts_GetData.class));

            }
        });
        //        getdata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), GetData.class));
//            }
//        });
    }

    private void saveData(){

        String part_name_txt = part_name.getText().toString().trim();
        String phone_part_txt = phone_part.getText().toString().trim();


        Parts parts = new Parts();
        parts.setPartName(part_name_txt);
        parts.setPhonePart(phone_part_txt);

        PartsDB.getDatabase2(getApplicationContext()).getDao().insertAllData(parts);

        part_name.setText("");
        phone_part.setText("");
        Toast.makeText(this, "Data successfilly saved", Toast.LENGTH_SHORT).show();

    }
}