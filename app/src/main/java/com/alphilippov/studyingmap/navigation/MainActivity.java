package com.alphilippov.studyingmap.navigation;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.alphilippov.studyingmap.R;


public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mRegistrationUser = findViewById(R.id.saveButton);
        Button mLogInUser = findViewById(R.id.logIn);


        //TODO: отправить в БД
        mRegistrationUser.setOnClickListener(view -> {

            String url = "http://192.168.1.33:5000/profession";
            Intent i = new Intent();
            i.setPackage("com.android.chrome");
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);


        });
        mLogInUser.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NavigationDrawer.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "Fine!", Toast.LENGTH_SHORT);
            toast.show();
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


}
