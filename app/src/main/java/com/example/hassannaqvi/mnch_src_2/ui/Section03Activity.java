package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection03Binding;

public class Section03Activity extends AppCompatActivity {

    ActivitySection03Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this,R.layout.activity_section03);
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

    private void SaveDraft() {
    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {

        return true;
    }
}
