package com.example.hassannaqvi.mnch_src_2.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.JSON.GeneratorClass;
import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.RMOperations.crudOperations;
import com.example.hassannaqvi.mnch_src_2.core.MainApp;
import com.example.hassannaqvi.mnch_src_2.data.DAO.FormsDAO;
import com.example.hassannaqvi.mnch_src_2.data.entities.Forms;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivityInfoBinding;
import com.example.hassannaqvi.mnch_src_2.validation.ClearClass;
import com.example.hassannaqvi.mnch_src_2.validation.validatorClass;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.mnch_src_2.ui.LoginActivity.db;

public class InfoActivity extends AppCompatActivity {

    private static final String TAG = InfoActivity.class.getName();
    ActivityInfoBinding bi;
    public static Forms fc;
    String fTYPE = "", deviceID;
    Class<?> routeClass;
    Forms childDT;
    Forms.Simple_Forms_04_05 sInfo_parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_info);
        bi.setCallback(this);
        deviceID = Settings.Secure.getString(InfoActivity.this.getContentResolver(), Settings.Secure.ANDROID_ID);
        setContentUI();
    }

    private void setContentUI() {

        // mna03
        bi.mna0301.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bi.mna0301.getText().toString().isEmpty()) {
                    ClearClass.ClearRadioButton(bi.mna03, true);
                    bi.mna0301.setTag("-1");
                } else {
                    ClearClass.ClearRadioButton(bi.mna03, false);

                    bi.mna0301.setTag(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bi.mna03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.mna03a.isChecked() || bi.mna03b.isChecked())
                    bi.mna0301.setTag("-1");
            }
        });

        // mna05
        bi.mna05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.mna05b.getId())
                    ClearClass.ClearAllFields(bi.fldgrpmn02, null);
            }
        });

        // mna06
        bi.mna0601.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bi.mna0601.getText().toString().isEmpty()) {
                    ClearClass.ClearRadioButton(bi.mna06, true);
                    bi.mna0601.setTag("-1");
                } else {
                    ClearClass.ClearRadioButton(bi.mna06, false);

                    bi.mna0601.setTag(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bi.mna06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.mna06a.isChecked() || bi.mna06b.isChecked())
                    bi.mna0601.setTag("-1");
            }
        });

        // mna08
        bi.mna0801.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bi.mna0801.getText().toString().isEmpty()) {
                    ClearClass.ClearRadioButton(bi.mna08, true);
                    bi.mna0801.setTag("-1");
                } else {
                    ClearClass.ClearRadioButton(bi.mna08, false);
                    bi.mna0801.setTag(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bi.mna08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.mna08a.isChecked() || bi.mna08b.isChecked())
                    bi.mna0801.setTag("-1");
            }
        });

    }

    public void BtnContinue() {
        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {
            startActivity(new Intent(getApplicationContext(), Section02Activity.class));
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnIDValid() {
        /*if (!validatorClass.EmptyTextBox(this, bi.lsid1, getString(R.string.ls01a01))) {
            return;
        }

        try {
            Object childData = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getChildRecord").execute(bi.lsid1.getText().toString()).get();

            if (childData != null) {
                Toast.makeText(this, "Child ID validate..", Toast.LENGTH_SHORT).show();
                childDT = (Forms) childData;

                // Child Name
                bi.lsid4.setText(childDT.getParticipantName());
                // Form date of enrollment
                bi.lsid5.setText(childDT.getFormDate());

                sInfo_parse = new Gson().fromJson(childDT.getSInfo(), Forms.Simple_Forms_04_05.class);

                // Age setting
                String y, m;
                if (sInfo_parse.getLs01f04().equals("2")) {
                    y = sInfo_parse.getLs01f05y();
                    m = sInfo_parse.getLs01f05m();
                } else {
                    y = String.valueOf(MainApp.ageInYear_MonthByDOB(sInfo_parse.getLs01f03(), 'y'));
                    m = String.valueOf(MainApp.ageInYear_MonthByDOB(sInfo_parse.getLs01f03(), 'm'));
                }
                bi.lsid7y.setText(y);
                bi.lsid7m.setText(m);

                // Round Setting
                bi.lsid10.check(
                        sInfo_parse.getLs01a07().equals("1") ? bi.lsid10a.getId() :
                                sInfo_parse.getLs01a07().equals("2") ? bi.lsid10b.getId() :
                                        sInfo_parse.getLs01a07().equals("3") ? bi.lsid10c.getId() :
                                                sInfo_parse.getLs01a07().equals("4") ? bi.lsid10d.getId() : bi.lsid10a.getId());

                for (byte i = 0; i < bi.lsid10.getChildCount(); i++) {
                    bi.lsid10.getChildAt(i).setEnabled(false);
                }

                // Enable view
                bi.fldgrpls01.setVisibility(VISIBLE);

            } else {
                Toast.makeText(this, "Child ID not found!!", Toast.LENGTH_SHORT).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        bi.fldgrpmna01.setVisibility(View.VISIBLE);

    }

    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "insertForm").get();

            if (longID != 0) {
                fc.setId(longID.intValue());

                fc.setUid(deviceID + fc.getId());

                longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
                return longID == 1;

            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    private void SaveDraft() {

        fc = new Forms();
        fc.setDevicetagID(MainApp.getTagName(this));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setUsername(MainApp.userName);
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setDeviceID(deviceID);

        setGPS(fc); // Set GPS

        /*JSONObject jsonInfo = new JSONObject();
        try {
            jsonInfo.put(fExt + "lsid3", sInfo_parse.getLs01a06());

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrpmna01, true);
//        fc.setSInfo(String.valueOf(mergeJSONObjects(jsonInfo, Json)));

    }

    public void setGPS(Forms fc_4_5) {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            fc_4_5.setGpsLat(lat);
            fc_4_5.setGpsLng(lang);
            fc_4_5.setGpsAcc(acc);
            fc_4_5.setGpsDT(date); // Timestamp is converted to date above
            fc_4_5.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.fldgrpmna01);
    }

    public void BtnEnd() {

        SaveDraft();
        if (UpdateDB()) {
            MainApp.endActivity(this, this, EndingActivity.class, false, fc);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }


}
