package com.example.hassannaqvi.mnch_src_2.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.RMOperations.crudOperations;
import com.example.hassannaqvi.mnch_src_2.core.MainApp;
import com.example.hassannaqvi.mnch_src_2.data.DAO.FormsDAO;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection03Binding;
import com.example.hassannaqvi.mnch_src_2.validation.ClearClass;
import com.example.hassannaqvi.mnch_src_2.validation.ValidatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.mnch_src_2.ui.LoginActivity.db;

public class Section03Activity extends AppCompatActivity {

    ActivitySection03Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section03);
        bi.setCallback(this);

        settingListeners();
    }

    private void settingListeners() {

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

        // 06
        bi.mnc0698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll06c, false);
                    bi.fldGrpll06c.setTag("-1");

                    bi.mnc0698.setTag(null);
                } else {
                    bi.mnc0698.setTag("-1");

                    bi.fldGrpll06c.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll06c, true);
                }
            }
        });

        // 07
        bi.mnc0798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll07c, false);
                    bi.fldGrpll07c.setTag("-1");

                    bi.mnc0798.setTag(null);
                } else {
                    bi.mnc0798.setTag("-1");

                    bi.fldGrpll07c.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll07c, true);
                }
            }
        });

        // 08
        bi.mnc0898.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll08c, false);
                    bi.fldGrpll08c.setTag("-1");

                    bi.mnc0898.setTag(null);
                } else {
                    bi.mnc0898.setTag("-1");

                    bi.fldGrpll08c.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll08c, true);
                }
            }
        });

        // 10
        bi.mnc1098.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll10c, false);
                    bi.fldGrpll10c.setTag("-1");

                    bi.mnc1098.setTag(null);
                } else {
                    bi.mnc1098.setTag("-1");

                    bi.fldGrpll10c.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll10c, true);
                }
            }
        });

        // 12
        bi.mnc1298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll12c, false);
                    bi.fldGrpll12c.setTag("-1");

                    bi.mnc1298.setTag(null);
                } else {
                    bi.mnc1298.setTag("-1");

                    bi.fldGrpll12c.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll12c, true);
                }
            }
        });

        // 13
        bi.mnc1398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.fldGrpll13c, false);
                    bi.fldGrpll13c.setTag("-1");

                    bi.mnc1398.setTag(null);
                } else {
                    bi.mnc1398.setTag("-1");

                    bi.fldGrpll13c.setTag(null);
                    ClearClass.ClearAllFields(bi.fldGrpll13c, true);
                }
            }
        });

    }

    private void SaveDraft() throws JSONException {

        JSONObject s03 = new JSONObject();

        s03.put("mnc01", bi.mnc01a.isChecked() ? "1"
                : bi.mnc01b.isChecked() ? "2"
                : bi.mnc0198.isChecked() ? "3" : "0");

        s03.put("mnc02", bi.mnc02.getText().toString());

        s03.put("mnc03", bi.mnc03a.isChecked() ? "1"
                : bi.mnc03b.isChecked() ? "2"
                : bi.mnc03c.isChecked() ? "3"
                : bi.mnc03d.isChecked() ? "4"
                : bi.mnc03e.isChecked() ? "5"
                : bi.mnc03f.isChecked() ? "6"
                : bi.mnc03g.isChecked() ? "7"
                : bi.mnc03h.isChecked() ? "8"
                : bi.mnc03i.isChecked() ? "9"
                : bi.mnc03j.isChecked() ? "10"
                : bi.mnc0396.isChecked() ? "96"
                : bi.mnc0397.isChecked() ? "97"
                : bi.mnc0398.isChecked() ? "98"
                : "0");
        s03.put("mnc0396x", bi.mnc0396x.getText().toString());

        s03.put("mnc04", bi.mnc04a.isChecked() ? "1"
                : bi.mnc04b.isChecked() ? "2"
                : bi.mnc04c.isChecked() ? "3"
                : bi.mnc04c.isChecked() ? "3"
                : bi.mnc0498.isChecked() ? "98"
                : "0");

        s03.put("mnc05", bi.mnc05a.isChecked() ? "1"
                : bi.mnc05b.isChecked() ? "2"
                : bi.mnc05c.isChecked() ? "3"
                : bi.mnc05d.isChecked() ? "4"
                : bi.mnc0596.isChecked() ? "96"
                : bi.mnc0598.isChecked() ? "98"
                : "0");
        s03.put("mnc0596x", bi.mnc0596x.getText().toString());

        s03.put("mnc06a", bi.mnc06a.isChecked() ? "1" : "0");
        s03.put("mnc06b", bi.mnc06b.isChecked() ? "2" : "0");
        s03.put("mnc06c", bi.mnc06c.isChecked() ? "3" : "0");
        s03.put("mnc06d", bi.mnc06d.isChecked() ? "4" : "0");
        s03.put("mnc06e", bi.mnc06e.isChecked() ? "5" : "0");
        s03.put("mnc06f", bi.mnc06f.isChecked() ? "6" : "0");
        s03.put("mnc0698", bi.mnc0698.isChecked() ? "98" : "0");

        s03.put("mnc07a", bi.mnc07a.isChecked() ? "1" : "0");
        s03.put("mnc07b", bi.mnc07b.isChecked() ? "2" : "0");
        s03.put("mnc07c", bi.mnc07c.isChecked() ? "3" : "0");
        s03.put("mnc0796", bi.mnc0796.isChecked() ? "96" : "0");
        s03.put("mnc0798", bi.mnc0798.isChecked() ? "98" : "0");

        s03.put("mnc0796x", bi.mnc0796x.getText().toString());

        s03.put("mnc08a", bi.mnc08a.isChecked() ? "1" : "0");
        s03.put("mnc08b", bi.mnc08b.isChecked() ? "2" : "0");
        s03.put("mnc08c", bi.mnc08c.isChecked() ? "3" : "0");
        s03.put("mnc08d", bi.mnc08d.isChecked() ? "4" : "0");
        s03.put("mnc0898", bi.mnc0898.isChecked() ? "98" : "0");

        s03.put("mnc09", bi.mnc09a.isChecked() ? "1"
                : bi.mnc09b.isChecked() ? "2"
                : bi.mnc09c.isChecked() ? "3"
                : bi.mnc0996.isChecked() ? "96"
                : "0");

        s03.put("mnc0996x", bi.mnc0996x.getText().toString());

        s03.put("mnc10a", bi.mnc10a.isChecked() ? "1" : "0");
        s03.put("mnc10b", bi.mnc10b.isChecked() ? "2" : "0");
        s03.put("mnc10c", bi.mnc10c.isChecked() ? "3" : "0");
        s03.put("mnc10d", bi.mnc10d.isChecked() ? "4" : "0");
        s03.put("mnc10e", bi.mnc10e.isChecked() ? "5" : "0");
        s03.put("mnc1096", bi.mnc1096.isChecked() ? "96" : "0");
        s03.put("mnc1098", bi.mnc1098.isChecked() ? "98" : "0");

        s03.put("mnc1096x", bi.mnc1096x.getText().toString());

        s03.put("mnc11", bi.mnc11a.isChecked() ? "1"
                : bi.mnc11b.isChecked() ? "2"
                : bi.mnc11c.isChecked() ? "3"
                : bi.mnc1196.isChecked() ? "96"
                : bi.mnc1198.isChecked() ? "98"
                : "0");
        s03.put("mnc1196x", bi.mnc1196x.getText().toString());

        s03.put("mnc12a", bi.mnc12a.isChecked() ? "1" : "0");
        s03.put("mnc12b", bi.mnc12b.isChecked() ? "2" : "0");
        s03.put("mnc12c", bi.mnc12c.isChecked() ? "3" : "0");
        s03.put("mnc12d", bi.mnc12d.isChecked() ? "4" : "0");
        s03.put("mnc1298", bi.mnc1298.isChecked() ? "98" : "0");

        s03.put("mnc13a", bi.mnc06a.isChecked() ? "1" : "0");
        s03.put("mnc13b", bi.mnc06b.isChecked() ? "2" : "0");
        s03.put("mnc13c", bi.mnc06c.isChecked() ? "3" : "0");
        s03.put("mnc13d", bi.mnc06d.isChecked() ? "4" : "0");
        s03.put("mnc13e", bi.mnc06e.isChecked() ? "5" : "0");
        s03.put("mnc13f", bi.mnc06f.isChecked() ? "6" : "0");
        s03.put("mnc13g", bi.mnc13g.isChecked() ? "7" : "0");
        s03.put("mnc1398", bi.mnc0698.isChecked() ? "98" : "0");

        s03.put("mnc14", bi.mnc14a.isChecked() ? "1"
                : bi.mnc14b.isChecked() ? "2"
                : bi.mnc1498.isChecked() ? "98"
                : "0");
        s03.put("mnc15", bi.mnc15.getText().toString());

        InfoActivity.fc.setSa3(String.valueOf(s03));

    }

    public void BtnContinue() {
        if (!formValidation())
            return;
        try {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(this, Section04Activity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc);
    }

    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, InfoActivity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSec03a);
    }
}
