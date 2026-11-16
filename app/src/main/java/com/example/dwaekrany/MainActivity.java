package com.example.dwaekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // pola formularza - zapamiętujemy je, żeby nie szukać ich za każdym razem
    private EditText etName, etEmail;
    private Spinner spCourse;
    private SeekBar sbLevel;
    private TextView tvLevelValue;
    private CheckBox cbNewsletter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // łączymy kod z elementami z pliku XML (po id)
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        spCourse = findViewById(R.id.spCourse);
        sbLevel = findViewById(R.id.sbLevel);
        tvLevelValue = findViewById(R.id.tvLevelValue);
        cbNewsletter = findViewById(R.id.cbNewsletter);

        setUpCourseSpinner();
        setUpLevelSeekBar();

        // klik w DALEJ = otwórz drugi ekran
        findViewById(R.id.btnNext).setOnClickListener(v -> openSummary());
    }

    // lista kursów z strings.xml wrzucona do rozwijanej listy
    private void setUpCourseSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.courses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCourse.setAdapter(adapter);
    }

    // przy przesuwaniu suwaka pokazujemy jego wartość obok napisu
    private void setUpLevelSeekBar() {
        tvLevelValue.setText(String.valueOf(sbLevel.getProgress()));
        sbLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvLevelValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private void openSummary() {
        // intencja JAWNA: wprost mówimy, którą klasę (ekran) otworzyć
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }
}