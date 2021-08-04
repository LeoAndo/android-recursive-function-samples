package com.template.recursivefunctionjavasample;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtil.setOnClickListenerForToggleButton(findViewById(R.id.content), v -> {
            final TextView view = (TextView) v;
            Toast.makeText(MainActivity.this, view.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}