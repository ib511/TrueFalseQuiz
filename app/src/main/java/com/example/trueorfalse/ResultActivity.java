package com.example.trueorfalse;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        LinearLayout result_layout = findViewById(R.id.main);

        TextView tvResult = findViewById(R.id.tvResult);

        TextView tvExp = findViewById(R.id.tvExp);

        Button btnNext = findViewById(R.id.btnNext);



        boolean isCorrect = getIntent().getBooleanExtra("isCorrect", false);

        String expl = getIntent().getStringExtra("explenation");

        String from = getIntent().getStringExtra("numq");

        if("2".equals(from)){
            btnNext.setVisibility(View.GONE);
        }else{
            btnNext.setVisibility(View.VISIBLE);
        }

        if (isCorrect) {
            tvResult.setText("goog job");
            result_layout.setBackgroundColor(getColor(R.color.result_correct));
        } else {
            tvResult.setText("wrong");
            result_layout.setBackgroundColor(getColor(R.color.result_wrong));

        }

        tvExp.setText(expl);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, SecondQuestionActivity.class);
                startActivity(intent);
            }
        });

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }



        });
    }
}