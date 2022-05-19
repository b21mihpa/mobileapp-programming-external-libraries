package com.example.externallibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final List<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageUrls.add("https://images.pexels.com/photos/7925859/pexels-photo-7925859.jpeg");
        imageUrls.add("https://images.pexels.com/photos/67811/butterfly-swallowtail-papilio-animal-67811.jpeg");
        imageUrls.add("https://images.pexels.com/photos/2832036/pexels-photo-2832036.jpeg");
        imageUrls.add("https://images.pexels.com/photos/635529/pexels-photo-635529.jpeg");
        imageUrls.add("https://images.pexels.com/photos/347925/pexels-photo-347925.jpeg");

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);
        final ImageView imageView = findViewById(R.id.imageView);
        final Button autofill = findViewById(R.id.autofill);

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
            editText.setText("");
        });

        autofill.setOnClickListener(view -> editText.setText(imageUrls.get(new Random().nextInt(imageUrls.size()))));
    }
}
