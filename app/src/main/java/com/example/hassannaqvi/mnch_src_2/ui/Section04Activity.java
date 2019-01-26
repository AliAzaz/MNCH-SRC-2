package com.example.hassannaqvi.mnch_src_2.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.RMOperations.crudOperations;
import com.example.hassannaqvi.mnch_src_2.core.MainApp;
import com.example.hassannaqvi.mnch_src_2.data.DAO.FormsDAO;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection04Binding;
import com.example.hassannaqvi.mnch_src_2.validation.ClearClass;
import com.example.hassannaqvi.mnch_src_2.validation.ValidatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.mnch_src_2.ui.LoginActivity.db;

public class Section04Activity extends AppCompatActivity {
    ActivitySection04Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section04);
        bi.setCallback(this);

        setListeners();
    }

    private void setListeners() {
//        01
        bi.mnd0197.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.mnd01, false);
                    bi.mnd01.setTag("-1");

                    bi.mnd0197.setTag(null);

                    bi.mnd0198.setEnabled(false);
                } else {
                    bi.mnd0198.setEnabled(true);

                    bi.mnd0197.setTag("-1");

                    bi.mnd01.setTag(null);
                    ClearClass.ClearAllFields(bi.mnd01, true);
                }
            }
        });
        bi.mnd0198.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.mnd01, false);
                    bi.mnd01.setTag("-1");

                    bi.mnd0198.setTag(null);

                    bi.mnd0197.setEnabled(false);
                } else {
                    bi.mnd0197.setEnabled(true);

                    bi.mnd0198.setTag("-1");

                    bi.mnd01.setTag(null);
                    ClearClass.ClearAllFields(bi.mnd01, true);
                }
            }
        });

//        02
        bi.mnd0297.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.mnd02, false);
                    bi.mnd02.setTag("-1");

                    bi.mnd0297.setTag(null);

                    bi.mnd0298.setEnabled(false);
                } else {
                    bi.mnd0298.setEnabled(true);

                    bi.mnd0297.setTag("-1");

                    bi.mnd02.setTag(null);
                    ClearClass.ClearAllFields(bi.mnd02, true);
                }
            }
        });
        bi.mnd0298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ClearClass.ClearAllFields(bi.mnd02, false);
                    bi.mnd02.setTag("-1");

                    bi.mnd0298.setTag(null);

                    bi.mnd0297.setEnabled(false);
                } else {
                    bi.mnd0297.setEnabled(true);

                    bi.mnd0298.setTag("-1");

                    bi.mnd02.setTag(null);
                    ClearClass.ClearAllFields(bi.mnd02, true);
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
                startActivity(new Intent(this, Section05Activity.class));
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

        s04.put("mnd03", bi.mnd03a.isChecked() ? "1"
                : bi.mnd03b.isChecked() ? "2"
                : bi.mnd03c.isChecked() ? "98" : "0");

        s04.put("mnd04", bi.mnd04a.isChecked() ? "1"
                : bi.mnd04b.isChecked() ? "2"
                : bi.mnd04c.isChecked() ? "98" : "0");

        s04.put("mnd05", bi.mnd05a.isChecked() ? "1"
                : bi.mnd05b.isChecked() ? "2"
                : bi.mnd05c.isChecked() ? "98" : "0");

        InfoActivity.fc.setSa4(String.valueOf(s04));
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
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSection04);
    }
}
