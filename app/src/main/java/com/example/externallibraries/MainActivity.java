package com.example.externallibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);
        final ImageView imageView = findViewById(R.id.imageView);

        button.setOnClickListener(view -> {
            if (editText.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please, enter a URL.", Toast.LENGTH_LONG).show();
                return;
            }

            if (!Patterns.WEB_URL.matcher(editText.getText().toString()).matches()) {
                Toast.makeText(this, "Please, enter a valid URL.", Toast.LENGTH_LONG).show();
                return;
            }

            Glide.with(this).load(editText.getText().toString()).into(imageView);
        });
    }
}
