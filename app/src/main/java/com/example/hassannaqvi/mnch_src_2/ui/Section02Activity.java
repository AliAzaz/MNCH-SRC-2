package com.example.hassannaqvi.mnch_src_2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivitySection02Binding;

import org.json.JSONException;
import org.json.JSONObject;

public class Section02Activity extends AppCompatActivity {


    ActivitySection02Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section02);
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
        s02.put("mnb03y",bi.mnb03ax.getText().toString());
    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {

        return true;
    }
}
