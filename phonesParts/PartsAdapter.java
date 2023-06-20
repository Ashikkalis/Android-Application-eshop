package com.example.e_shop.ui.phonesParts;

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
import com.example.e_shop.ui.fixPhones.FixPhones;
import com.example.e_shop.ui.fixPhones.FixPhonesAdapter;
import com.example.e_shop.ui.fixPhones.Fix_Phones_UpdateData;

import java.util.List;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.ViewHolder>{
    Context context;
    List<Parts> list;
    PartsAdapter.DeleteItemClicklistner deleteItemClicklistner;

    public PartsAdapter(Context context, List<Parts> list, PartsAdapter.DeleteItemClicklistner deleteItemClicklistner) {
        this.context = context;
        this.list = list;
        this.deleteItemClicklistner = deleteItemClicklistner;
    }

    @NonNull
    @Override
    public PartsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_parts_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PartsAdapter.ViewHolder holder, int position) {


        holder.partname.setText(list.get(holder.getAdapterPosition()).getPartName());
        holder.phonepart.setText(list.get(holder.getAdapterPosition()).getPhonePart());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent in = new Intent(context, Parts_UpdateData.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("partsid", String.valueOf(list.get(holder.getAdapterPosition()).getPartsid()));
                in.putExtra("partname", String.valueOf(list.get(holder.getAdapterPosition()).getPartName()));
                in.putExtra("phonepart", String.valueOf(list.get(holder.getAdapterPosition()).getPhonePart()));

                context.startActivity(in);

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItemClicklistner.OnItemDelete(holder.getAdapterPosition(), list.get(holder.getAdapterPosition()).getPartsid());

            }

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        TextView partname, phonepart;
        Button update, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            partname = itemView.findViewById(R.id.partName);
            phonepart = itemView.findViewById(R.id.phonePart);
            update = itemView.findViewById(R.id.btn_update);
            delete = itemView.findViewById(R.id.btn_delete);
        }
    }

    public interface DeleteItemClicklistner{
        void OnItemDelete(int position, int id);
    }
}
