package com.firdausdev.singlefighter.bfaa.meintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithData extends AppCompatActivity {
    //#2.3 kondisikan menerima data asal
    public static final  String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        //#2.1 casting Textview
        TextView tvDataReceived = findViewById(R.id.tv_data_received);
        //#2.3 get getIntent().getStringExtra(key). untuk mengambil data dengan key parameter
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);

        String text ="Name : "+name + ", Your Age : "+ age;
        tvDataReceived.setText(text);
    }
}
