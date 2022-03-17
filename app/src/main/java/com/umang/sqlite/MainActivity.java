package com.umang.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Button addButton;
    private EditText searchText;
    private ArrayAdapter<Person> adapter;
    private SQL sql;
    private  ListView listView;
    private  CardAdapter cardAdapter;


    private Button backButton,insertButton;
    private  EditText name,office,salary;
    private Switch mode;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton=findViewById(R.id.add_button);
        searchText=findViewById(R.id.search_text);
        sql=new SQL(this);
        listView=findViewById(R.id.listview);
        addButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
//                Fragment fragment=new AddData(false,new Person());
//                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.main_page,fragment,null).commit();
                Person person=new Person("First",32000,"INDIA",false,0);
                if(sql.addPerson(person)) { toast("SUCCESS"); updateList("");}
                else toast("FAILED");

            }
        });
        updateList("");
        listView.setOnItemClickListener(this);


        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                updateList(searchText.getText().toString());

            }
        });


    }

    private void updateList(String str){
        cardAdapter=new CardAdapter(this,0,sql.getList(str));
        listView.setAdapter(cardAdapter);
    }

    private void toast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Person person=adapter.getItem(i);
        toast(person.toString());

    }

    private void backButtonPressed(){

    }
}