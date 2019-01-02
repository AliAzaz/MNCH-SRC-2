package com.example.hassannaqvi.mnch_src_2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

                if( checkedId == bi.mnc03a.getId()
                        || checkedId == bi.mnc03b.getId()
                        || checkedId == bi.mnc03c.getId()
                        || checkedId == bi.mnc03d.getId()
                        || checkedId == bi.mnc03e.getId()
                        || checkedId == bi.mnc03f.getId()){


                    bi.fldgrpmnc04.setVisibility(View.GONE);
                    bi.fldgrpmnc05.setVisibility(View.VISIBLE);
                }

                if(checkedId == bi.mnc03g.getId()
                        || checkedId == bi.mnc03h.getId()
                        || checkedId == bi.mnc03i.getId()
                        || checkedId == bi.mnc03j.getId()){
                    bi.fldgrpmnc04.setVisibility(View.VISIBLE);
                    bi.fldgrpmnc05.setVisibility(View.GONE);
                }


            }
        });

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
