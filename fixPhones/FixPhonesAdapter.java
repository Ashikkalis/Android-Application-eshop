package com.example.e_shop.ui.fixPhones;

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

import java.util.List;

public class FixPhonesAdapter extends RecyclerView.Adapter<FixPhonesAdapter.ViewHolder>{
    Context context;
    List<FixPhones> list;
    DeleteItemClicklistner deleteItemClicklistner;

    public FixPhonesAdapter(Context context, List<FixPhones> list, DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_fix_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.phonename.setText(list.get(holder.getAdapterPosition()).getPhoneName());
        holder.phonemodel.setText(list.get(holder.getAdapterPosition()).getPhoneModel());
//        holder.phoneprob.setText(list.get(holder.getAdapterPosition()).getPhoneProb());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(context, Fix_Phones_UpdateData.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("phoneid", String.valueOf(list.get(holder.getAdapterPosition()).getPhoneid()));
                in.putExtra("phoneName", String.valueOf(list.get(holder.getAdapterPosition()).getPhoneName()));
                in.putExtra("phoneModel", String.valueOf(list.get(holder.getAdapterPosition()).getPhoneModel()));
//                in.putExtra("phoneProb", String.valueOf(list.get(holder.getAdapterPosition()).getPhoneProb()));

                context.startActivity(in);

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItemClicklistner.OnItemDelete(holder.getAdapterPosition(), list.get(holder.getAdapterPosition()).getPhoneid());

            }

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        TextView phonename, phonemodel;
        Button update, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            phonename = itemView.findViewById(R.id.fphonname);
            phonemodel = itemView.findViewById(R.id.fphonemodel);
//            phoneprob = itemView.findViewById(R.id.fphoneprob);
            update = itemView.findViewById(R.id.btn_update);
            delete = itemView.findViewById(R.id.btn_delete);
        }
    }

    public interface DeleteItemClicklistner{
        void OnItemDelete(int position, int id);
    }
}
