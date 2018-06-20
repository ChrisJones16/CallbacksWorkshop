package com.example.christopherjones.callbacksworkshop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CallbackFragment extends Fragment {

    private CallbackClass callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Uses layout created to associate it with this particular fragment
        View view = inflater.inflate(R.layout.fragment_callback, container, false);
        //this tells the Butterknife library to bind the variables in this class to the specified view from above
        ButterKnife.bind(this, view);
        //This takes the view object we created and associate it with this fragment
        return view;
    }

    //Required to be able to instantiate the fragment for use GENERATED FOR US WHEN TYPING IN "NEW" and SELECTING newInstance
    public static CallbackFragment newInstance() {

        Bundle args = new Bundle();

        CallbackFragment fragment = new CallbackFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @OnClick(R.id.toast_callback_button)
    protected void createToast() {
        callback.showToast();
    }

    @OnClick(R.id.change_textview_callback_button)
    protected void changeTextview() {
        callback.changeTextview();

    }

    @OnClick(R.id.change_background_callback_button)
    protected void changeBackground() {
        callback.changeBackgroundColor();
    }

    @OnClick(R.id.remove_framgment_callback_button)
    protected void removeFragment() {
        callback.removeFragment();
    }


    //allows the Callback class to be used or "Called" from classes that implement it
    public void attachParent(CallbackClass callback) {

        this.callback = callback;
    }

    //Inner interface class that allows data to be sent from this fragment to any class that implements it
    public interface CallbackClass {

        void showToast();
        void changeTextview();
        void changeBackgroundColor();
        void removeFragment();

    }


}

