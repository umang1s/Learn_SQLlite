package com.umang.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CardAdapter extends ArrayAdapter<Person> {

    public CardAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int pos, @Nullable View convertView, @NonNull ViewGroup parent){
        View cur=convertView;
        if(cur==null) cur= LayoutInflater.from(getContext()).inflate(R.layout.card_view,parent,false);
        Person person=getItem(pos);
        TextView nameView=cur.findViewById(R.id.person_name);
        nameView.setText(person.name);

        TextView officeView=cur.findViewById(R.id.person_office);
        nameView.setText(person.office);

        TextView salaryView=cur.findViewById(R.id.person_salary);
        nameView.setText(person.salary);

        TextView modeView=cur.findViewById(R.id.person_mode);
        nameView.setText(person.mode);

        Button updateButton=cur.findViewById(R.id.edit_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button deleteButton=cur.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        return cur;
    }
}
