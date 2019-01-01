package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection04Binding;
import com.example.hassannaqvi.mnch_src_2.validation.validatorClass;


public class Section04Activity extends AppCompatActivity {


    ActivitySection04Binding bi; // ?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section04);
        bi.setCallback(this);


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


        if (!validatorClass.EmptyCheckBox(this, bi.mnd01, bi.mnd01a, getString(R.string.mnd01))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, bi.mnd02, bi.mnd02a, getString(R.string.mnd02))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.mnd03, bi.mnd03a, getString(R.string.mnd03))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.mnd04, bi.mnd04a, getString(R.string.mnd04))) {
            return false;
        }


        return validatorClass.EmptyRadioButton(this, bi.mnd05, bi.mnd05a, getString(R.string.mnd05));
    }
}
