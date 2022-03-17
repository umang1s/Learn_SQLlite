package com.umang.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SQL extends SQLiteOpenHelper {
    private  Context context;
    SQL(Context context){
        //initialize data
        super(context,"person.db",null,1);
        this.context=context;
    }

    public boolean addPerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NAME",person.name);
        cv.put("SALARY",person.salary);
        cv.put("MODE",person.mode);
        cv.put("OFFICE",person.office);
        long insert=db.insert("PERSON",null,cv);
        return insert!=-1;
    }

    List<Person> getList(String key){
        List<Person> person=new ArrayList<>();
        String query_statement="SELECT * FROM PERSON";
        SQLiteDatabase db=this.getReadableDatabase();
        try (Cursor cursor = db.rawQuery(query_statement,null )) {
            if (cursor.moveToFirst()) {
                do{
                    Person temp=new Person(cursor.getString(1),cursor.getInt(2),cursor.getString(4),cursor.getString(3)=="Online",cursor.getInt(0));
                    if(temp.matchKey(key)) person.add(temp);
                }while(cursor.moveToNext());
            }
            cursor.close();
            db.close();
        }
        return person;
    }

    boolean updatePerson(Person person){
//        SQLiteDatabase db=this.getWritableDatabase();
//        String query="UPDATE FROM PERSON WHERE ID "+person.id;
//        db.execSQL(query);
//        db.close();
        return true;
    }

    boolean deletePerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM PERSON WHERE ID="+person.id;
        db.execSQL(query);
        db.close();
        Log.d("de",person.toString());
        return true;
    }

    private void toast(String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableReference="PERSON(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,SALARY INT,MODE TEXT,OFFICE TEXT)";
        String createTableStatements="CREATE TABLE "+tableReference;
        sqLiteDatabase.execSQL(createTableStatements);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
