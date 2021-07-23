package ru.geekbrains.lessions2345.activitywork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String KEY_PASS_1 = "пассажир_1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
        {
            pass = savedInstanceState.getInt(KEY_PASS_1);
        }
        onToast("pass = " + pass);
        onToast("onCreate() savedInstanceState " + (savedInstanceState == null));
    }

    // -------------------------------------------------
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onToast("onRestoreInstanceState 2s ");
        if (savedInstanceState != null)
        {
            pass = savedInstanceState.getInt(KEY_PASS_1);
        }
        onToast("pass = " + pass);
    }

    int pass = 1;
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState. СОХРАНЕНИЕ
        pass = 2;
        outState.putInt(KEY_PASS_1, pass);
    }

    //---------------------------

    // ГОТОВНОСТЬ К ВЗАИМОДЕЙСТВИЮ С ПОЛЬЗОВАТЕЛЕМ
    @Override
    protected void onResume() {
        super.onResume();
        onToast("onResume");
        // приложение готов к взаимодействию
    }

    @Override
    protected void onPause() {
        super.onPause();
        onToast("onPause");
        // приложение не взаимодейстует с нажатием пользователя
        // музыка выключается ОШИБКА ПОТОМУ ЧТО ОТ СЮДА НЕ ПОЙДЁТ В onStart
    }

    //---------------------------


    // ГОТОВНОСТЬ К ОТОБРАЖЕНИЮ
    @Override
    protected void onStart() {
        super.onStart();
        onToast("onStart");
        // приложение готово к отображению
        // фоновая музыка включается ОШИБКА
    }

    @Override
    protected void onStop() {
        super.onStop();
        onToast("onStop");
        // приложение не отображается
    }
    //---------------------------

    @Override
    protected void onRestart() {
        super.onRestart();
        onToast("onRestart");
        // приложение возобновляется
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onToast("onDestroy");
        // приложение возобновляется
    }

    public void onToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d("mylogs", message);
    }
}