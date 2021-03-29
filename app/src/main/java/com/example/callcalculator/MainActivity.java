package com.example.callcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final static String FIRST_OPERATOR = "OPERATOR1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = findViewById(R.id.editText);
        Button runEcho = findViewById(R.id.button_run);
        runEcho.setOnClickListener(v -> {
            Uri uri = Uri.parse("calculator://intent");
            Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
            runEchoIntent.putExtra(FIRST_OPERATOR, text.getText().toString());
            ActivityInfo activityInfo =
                    runEchoIntent.resolveActivityInfo(getPackageManager(),
                            runEchoIntent.getFlags());
            if (activityInfo != null) {
                startActivity(runEchoIntent);
            }
        });
    }
}