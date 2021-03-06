package com.example.hassannaqvi.mnch_src_2.RMOperations;

import android.os.AsyncTask;

import com.example.hassannaqvi.mnch_src_2.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by openm on 19-Jul-18.
 */

public class syncOperations extends AsyncTask<String, Void, Long> {

    AppDatabase db;

    public syncOperations(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Long doInBackground(String... fnNames) {

        Long longID = new Long(0);

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(fnNames[1])) {

                    Class<?> fnClass = Class.forName(fnNames[0]);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(fnNames[2])) {

                            longID = Long.valueOf(String.valueOf(fnClass.getMethod(method2.getName())
                                    .invoke(db.getClass().getMethod(fnNames[1]).invoke(db))));

                            break;
                        }
                    }

                    break;
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        return longID;
    }
}
