package com.umang.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton=findViewById(R.id.add_button);
        searchText=findViewById(R.id.search_text);
        sql=new SQL(this);
        listView=findViewById(R.id.listview);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("AddButton Clicked");
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
}