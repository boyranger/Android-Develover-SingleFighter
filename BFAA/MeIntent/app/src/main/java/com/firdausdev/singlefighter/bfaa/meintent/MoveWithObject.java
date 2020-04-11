package com.firdausdev.singlefighter.bfaa.meintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObject extends AppCompatActivity {
    //#kedua key parameter untuk menerima object dari asal
    public static final String EXTRA_PERSON ="extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        //#pertama casting textview
        TextView tvObject = findViewById(R.id.tv_object_received);

        //#ketiga kode untuk Intent menerima data
        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + person.getName()+ ", \nEmail : "+ person.getEmail() + ", \nAge"+
                person.getAge()+ ", \nLocation : "+ person.getCity();
        tvObject.setText(text);
    }
}
