package com.example.e_shop.ui.salePhones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_shop.R;
import com.example.e_shop.ui.phonesParts.Parts;
import com.example.e_shop.ui.phonesParts.PartsAdapter;
import com.example.e_shop.ui.phonesParts.PartsDB;

import java.util.ArrayList;
import java.util.List;

public class Sale_Phone_GetData extends AppCompatActivity {

    RecyclerView recyclerView;

    private List<SalePhones> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_phone_get_data);
        recyclerView = findViewById(R.id.recyclerview_sphone);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        list = new ArrayList<>();
        list = SalePhoneDB.getDatabase3(getApplicationContext()).getDao_salephone().getAllData3();

        recyclerView.setAdapter(new SalePhonesAdapter(getApplicationContext(), list, new SalePhonesAdapter.DeleteItemClicklistner() {
            @Override
            public void OnItemDelete(int position, int id) {
                SalePhoneDB.getDatabase3(getApplicationContext()).getDao_salephone().deleteData3(id);

                list.remove(position);
                getData();
//                recyclerView.getAdapter().notifyItemRemoved(position);

            }
        }));


    }
}