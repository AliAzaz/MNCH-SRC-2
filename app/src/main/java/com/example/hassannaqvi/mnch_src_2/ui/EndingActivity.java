package com.example.hassannaqvi.mnch_src_2.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hassannaqvi.mnch_src_2.R;
import com.example.hassannaqvi.mnch_src_2.RMOperations.crudOperations;
import com.example.hassannaqvi.mnch_src_2.data.DAO.FormsDAO;
import com.example.hassannaqvi.mnch_src_2.data.entities.Forms;
import com.example.hassannaqvi.mnch_src_2.data.entities.Forms_04_05;
import com.example.hassannaqvi.mnch_src_2.databinding.ActivityEndingBinding;
import com.example.hassannaqvi.mnch_src_2.validation.validatorClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.mnch_src_2.ui.LoginActivity.db;


public class EndingActivity extends AppCompatActivity {

    private static final String TAG = EndingActivity.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivityEndingBinding bi;
    Forms_04_05 fc04_05;
    Forms fc_;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setCallback(this);

        this.setTitle("End Interview");

        Boolean check = getIntent().getExtras().getBoolean("complete");

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatusc.setEnabled(false);
            bi.istatusd.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatusc.setEnabled(true);
            bi.istatusd.setEnabled(true);
        }

        flag = getIntent().getBooleanExtra("typeFlag", false);
        if (flag)
            fc_ = (Forms) getIntent().getSerializableExtra("fc_data");
        else
            fc04_05 = (Forms_04_05) getIntent().getSerializableExtra("fc_data");

    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
        if (flag) {
            fc_.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
            fc_.setEndtime(dtToday);

        } else {
            fc04_05.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
            fc04_05.setEndtime(dtToday);
        }
    }

    public boolean UpdateDB() {
        try {
            Long longID = new crudOperations(db, flag ? fc_ : fc04_05).execute(FormsDAO.class.getName(), "formsDao", flag ? "updateForm" : "updateForm_04_05").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean formValidation() {
        return validatorClass.EmptyRadioButton(this, bi.istatus, bi.istatusb, getString(R.string.istatus));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
