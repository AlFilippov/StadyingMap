package com.dom.stadying;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String name = "";
    String password = "";
    SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "myData";
    public static final String APP_PREFERENCES_LOGIN = "Login";
    public static final String APP_PREFERENCES_PASSWORD = "Password";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Сохранение значения параметров и разрешение на доступ только компонентам приложения
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        EditText nameBox = findViewById(R.id.nameBox);
        EditText passBox = findViewById(R.id.passBox);
        nameBox.setText(name);
        passBox.setText(password);
        outState.putString(APP_PREFERENCES_LOGIN,nameBox.getText().toString());
        outState.putString(APP_PREFERENCES_PASSWORD,passBox.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //Получение ранее сохранненого состояниея
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        name = savedInstanceState.getString(APP_PREFERENCES_LOGIN);
        password = savedInstanceState.getString(APP_PREFERENCES_PASSWORD);
        EditText nameBox = findViewById(R.id.nameBox);
        EditText passBox = findViewById(R.id.passBox);
        nameBox.setText(name);
        passBox.setText(password);
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void RegistrationButton(View view) {
       Toast toast = Toast.makeText(this,"Успешно",Toast.LENGTH_SHORT);
       toast.show();
        EditText nameBox = findViewById(R.id.nameBox);
        EditText passBox = findViewById(R.id.passBox);
        name = nameBox.getText().toString();
        password = passBox.getText().toString();
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onPause() {
        super.onPause();
        //Сохранение параметров
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_LOGIN, name);
        editor.putString(APP_PREFERENCES_PASSWORD, password);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText nameBox = findViewById(R.id.nameBox);
        EditText passBox = findViewById(R.id.passBox);
        //Проверяем содержание данных , если true то выводим их в EditText
        if (mSettings.contains(APP_PREFERENCES_LOGIN) && mSettings.contains(APP_PREFERENCES_PASSWORD)) {
            name = mSettings.getString(APP_PREFERENCES_LOGIN,"");
            password=mSettings.getString(APP_PREFERENCES_PASSWORD," ");
            nameBox.setText(name);
            passBox.setText(password);

        }
    }
}
