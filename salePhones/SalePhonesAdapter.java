package com.example.e_shop.ui.salePhones;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_shop.R;
import com.example.e_shop.ui.phonesParts.Parts;
import com.example.e_shop.ui.phonesParts.PartsAdapter;
import com.example.e_shop.ui.phonesParts.Parts_UpdateData;

import java.util.List;

public class SalePhonesAdapter extends RecyclerView.Adapter<SalePhonesAdapter.ViewHolder>{
    Context context;
    List<SalePhones> list;
    SalePhonesAdapter.DeleteItemClicklistner deleteItemClicklistner;

    public SalePhonesAdapter(Context context, List<SalePhones> list, SalePhonesAdapter.DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public SalePhonesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SalePhonesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_sale_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SalePhonesAdapter.ViewHolder holder, int position) {


        holder.sphoneName.setText(list.get(holder.getAdapterPosition()).getSphoneName());
        holder.sphoneModel.setText(list.get(holder.getAdapterPosition()).getSphoneModel());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent in = new Intent(context, Sale_Phone_UpdateData.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("sphoneid", String.valueOf(list.get(holder.getAdapterPosition()).getSphoneid()));
                in.putExtra("sphoneName", String.valueOf(list.get(holder.getAdapterPosition()).getSphoneName()));
                in.putExtra("sphoneModel", String.valueOf(list.get(holder.getAdapterPosition()).getSphoneModel()));

                context.startActivity(in);

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItemClicklistner.OnItemDelete(holder.getAdapterPosition(), list.get(holder.getAdapterPosition()).getSphoneid());

            }

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        TextView sphoneName, sphoneModel;
        Button update, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sphoneName = itemView.findViewById(R.id.sphoneName);
            sphoneModel = itemView.findViewById(R.id.sphoneModel);
            update = itemView.findViewById(R.id.btn_update);
            delete = itemView.findViewById(R.id.btn_delete);
        }
    }

    public interface DeleteItemClicklistner{
        void OnItemDelete(int position, int id);
    }
}
