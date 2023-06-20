package com.example.e_shop.ui.fixPhones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_shop.R;

import java.util.ArrayList;
import java.util.List;

public class FixPhoneGetData extends AppCompatActivity {

    RecyclerView recyclerView;

    private List<FixPhones> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_phone_get_data);

        recyclerView = findViewById(R.id.recyclerview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        list = new ArrayList<>();
        list = FixPhonesDB.getDatabase(getApplicationContext()).getDao_FixPhones().getAllData();

        recyclerView.setAdapter(new FixPhonesAdapter(getApplicationContext(), list, new FixPhonesAdapter.DeleteItemClicklistner() {
            @Override
            public void OnItemDelete(int position, int id) {
                FixPhonesDB.getDatabase(getApplicationContext()).getDao_FixPhones().deleteData(id);

                list.remove(position);
                getData();
//                recyclerView.getAdapter().notifyItemRemoved(position);

            }
        }));


    }
}