package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection04Binding;
import com.example.hassannaqvi.mnch_src_2.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;


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
////                MainApp.endActivity(this, this, EndingActivity.class, true, fc);
//            } else {
//                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    private void SaveDraft() throws JSONException {

        JSONObject s04 = new JSONObject();

        s04.put("mnd01a", bi.mnd01a.isChecked() ? "1" : "0");
        s04.put("mnd01b", bi.mnd01b.isChecked() ? "2" : "0");
        s04.put("mnd01c", bi.mnd01c.isChecked() ? "3" : "0");
        s04.put("mnd01d", bi.mnd01d.isChecked() ? "4" : "0");
        s04.put("mnd01e", bi.mnd01e.isChecked() ? "5" : "0");
        s04.put("mnd01f", bi.mnd01f.isChecked() ? "6" : "0");
        s04.put("mnd01g", bi.mnd01g.isChecked() ? "7" : "0");
        s04.put("mnd01h", bi.mnd01h.isChecked() ? "8" : "0");
        s04.put("mnd01i", bi.mnd01i.isChecked() ? "9" : "0");
        s04.put("mnd01j", bi.mnd01j.isChecked() ? "10" : "0");
        s04.put("mnd0196", bi.mnd0196.isChecked() ? "96" : "0");
        s04.put("mnd0198", bi.mnd0198.isChecked() ? "98" : "0");
        s04.put("mnd0197", bi.mnd0197.isChecked() ? "97" : "0");
        s04.put("mnd0196x", bi.mnd0196x.getText().toString());

        s04.put("mnd02a", bi.mnd02a.isChecked() ? "1" : "0");
        s04.put("mnd02b", bi.mnd02b.isChecked() ? "2" : "0");
        s04.put("mnd02c", bi.mnd02c.isChecked() ? "3" : "0");
        s04.put("mnd02d", bi.mnd02d.isChecked() ? "4" : "0");
        s04.put("mnd02e", bi.mnd02e.isChecked() ? "5" : "0");
        s04.put("mnd02f", bi.mnd02f.isChecked() ? "6" : "0");
        s04.put("mnd02g", bi.mnd02g.isChecked() ? "7" : "0");
        s04.put("mnd02h", bi.mnd02h.isChecked() ? "8" : "0");
        s04.put("mnd02i", bi.mnd02i.isChecked() ? "9" : "0");
        s04.put("mnd02j", bi.mnd02j.isChecked() ? "10" : "0");
        s04.put("mnd0296", bi.mnd0296.isChecked() ? "96" : "0");
        s04.put("mnd0298", bi.mnd0298.isChecked() ? "98" : "0");
        s04.put("mnd0297", bi.mnd0297.isChecked() ? "97" : "0");
        s04.put("mnd0296x", bi.mnd0296x.getText().toString());

        s04.put("mnd03",bi.mnd03a.isChecked()? "1"
                : bi.mnd03b.isChecked()? "2"
                : bi.mnd03c.isChecked()? "98" : "0");

        s04.put("mnd04",bi.mnd04a.isChecked()? "1"
                : bi.mnd04b.isChecked()? "2"
                : bi.mnd04c.isChecked()? "98" : "0");

        s04.put("mnd05",bi.mnd05a.isChecked()? "1"
                : bi.mnd05b.isChecked()? "2"
                : bi.mnd05c.isChecked()? "98" : "0");
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
