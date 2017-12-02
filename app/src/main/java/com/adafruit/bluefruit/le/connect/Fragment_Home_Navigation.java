package com.adafruit.bluefruit.le.connect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by narasakumar on 7/30/17.
 */

public class Fragment_Home_Navigation extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home_navigation,container,false);
//        return super.onCreateView(inflater, container, savedInstanceState);

        TextView tvDisplay=(TextView)view.findViewById(R.id.textView_HomeDisplay);

        tvDisplay.setText("Welcome to Fall Detection (295B Project).\n \n" +
                "Use the navigation menu to choose functionality and press BACK button to come back to this menu.");
        getActivity().setTitle("Home");
        return view;
    }
}
