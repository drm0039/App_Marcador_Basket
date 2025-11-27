package com.example.app_marcador_basket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);  // ← CORREGIDO

        // Obtener datos del Intent
        int scoreLocal = getIntent().getIntExtra(MainActivity.KEY_SCORE_LOCAL, 0);
        int scoreVisitor = getIntent().getIntExtra(MainActivity.KEY_SCORE_VISITOR, 0);

        // Referencias
        TextView tvLocal = findViewById(R.id.tvScoreLocal);
        TextView tvVisitor = findViewById(R.id.tvScoreVisitor);

        // Mostrar datos
        tvLocal.setText("Local: " + scoreLocal);
        tvVisitor.setText("Visitante: " + scoreVisitor);
    }
}
