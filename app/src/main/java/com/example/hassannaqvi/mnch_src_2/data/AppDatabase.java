package com.example.hassannaqvi.mnch_src_2.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.hassannaqvi.mnch_src_2.data.DAO.FormsDAO;
import com.example.hassannaqvi.mnch_src_2.data.DAO.GetFncDAO;
import com.example.hassannaqvi.mnch_src_2.data.entities.Clusters;
import com.example.hassannaqvi.mnch_src_2.data.entities.Forms;
import com.example.hassannaqvi.mnch_src_2.data.entities.Users;

@Database(entities = {Forms.class, Clusters.class, Users.class}, version = AppDatabase.Sub_DBConnection.DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    /*@VisibleForTesting
    public static final String DATABASE_NAME = "wfppishincr.db";
    // Alter table for Database Update
    static final Migration MIGRATION_v2_v3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE forms "
                    + " ADD COLUMN last_update TEXT");
        }
    };*/

    private static AppDatabase sInstance;

    public static AppDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, AppDatabase.class, Sub_DBConnection.DATABASE_NAME)
//                            .addMigrations(MIGRATION_v1_v2, MIGRATION_v2_v3)
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build();
                }
            }
        }
        return sInstance;
    }

    public abstract FormsDAO formsDao();

    public abstract GetFncDAO getFncDao();

    public interface Sub_DBConnection {
        String DATABASE_NAME = "mnch_src2";
        int DATABASE_VERSION = 1;
        String TABLE_FORMS = "forms";
        String TABLE_USERS = "users";
        String TABLE_CLUSTERS = "clusters";
    }
}
