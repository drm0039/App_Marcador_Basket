package com.example.app_marcador_basket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Recoger puntos
        int scoreLocal = getIntent().getIntExtra(MainActivity.KEY_SCORE_LOCAL, 0);
        int scoreVisitor = getIntent().getIntExtra(MainActivity.KEY_SCORE_VISITOR, 0);

        // Vistas
        TextView tvScore = findViewById(R.id.tvScore);
        TextView tvResultMessage = findViewById(R.id.tvResultMessage);

        // Mostrar marcador
        tvScore.setText(scoreLocal + " - " + scoreVisitor);

        // Mostrar resultado
        if (scoreLocal > scoreVisitor) {
            tvResultMessage.setText("Ha ganado el equipo local");
        } else if (scoreLocal < scoreVisitor) {
            tvResultMessage.setText("Ha ganado el equipo visitante");
        } else {
            tvResultMessage.setText("El partido ha terminado en empate");
        }
    }
}
