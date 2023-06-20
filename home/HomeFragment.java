package com.example.e_shop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_shop.R;
import com.example.e_shop.databinding.FragmentHomeBinding;
import com.example.e_shop.fix_phones_and_sale;
import com.example.e_shop.ui.phonesParts.Parts;
import com.example.e_shop.ui.phonesParts.PartsActivity;

public class HomeFragment extends Fragment {

    ImageButton imageBtnPhones, imageBtnParts;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        imageBtnPhones = root.findViewById(R.id.imageBtnPhones);
        imageBtnParts = root.findViewById(R.id.imageBtnParts);

        imageBtnPhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), fix_phones_and_sale.class);
                startActivity(in);
            }
        });

        imageBtnParts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PartsActivity.class);
                startActivity(in);
            }
        });

        return root;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}