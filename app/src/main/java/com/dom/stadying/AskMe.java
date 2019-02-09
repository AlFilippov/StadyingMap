package com.dom.stadying;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AskMe extends Fragment implements Button.OnClickListener, ParameterTransfer {
    private ParameterTransfer mParameterTransfer;
    private static final String YES_DECIDED = "ydecided";
    private static final String WANT_DEFENITION = "wdecided";
    private String mKeyTransfer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View askMe = inflater.inflate(R.layout.ask_me, container, false);
        TextView askMe1 = askMe.findViewById(R.id.askMe);
        Button decided = askMe.findViewById(R.id.ydecided);

        Button definition = askMe.findViewById(R.id.wdefinition);
        decided.setOnClickListener(this);
        definition.setOnClickListener(this);
        setParameterTransfer();
        return askMe;
    }

    @Override
    public void onClick(View button) {
        switch (button.getId()) {
            case R.id.ydecided:
                setKeyTransfer(YES_DECIDED);
                break;
            case R.id.wdefinition:
                setKeyTransfer(WANT_DEFENITION);
                break;
        }

    }

    @Override
    public void parameterTransfer(String key) {

    }

    public void setParameterTransfer() {
        String c = getKeyTransfer();
        mParameterTransfer.parameterTransfer(c);
    }


    public String getKeyTransfer() {
        return mKeyTransfer;
    }

    public void setKeyTransfer(String keyTransfer) {
        mKeyTransfer = keyTransfer;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mParameterTransfer = (ParameterTransfer) context;
    }
}
