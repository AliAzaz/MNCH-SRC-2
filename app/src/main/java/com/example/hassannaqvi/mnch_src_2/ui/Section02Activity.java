package com.example.hassannaqvi.mnch_src_2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection02Binding;

public class Section02Activity extends AppCompatActivity {


    ActivitySection02Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section02);
    }

    public void BtnContinue() {
        if (!formValidation())
            return;
//        try {
//            SaveDraft();
//            if (UpdateDB()) {
////                MainApp.endActivity(this, this, EndingActivity.class, true, fc_4_5);
//            } else {
//                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    public void BtnEnd() {

    }

    private void SaveDraft() {
    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {

        return true;
    }
}
