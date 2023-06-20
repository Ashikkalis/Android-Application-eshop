package com.example.e_shop.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_shop.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {

    EditText editName, editEmail, editUsername, editPassword;
    Button saveButton;
    String nameUser, emailUser, usernameUser, passwordUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);

        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNameChanged() || isEmailChanged() || isPasswordChanged()){
                    Toast.makeText(EditProfile.this, "Saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfile.this, "No changes found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isNameChanged(){
        if(!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmailChanged(){
        if(!emailUser.equals(editEmail.getText().toString())){
            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        }
        else{
            return false;
        }
    }

//    public boolean isUsernameChanged(){
//        if(!usernameUser.equals(editUsername.getText().toString())){
//            reference.child(usernameUser).child("username").setValue(editUsername.getText().toString());
//            usernameUser = editUsername.getText().toString();
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    public boolean isPasswordChanged(){
        if(!passwordUser.equals(editPassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        }
        else{
            return false;
        }
    }

    public void showData(){
        Intent in = getIntent();

        nameUser = in.getStringExtra("name");
        emailUser = in.getStringExtra("email");
        usernameUser = in.getStringExtra("username");
        passwordUser = in.getStringExtra("password");

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser);
        editPassword.setText(passwordUser);
    }
}