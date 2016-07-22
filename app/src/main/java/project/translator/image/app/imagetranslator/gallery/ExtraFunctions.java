package project.translator.image.app.imagetranslator.gallery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 21/7/16.
 */
public class ExtraFunctions {
    static SQLiteDatabase db;
    public void checkDB(Context context) {
        db = context.openOrCreateDatabase("ImageTranslator", context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS history_data(ID INTEGER PRIMARY KEY AUTOINCREMENT, result TEXT DEFAULT NULL);");
    }

    public boolean insertDB(String result){
        try{
            db.execSQL("INSERT INTO history_data VALUES(NULL,'" + result + "');");
        } catch(SQLiteConstraintException e) {
            Log.i("database", "Already exist" +e);
            return  false;
        }
        Log.i("database", "coming to insert");

        return true;
    }

    public ArrayList getProcessImagesFromDB(Context context){
        checkDB(context);
        ArrayList<String> ar = new ArrayList<String>();
        Cursor c = db.rawQuery("SELECT * FROM history_data ORDER BY ID DESC" , null);
        if(c.moveToFirst()){
            do{
                ar.add(c.getString(c.getColumnIndex("result")));
            }while(c.moveToNext());
        }
        c.close();
        return ar;
    }
}
