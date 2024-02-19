package com.example.valgusfoor_pre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //объявляем 2 переменные
    private ConstraintLayout mConstraintLayout;
    private TextView mInfoTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ищем свойства и текстовое окно главного экрана поверх экрана
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mInfoTextView = findViewById(R.id.textView);

        //ищем желтую кнопку
        Button yellowButton = findViewById(R.id.button_yellow);
        Button redButton = findViewById(R.id.button_red);
        Button greenButton = findViewById(R.id.button_green);

        //если есть, нажимаем желтую кнопку
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //изменяем текст в окне
                changeTextViewText(R.string.yellow);
                changeBackgroundColor(R.color.yellowColor);

            }
        });
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextViewText(R.string.red);
                changeBackgroundColor(R.color.redColor);
            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextViewText(R.string.green);
                changeBackgroundColor(R.color.greenColor);
            }
        });
    }

    private void changeBackgroundColor(int colorResourceId) {
        // Изменяем цвет фона с учетом ресурса цвета
        mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, colorResourceId));

    }
    private void changeTextViewText(int textResourceId) {
        mInfoTextView.setText(getString(textResourceId));
    }

}
