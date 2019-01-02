package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection03Binding;

public class Section03Activity extends AppCompatActivity {

    ActivitySection03Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section03);
        bi.setCallback(this);


        setupViews();
    }

    private void setupViews() {

        bi.mnc03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.mnc03a.getId()
                        || checkedId == bi.mnc03b.getId()
                        || checkedId == bi.mnc03c.getId()
                        || checkedId == bi.mnc03d.getId()
                        || checkedId == bi.mnc03e.getId()
                        || checkedId == bi.mnc03f.getId()) {


                    bi.mnc0396x.setVisibility(View.GONE);
                    bi.mnc0396x.setText(null);
                    bi.fldgrpmnc04.setVisibility(View.GONE);
                    bi.fldgrpmnc05.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc06.setVisibility(View.GONE);
                    bi.fldgrpmnc07.setVisibility(View.GONE);
                    bi.fldgrpmnc08.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc09.setVisibility(View.VISIBLE);
                }

                if (checkedId == bi.mnc03g.getId()
                        || checkedId == bi.mnc03h.getId()
                        || checkedId == bi.mnc03i.getId()
                        ) {
                    bi.mnc0396x.setText(null);
                    bi.mnc0396x.setVisibility(View.GONE);
                    bi.fldgrpmnc04.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc05.setVisibility(View.GONE);
                    bi.fldgrpmnc06.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc07.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc08.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc09.setVisibility(View.VISIBLE);

                }

                if (checkedId == bi.mnc03j.getId()) {
                    bi.mnc0396x.setText(null);
                    bi.mnc0396x.setVisibility(View.GONE);
                    bi.fldgrpmnc05.setVisibility(View.GONE);
                    bi.fldgrpmnc06.setVisibility(View.GONE);
                    bi.fldgrpmnc07.setVisibility(View.GONE);
                    bi.fldgrpmnc08.setVisibility(View.GONE);
                    bi.fldgrpmnc09.setVisibility(View.GONE);
                }

                if (checkedId == bi.mnc0397.getId()
                        || checkedId == bi.mnc0398.getId()) {


                    bi.mnc0396x.setVisibility(View.GONE);
                    bi.mnc0396x.setText(null);
                    bi.fldgrpmnc04.setVisibility(View.GONE);
                    bi.fldgrpmnc05.setVisibility(View.GONE);
                    bi.fldgrpmnc06.setVisibility(View.GONE);
                    bi.fldgrpmnc07.setVisibility(View.GONE);
                    bi.fldgrpmnc08.setVisibility(View.GONE);
                    bi.fldgrpmnc09.setVisibility(View.GONE);
                }

                if (checkedId == bi.mnc0396.getId()) {
                    bi.mnc0396x.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc04.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc05.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc06.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc07.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc08.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc09.setVisibility(View.VISIBLE);
                }


            }
        });

        CompoundButton.OnCheckedChangeListener check1 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    bi.fldgrpmnc09.setVisibility(View.GONE);
                } else {
                    bi.fldgrpmnc09.setVisibility(View.VISIBLE);
                }
            }
        };

        bi.mnc08a.setOnCheckedChangeListener(check1);
        bi.mnc0898.setOnCheckedChangeListener(check1);

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
