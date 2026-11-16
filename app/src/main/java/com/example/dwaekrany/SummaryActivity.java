package com.example.dwaekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.dwaekrany.NAME";
    public static final String EXTRA_EMAIL = "com.example.dwaekrany.EMAIL";
    public static final String EXTRA_COURSE = "com.example.dwaekrany.COURSE";
    public static final String EXTRA_LEVEL = "com.example.dwaekrany.LEVEL";
    public static final String EXTRA_NEWSLETTER = "com.example.dwaekrany.NEWSLETTER";
    // klucz odpowiedzi (wysyłamy go Z POWROTEM do pierwszego ekranu)
    public static final String EXTRA_NUMBER = "com.example.dwaekrany.NUMBER";

    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(buildSummary());

        findViewById(R.id.btnConfirm).setOnClickListener(v -> confirm());
        findViewById(R.id.btnEdit).setOnClickListener(v -> finish());
    }

    private String buildSummary() {
        Intent intent = getIntent();

        String name = intent.getStringExtra(EXTRA_NAME);
        String email = intent.getStringExtra(EXTRA_EMAIL);
        String course = intent.getStringExtra(EXTRA_COURSE);
        int level = intent.getIntExtra(EXTRA_LEVEL, 0);
        boolean newsletter = intent.getBooleanExtra(EXTRA_NEWSLETTER, false);

        String newsletterText = newsletter
                ? getString(R.string.yes_short)
                : getString(R.string.no_short);

        return getString(R.string.summary_format, name, email, course, level, newsletterText);
    }

    // POTWIERDŹ: losujemy numer, odsyłamy go i zamykamy ekran
    private void confirm() {
        String number = "ZG/" + (1000 + new Random().nextInt(9000));

        Intent result = new Intent();
        result.putExtra(EXTRA_NUMBER, number);
        setResult(RESULT_OK, result);   // ustaw odpowiedź "OK"
        finish();                       // dopiero finish() ją wysyła
    }
}