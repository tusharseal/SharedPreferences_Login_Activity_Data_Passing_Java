package com.example.sharedpreferencesjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textFullName, textEmail;
    Button buttonLogout;

    private static final String SHARED_PREF_NAME = "LOGIN";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_EMAIL = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textFullName = findViewById(R.id.textFullName);
        textEmail = findViewById(R.id.textEmail);
        buttonLogout = findViewById(R.id.buttonLogout);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if (name != null || email != null) {
            textFullName.setText("Fill Name: " + name);
            textEmail.setText("Email: " + email);
        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("flag", false);
                editor.clear();
                editor.commit();
                finish();

                Toast.makeText(HomeActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}