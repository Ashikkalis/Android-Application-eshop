package com.example.e_shop.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_shop.R;
import com.example.e_shop.databinding.FragmentProfileBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    Button editProfile;
    String nameUser, emailUser, usernameUser, passwordUser;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference reference;
    DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);


        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getInstance().getReference("users");

        profileName = root.findViewById(R.id.profileName);
        profileUsername = root.findViewById(R.id.profileUsername);
        profileEmail = root.findViewById(R.id.profileEmail);
        profilePassword = root.findViewById(R.id.profilePassword);
        titleName = root.findViewById(R.id.titleName);
        titleUsername = root.findViewById(R.id.titleUsername);
        editProfile = root.findViewById(R.id.editButton);


        showData();

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passUserData();
            }
        });

        return root;


    }


       public void showData(){
        Intent intent =getActivity(). getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");

        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser);
        titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
    }

    public void passUserData(){
        String userUsername = profileUsername.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserData = reference.orderByChild("username").equalTo(userUsername);

        checkUserData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                   Intent intent = new Intent(getActivity(), EditProfile.class);

                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("username", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);

                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}