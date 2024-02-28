package com.example.valgusfoor_pre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //объявляем 2 переменные
    private ConstraintLayout mConstraintLayout;
    private TextView mInfoTextView;
    private Button redButton,yellowButton,greenButton;
    private int[] colors = {R.color.redColor,R.color.yellowColor,R.color.greenColor};
    private int currentColorIndex = 0;
    private int[] textResources = {R.string.red, R.string.yellow, R.string.green};

    private int currentTextIndex = 0;
    private Handler handler = new Handler();
    private Runnable colorChangeRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ищем свойства и текстовое окно главного экрана поверх экрана
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mInfoTextView = findViewById(R.id.textView);

        //ищем желтую кнопку
        redButton = findViewById(R.id.button_red);
        yellowButton = findViewById(R.id.button_yellow);
        greenButton = findViewById(R.id.button_green);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopColorChange();
                changeTextViewText(R.string.red);
                changeBackgroundColor(R.color.redColor);
            }
        });
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopColorChange();
                //изменяем текст в окне
                changeTextViewText(R.string.yellow);
                changeBackgroundColor(R.color.yellowColor);
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopColorChange();
                changeTextViewText(R.string.green);
                changeBackgroundColor(R.color.greenColor);
            }
        });
        startColorChange();
    }
    private void startColorChange() {
        colorChangeRunnable = new Runnable() {
            @Override
            public void run() {
                changeColorAutomatically();
                handler.postDelayed(this, 2000); // Задержка в миллисекундах (в данном случае 2 секунды)
            }
        };
        handler.postDelayed(colorChangeRunnable, 2000); // Запуск первого раза
    }
    private void stopColorChange() {
        handler.removeCallbacks(colorChangeRunnable);
    }
    private void changeColorAutomatically() {
        int nextColor = colors[currentColorIndex];
        int nextText = textResources[currentTextIndex];
        currentColorIndex = (currentColorIndex + 1) % colors.length;
        currentTextIndex = (currentTextIndex + 1) % textResources.length;
        changeBackgroundColor(nextColor); // Используем 0 в качестве заглушки, так как для автоматического изменения текста не требуетс
        changeTextViewText(nextText);
    }


    private void changeBackgroundColor(int colorResourceId) {
        // Изменяем цвет фона с учетом ресурса цвета
        mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, colorResourceId));

    }
    private void changeTextViewText(int textResourceId) {
        mInfoTextView.setText(getString(textResourceId));
    }

}
