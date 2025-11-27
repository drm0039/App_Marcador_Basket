package com.example.app_marcador_basket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.app_marcador_basket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private int scoreLocal = 0;
    private int scoreVisitor = 0;

    public static final String KEY_SCORE_LOCAL = "KEY_SCORE_LOCAL";
    public static final String KEY_SCORE_VISITOR = "KEY_SCORE_VISITOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Local
        binding.btnLocalPlus1.setOnClickListener(v -> addPointsLocal(1));
        binding.btnLocalPlus2.setOnClickListener(v -> addPointsLocal(2));
        binding.btnLocalMinus1.setOnClickListener(v -> subtractPointLocal());

        // Visitante
        binding.btnVisitorPlus1.setOnClickListener(v -> addPointsVisitor(1));
        binding.btnVisitorPlus2.setOnClickListener(v -> addPointsVisitor(2));
        binding.btnVisitorMinus1.setOnClickListener(v -> subtractPointVisitor());

        binding.btnReset.setOnClickListener(v -> resetScores());

        binding.btnResults.setOnClickListener(v -> goToResults());

    }

    private void addPointsLocal(int points) {
        scoreLocal += points;
        binding.tvLocalScore.setText(String.valueOf(scoreLocal));
    }

    private void addPointsVisitor(int points) {
        scoreVisitor += points;
        binding.tvVisitorScore.setText(String.valueOf(scoreVisitor));
    }

    private void subtractPointLocal() {
        if (scoreLocal > 0) {
            scoreLocal--;
            binding.tvLocalScore.setText(String.valueOf(scoreLocal));
        } else {
            Toast.makeText(this, "El marcador no puede ser negativo", Toast.LENGTH_SHORT).show();
        }
    }

    private void subtractPointVisitor() {
        if (scoreVisitor > 0) {
            scoreVisitor--;
            binding.tvVisitorScore.setText(String.valueOf(scoreVisitor));
        }
    }

    private void resetScores() {
        scoreLocal = 0;
        scoreVisitor = 0;
        binding.tvLocalScore.setText(String.valueOf(scoreLocal));
        binding.tvVisitorScore.setText(String.valueOf(scoreVisitor));
    }

    private void goToResults() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(KEY_SCORE_LOCAL, scoreLocal);
        intent.putExtra(KEY_SCORE_VISITOR, scoreVisitor);
        startActivity(intent);
    }
}