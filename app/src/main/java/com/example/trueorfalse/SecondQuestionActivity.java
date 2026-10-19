package com.example.trueorfalse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondQuestionActivity extends AppCompatActivity {

    boolean correctAnswer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnFalse = findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("numq", "2");
                startActivity(intent);

            }
        });

        Button btnTrue = findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("numq", "2");
                startActivity(intent);
            }
        });
    }
}