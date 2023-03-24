package com.example.sharedpreferencesjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail;
    Button buttonSave;

    private static final String SHARED_PREF_NAME = "LOGIN";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_EMAIL = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSave = findViewById(R.id.buttonSave);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if (name != null || email != null) {

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }


        buttonSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, editTextName.getText().toString());
                editor.putString(KEY_EMAIL, editTextEmail.getText().toString());
                editor.putBoolean("flag", true);
                editor.apply();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}