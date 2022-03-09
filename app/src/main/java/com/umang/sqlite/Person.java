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
}
