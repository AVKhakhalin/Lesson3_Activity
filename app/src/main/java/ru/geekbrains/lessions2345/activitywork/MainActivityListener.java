package ru.geekbrains.lessions2345.activitywork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityListener extends AppCompatActivity implements View.OnClickListener {

    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;
    private int counter4 = 0;
    private int counter5 = 0;
    private int counter6 = 0;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listener);

        textView1 = findViewById(R.id.textView1); // Это плохая практика
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);

        textView1.setText(String.valueOf(counter1));
        textView2.setText(String.valueOf(counter2));
        textView3.setText(String.valueOf(counter3));
        textView4.setText(String.valueOf(counter4));
        textView5.setText(String.valueOf(counter5));
        textView6.setText(String.valueOf(counter6));

        button2 = findViewById(R.id.button2);
        // Делаем правильный обработчик нажатий
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                textView2.setText(String.valueOf(counter2));
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
/*        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;
                textView3.setText(String.valueOf(counter3));
            }
        });
*/
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(listener);

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(listener);
    }

    // Плохой метод
    public void onBadClick(View view) {
        if (view .getId() == R.id.button1)
        {
            onToast("button1");
            counter1++;
            textView1.setText(String.valueOf(counter1));
        }
        else
        {
            onToast("button2");
        }
    }

    public void onToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d("mylogs", message);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button5:
                    counter5++;
                    textView5.setText(String.valueOf(counter5));
                    break;
                case R.id.button6:
                    counter6++;
                    textView6.setText(String.valueOf(counter6));
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button3:
                counter3++;
                textView3.setText(String.valueOf(counter3));
                break;
            case R.id.button4:
                counter4++;
                textView4.setText(String.valueOf(counter4));
                break;
        }
    }
}