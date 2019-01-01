package com.example.hassannaqvi.mnch_src_2.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.hassannaqvi.mnch_src_2.data.AppDatabase;
import com.example.hassannaqvi.mnch_src_2.data.entities.Clusters;
import com.example.hassannaqvi.mnch_src_2.data.entities.Forms;
import com.example.hassannaqvi.mnch_src_2.data.entities.Users;

import java.util.List;

@Dao
public interface GetFncDAO {

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE synced = ''")
    List<Forms> getUnSyncedForms_04_05();

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS)
    List<Forms> getForms_04_05();

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE synced = '' AND formType = :formType")
    List<Forms> getUnSyncedForms_04_05(String formType);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE formType = :formType")
    List<Forms> getForms_04_05(String formType);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE formDate LIKE :date")
    List<Forms> getTodaysForms(String date);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_USERS + " where ROW_USERNAME=:username AND ROW_PASSWORD=:password")
    Users login(String username, String password);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_CLUSTERS + " where cluster_code=:clusterCode")
    Clusters getClusterRecord(String clusterCode);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " where participantID=:child_id and (formType = '1a' or formType = '1b') and istatus = '1' order by id DESC")
    Forms getChildRecord(String child_id);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " where participantID=:part_id and istatus = '1' and formType != '14' order by id DESC")
    Forms checkParticipantExist(String part_id);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " where participantID=:part_id and pdeviation = '1' and istatus = '1' and formType != '14' order by id DESC")
    Forms getParticipantRecord(String part_id);

}
