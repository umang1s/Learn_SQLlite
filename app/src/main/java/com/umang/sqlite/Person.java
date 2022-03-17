package com.umang.sqlite;

public class Person {
    String name,office,mode;
    int salary;
    int id;


    public Person(String name, int salary,String office,boolean mode,int id) {
        this.name = name;
        this.id=id;
        this.salary = salary;
        this.office=office;
        if(mode) this.mode="Offline";
        else this.mode="Online";
    }
    public  Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", office='" + office + '\'' +
                ", mode='" + mode + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public boolean matchKey(String key){
        if( key.length()==0) return true;

        boolean isInteger=true;
        for(int i=0; i<key.length() && isInteger; i++)  if(key.charAt(i)<'0' || key.charAt(i)>'9') isInteger=false;
        if(isInteger){
            int val=Integer.parseInt(key);
            return val==id || val==salary;
        }
        String l_name=name.toLowerCase();
        String l_office=office.toLowerCase();
        String l_mode=mode.toLowerCase();

        return l_name.contains(key)|| l_office.contains(key) || l_mode.contains(key);
    }
}
