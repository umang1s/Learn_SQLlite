package com.umang.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SQL {
    private SQLiteDatabase db;
    private  Context context;
    private  int count;
    SQL(Context context){
        //initialize data
        count=0;
        this.context=context;
    }

    boolean addPerson(Person person){
        toast("Added : "+person.toString());
        return true;
    }

    List<Person> getList(String key){
        count++;
        List<Person> ret=new ArrayList<>();
        Person dummy1=new Person("First",200000,"INDIA Private",true,232);
        Person dummy2=new Person("Second",200000," Private",false,223);
        Person dummy3=new Person("Third",200000,"INDIA Private",true,22);
        Person dummy4=new Person("Fourth",200000,"Global name",false,2332);
        if(count%3!=0) ret.add(dummy1);
        if(count%3!=1) ret.add(dummy2);
        if(count%3!=2) ret.add(dummy3);
        ret.add(dummy4);
        return ret;
    }

    boolean updatePerson(Person person){
        toast("Updated : "+person.toString());
        return true;
    }

    boolean deletePerson(Person person){
        toast("deleted : "+person.toString());
        return true;
    }

    private void toast(String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
