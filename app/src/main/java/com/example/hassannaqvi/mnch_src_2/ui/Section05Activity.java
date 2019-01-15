package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection05Binding;
import com.example.hassannaqvi.mnch_src_2.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class Section05Activity extends AppCompatActivity {

    ActivitySection05Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section05);



        setupViews();
    }

    private void setupViews() {

        bi.mne05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == bi.mne05b.getId()
                        || checkedId == bi.mne05c.getId()){
                    bi.fldgrpmne06.setVisibility(View.GONE);
                }else{
                    bi.fldgrpmne06.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void BtnContinue() {
        if (!formValidation())
            return;
        try {
            SaveDraft();
            if (UpdateDB()) {
//                MainApp.endActivity(this, this, EndingActivity.class, true, fc_4_5);
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void BtnEnd() {

    }

    private void SaveDraft() throws JSONException {

        JSONObject s05 = new JSONObject();

        s05.put("mne01",bi.mne01a.isChecked()? "1"
                : bi.mne01b.isChecked()? "2"
                : bi.mne01c.isChecked()? "3"
                : bi.mne01d.isChecked()? "4"
                : bi.mne01e.isChecked()? "5"
                : bi.mne01f.isChecked()? "6"
                : bi.mne01g.isChecked()? "7"
                : bi.mne01h.isChecked()? "8"
                : bi.mne01i.isChecked()? "9"
                : bi.mne01j.isChecked()? "10"
                : bi.mne01k.isChecked()? "11"
                : bi.mne01l.isChecked()? "12"
                : bi.mne01m.isChecked()? "13"
                : bi.mne01n.isChecked()? "14"
                : bi.mne01o.isChecked()? "15"
                : bi.mne0196.isChecked()? "96"
                : "0");

        s05.put("mne0196x",bi.mne0196x.getText().toString());

        s05.put("mne02",bi.mne02a.isChecked()? "1"
                : bi.mne02b.isChecked()? "2"
                : "0");

        s05.put("mne03",bi.mne03.getText().toString());

        s05.put("mne04",bi.mne04a.isChecked()? "1"
                : bi.mne04b.isChecked()? "2"
                : bi.mne04c.isChecked()? "3"
                : bi.mne04d.isChecked()? "4"
                : bi.mne04e.isChecked()? "5"
                : bi.mne04f.isChecked()? "6"
                : bi.mne04g.isChecked()? "7"
                : bi.mne04h.isChecked()? "8"
                : bi.mne04i.isChecked()? "9"
                : bi.mne04j.isChecked()? "10"
                : bi.mne04k.isChecked()? "11"
                : bi.mne04l.isChecked()? "12"
                : bi.mne04m.isChecked()? "13"
                : bi.mne04n.isChecked()? "14"
                : bi.mne04o.isChecked()? "15"
                : bi.mne0496.isChecked()? "96"
                : "0");
        s05.put("mne0496x",bi.mne0496x.getText().toString());

        s05.put("mne05",bi.mne05a.isChecked()? "1"
                : bi.mne05b.isChecked()? "2"
                : bi.mne05c.isChecked()? "3"
                : "0");
        s05.put("mne05min",bi.mne05x.getText().toString());

        s05.put("mne06",bi.mne06a.isChecked()? "1"
                : bi.mne06b.isChecked()? "2"
                : "0");

        s05.put("mne07",bi.mne07a.isChecked()? "1"
                : bi.mne07b.isChecked()? "2"
                : bi.mne07c.isChecked()? "3"
                : bi.mne07d.isChecked()? "4"
                : bi.mne07e.isChecked()? "5"
                : bi.mne07f.isChecked()? "6"
                : bi.mne07g.isChecked()? "7"
                : bi.mne07h.isChecked()? "8"
                : bi.mne07i.isChecked()? "9"
                : bi.mne0796.isChecked()? "96"
                : "0");

        s05.put("mne0796x",bi.mne0796x.getText().toString());

    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {

        if(!validatorClass.EmptyCheckingContainer(this,bi.fldGrpSection05)){
            return false;
        }

        return true;
    }
}
