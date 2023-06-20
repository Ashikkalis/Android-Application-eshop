package com.example.e_shop.ui.phonesParts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_shop.R;
import com.example.e_shop.ui.fixPhones.FixPhones;
import com.example.e_shop.ui.fixPhones.FixPhonesAdapter;
import com.example.e_shop.ui.fixPhones.FixPhonesDB;

import java.util.ArrayList;
import java.util.List;

public class Parts_GetData extends AppCompatActivity {

    RecyclerView recyclerView;

    private List<Parts> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_get_data);

        recyclerView = findViewById(R.id.recyclerview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        list = new ArrayList<>();
        list = PartsDB.getDatabase2(getApplicationContext()).getDao().getAllData2();

        recyclerView.setAdapter(new PartsAdapter(getApplicationContext(), list, new PartsAdapter.DeleteItemClicklistner() {
            @Override
            public void OnItemDelete(int position, int id) {
                PartsDB.getDatabase2(getApplicationContext()).getDao().deleteData2(id);

                list.remove(position);
                getData();
//                recyclerView.getAdapter().notifyItemRemoved(position);

            }
        }));


    }
}