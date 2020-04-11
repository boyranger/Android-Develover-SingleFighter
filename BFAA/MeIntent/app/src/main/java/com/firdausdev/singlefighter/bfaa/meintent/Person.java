package com.firdausdev.singlefighter.bfaa.meintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name, email,city;
    private int age;

    protected Person(Parcel in) {
        name = in.readString();
        email = in.readString();
        city = in.readString();
        age = in.readInt();
    }

    public Person() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(city);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    //#1.4Inten Explicit Parclable
    // setter-getter
    // add implement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
