package com.example.hassannaqvi.mnch_src_2.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection02Binding;
import com.example.hassannaqvi.mnch_src_2.validation.ClearClass;
import com.example.hassannaqvi.mnch_src_2.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class Section02Activity extends AppCompatActivity {

    ActivitySection02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section02);
        bi.setCallback(this);

        settingLisners();
    }

    public void settingLisners() {

        bi.mnb0698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll06a, false);
                    bi.fldGrpll06a.setTag("-1");
                } else {
                    bi.fldGrpll06a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll06a, true);
                }
            }
        });

        bi.mnb0798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll07a, false);
                    bi.fldGrpll07a.setTag("-1");
                } else {
                    bi.fldGrpll07a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll07a, true);
                }
            }
        });

        bi.mnb0898.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll08a, false);
                    bi.fldGrpll08a.setTag("-1");
                } else {
                    bi.fldGrpll08a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll08a, true);
                }
            }
        });

        bi.mnb0998.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll09a, false);
                    bi.fldGrpll09a.setTag("-1");
                } else {
                    bi.fldGrpll09a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll09a, true);
                }
            }
        });

        bi.mnb1098.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll10a, false);
                    bi.fldGrpll10a.setTag("-1");
                } else {
                    bi.fldGrpll10a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll10a, true);
                }
            }
        });

        CheckBox.OnCheckedChangeListener checked11 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.getId() == bi.mnb1197.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpll11a, false);
                    bi.fldGrpll11a.setTag("-1");
                    bi.mnb1198.setEnabled(false);
                    bi.mnb1198.setTag("-1");
                } else if (compoundButton.getId() == bi.mnb1198.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpll11a, false);
                    bi.fldGrpll11a.setTag("-1");
                    bi.mnb1197.setEnabled(false);
                    bi.mnb1197.setTag("-1");
                } else {
                    bi.fldGrpll11a.setTag(null);
                    bi.mnb1197.setTag(null);
                    bi.mnb1198.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll11a, true);
                }
            }
        };
        bi.mnb1197.setOnCheckedChangeListener(checked11);
        bi.mnb1198.setOnCheckedChangeListener(checked11);

        bi.mnb1398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll13a, false);
                    bi.fldGrpll13a.setTag("-1");
                } else {
                    bi.fldGrpll13a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll13a, true);
                }
            }
        });

        bi.mnb1498.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll14a, false);
                    bi.fldGrpll14a.setTag("-1");
                } else {
                    bi.fldGrpll14a.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll14a, true);
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
                startActivity(new Intent(this, Section03Activity.class));
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

        JSONObject s02 = new JSONObject();

        s02.put("mnb01", bi.mnb01a.isChecked() ? "1"
                : bi.mnb01b.isChecked() ? "2"
                : bi.mnb01c.isChecked() ? "3"
                : bi.mnb0198.isChecked() ? "98" : "0");

        s02.put("mnb02", bi.mnb02a.isChecked() ? "1"
                : bi.mnb02b.isChecked() ? "2"
                : bi.mnb02c.isChecked() ? "3"
                : bi.mnb02d.isChecked() ? "98" : "0");

        s02.put("mnb03", bi.mnb03a.isChecked() ? "1"
                : bi.mnb03b.isChecked() ? "2"
                : bi.mnb0398.isChecked() ? "98"
                : "0");
        s02.put("mnb03y", bi.mnb03ax.getText().toString());

        s02.put("mnb04", bi.mnb04a.isChecked() ? "1"
                : bi.mnb04b.isChecked() ? "2"
                : bi.mnb04c.isChecked() ? "3"
                : bi.mnb04d.isChecked() ? "98" : "0");

        s02.put("mnb05", bi.mnb05a.isChecked() ? "1"
                : bi.mnb05b.isChecked() ? "2"
                : bi.mnb05c.isChecked() ? "3"
                : bi.mnb05d.isChecked() ? "4"
                : bi.mnb05e.isChecked() ? "5"
                : bi.mnb05f.isChecked() ? "6"
                : bi.mnb05g.isChecked() ? "7"
                : bi.mnb05h.isChecked() ? "8"
                : bi.mnb05i.isChecked() ? "9"
                : bi.mnb05j.isChecked() ? "10"
                : bi.mnb0596.isChecked() ? "96"
                : bi.mnb0597.isChecked() ? "97"
                : bi.mnb0598.isChecked() ? "98"
                : "0");

        s02.put("mnb0596x", bi.mnb0596x.getText().toString());

        s02.put("mnb06a", bi.mnb06a.isChecked() ? "1" : "0");
        s02.put("mnb06b", bi.mnb06b.isChecked() ? "2" : "0");
        s02.put("mnb06c", bi.mnb06c.isChecked() ? "3" : "0");
        s02.put("mnb06d", bi.mnb06d.isChecked() ? "4" : "0");
        s02.put("mnb0698", bi.mnb0698.isChecked() ? "98" : "0");

        s02.put("mnb07a", bi.mnb07a.isChecked() ? "1" : "0");
        s02.put("mnb07b", bi.mnb07b.isChecked() ? "2" : "0");
        s02.put("mnb07c", bi.mnb07c.isChecked() ? "3" : "0");
        s02.put("mnb07d", bi.mnb07d.isChecked() ? "4" : "0");
        s02.put("mnb0798", bi.mnb0798.isChecked() ? "98" : "0");

        s02.put("mnb08a", bi.mnb08a.isChecked() ? "1" : "0");
        s02.put("mnb08b", bi.mnb08b.isChecked() ? "2" : "0");
        s02.put("mnb08c", bi.mnb08c.isChecked() ? "3" : "0");
        s02.put("mnb08d", bi.mnb08d.isChecked() ? "4" : "0");
        s02.put("mnb0898", bi.mnb0898.isChecked() ? "98" : "0");

        s02.put("mnb09a", bi.mnb09a.isChecked() ? "1" : "0");
        s02.put("mnb09b", bi.mnb09b.isChecked() ? "2" : "0");
        s02.put("mnb09c", bi.mnb09c.isChecked() ? "3" : "0");
        s02.put("mnb09d", bi.mnb09d.isChecked() ? "4" : "0");
        s02.put("mnb0998", bi.mnb0998.isChecked() ? "98" : "0");


        s02.put("mnb10a", bi.mnb10a.isChecked() ? "1" : "0");
        s02.put("mnb10b", bi.mnb10b.isChecked() ? "2" : "0");
        s02.put("mnb10c", bi.mnb10c.isChecked() ? "3" : "0");
        s02.put("mnb10d", bi.mnb10d.isChecked() ? "4" : "0");
        s02.put("mnb10e", bi.mnb10e.isChecked() ? "5" : "0");
        s02.put("mnb10f", bi.mnb10f.isChecked() ? "6" : "0");
        s02.put("mnb10g", bi.mnb10g.isChecked() ? "7" : "0");
        s02.put("mnb10h", bi.mnb10h.isChecked() ? "8" : "0");
        s02.put("mnb10i", bi.mnb10i.isChecked() ? "9" : "0");
        s02.put("mnb1096", bi.mnb1096.isChecked() ? "9" : "0");
        s02.put("mnb1098", bi.mnb1098.isChecked() ? "98" : "0");

        s02.put("mnb1096x", bi.mnb1096x.getText().toString());

        s02.put("mnb11a", bi.mnb11a.isChecked() ? "1" : "0");
        s02.put("mnb11b", bi.mnb11b.isChecked() ? "2" : "0");
        s02.put("mnb11c", bi.mnb11c.isChecked() ? "3" : "0");
        s02.put("mnb11d", bi.mnb11d.isChecked() ? "4" : "0");
        s02.put("mnb11e", bi.mnb11e.isChecked() ? "5" : "0");
        s02.put("mnb1197", bi.mnb1197.isChecked() ? "97" : "0");
        s02.put("mnb1198", bi.mnb1198.isChecked() ? "98" : "0");

        s02.put("mnb12", bi.mnb12a.isChecked() ? "1"
                : bi.mnb12b.isChecked() ? "2"
                : bi.mnb12c.isChecked() ? "98"
                : "0");

        s02.put("mnb13a", bi.mnb13a.isChecked() ? "1" : "0");
        s02.put("mnb13b", bi.mnb13b.isChecked() ? "2" : "0");
        s02.put("mnb13c", bi.mnb13c.isChecked() ? "3" : "0");
        s02.put("mnb13d", bi.mnb13d.isChecked() ? "4" : "0");
        s02.put("mnb13e", bi.mnb13e.isChecked() ? "5" : "0");
        s02.put("mnb13f", bi.mnb13f.isChecked() ? "6" : "0");
        s02.put("mnb13g", bi.mnb13g.isChecked() ? "7" : "0");
        s02.put("mnb13h", bi.mnb13h.isChecked() ? "8" : "0");
        s02.put("mnb1396", bi.mnb1396.isChecked() ? "96" : "0");
        s02.put("mnb1398", bi.mnb1398.isChecked() ? "98" : "0");

        s02.put("mnb1396x", bi.mnb1396x.getText().toString());

        s02.put("mnb14a", bi.mnb14a.isChecked() ? "1" : "0");
        s02.put("mnb14b", bi.mnb14b.isChecked() ? "2" : "0");
        s02.put("mnb14c", bi.mnb14c.isChecked() ? "3" : "0");
        s02.put("mnb14d", bi.mnb14d.isChecked() ? "4" : "0");
        s02.put("mnb14e", bi.mnb14e.isChecked() ? "5" : "0");
        s02.put("mnb14f", bi.mnb14f.isChecked() ? "6" : "0");
        s02.put("mnb14g", bi.mnb14g.isChecked() ? "7" : "0");
        s02.put("mnb14h", bi.mnb14h.isChecked() ? "8" : "0");
        s02.put("mnb14i", bi.mnb14i.isChecked() ? "9" : "0");
        s02.put("mnb1496", bi.mnb1496.isChecked() ? "96" : "0");
        s02.put("mnb1498", bi.mnb1498.isChecked() ? "98" : "0");

        s02.put("mnb1496x", bi.mnb1496x.getText().toString());
    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.fldGrpSec02a);
    }
}
