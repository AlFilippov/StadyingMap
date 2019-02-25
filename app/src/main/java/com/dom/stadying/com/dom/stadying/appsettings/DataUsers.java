package com.dom.stadying.com.dom.stadying.appsettings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dom.stadying.R;

public class DataUsers extends Fragment  {
    SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "myData";
    public static final String APP_PREFERENCES_LOGIN = " ";
    public static final String APP_PREFERENCES_PASSWORD = " ";
    public static String sLoginUser;
    public static String sPasswordUser;
    private static String sInteractionFragment="true";
public static  String APP_INTERACTION_FRAGMENT ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RegistrationUser = inflater.inflate(R.layout.registration_activity, container, false);
        EditText Login = RegistrationUser.findViewById(R.id.nameBox);
        EditText Password = RegistrationUser.findViewById(R.id.passBox);
        Button mRegistrationUser = RegistrationUser.findViewById(R.id.saveButton);
        sLoginUser = Login.getText().toString();
        sPasswordUser = Password.getText().toString();
        if (mSettings.contains(APP_PREFERENCES_LOGIN) && mSettings.contains(APP_PREFERENCES_PASSWORD)) {
            Login.setText(mSettings.getString(APP_PREFERENCES_LOGIN, ""));
            Password.setText(mSettings.getString(APP_PREFERENCES_PASSWORD, ""));
        }
        mRegistrationUser.setOnClickListener(view -> {
Bundle LogInUser= new Bundle();
LogInUser.putString(APP_INTERACTION_FRAGMENT,sInteractionFragment);
            Toast toast =  Toast.makeText(getActivity(), "Успешно", Toast.LENGTH_SHORT);
            toast.show();
        });

        return RegistrationUser;


    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_LOGIN, sLoginUser);
        editor.putString(APP_PREFERENCES_PASSWORD, sPasswordUser);
        editor.apply();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);




    }


}
