package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection04Binding;

public class Section04Activity extends AppCompatActivity {

    ActivitySection04Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section04);
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
