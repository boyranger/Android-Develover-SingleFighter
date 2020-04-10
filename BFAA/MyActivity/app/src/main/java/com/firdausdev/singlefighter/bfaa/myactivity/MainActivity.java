package com.firdausdev.singlefighter.bfaa.myactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtLebar, edtTinggi, edtPanjang;
    private Button btnHitung;
    private TextView tvHasil;

    private static final String STATE_RESULT ="state_result";//untuk menyimpan ke onSaveInstanceState()


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLebar = findViewById(R.id.edt_lbr);
        edtPanjang = findViewById(R.id.edt_pjg);
        edtTinggi = findViewById(R.id.edt_tgi);
        btnHitung = findViewById(R.id.btn_hitg);
        tvHasil = findViewById(R.id.tv_hsl);

        btnHitung.setOnClickListener(this);

        if (savedInstanceState!=null){
            String hasil = savedInstanceState.getString(STATE_RESULT);
            tvHasil.setText(hasil);
        }
    }

    @Override
    protected void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvHasil.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_hitg){
         String inputLebar = edtLebar.getText().toString().trim();
         String inputPanjang = edtPanjang.getText().toString().trim();
         String inputTinggi = edtTinggi.getText().toString().trim();



         Boolean isEmpetyFields = false;
         //Cek Field tidak boleh kosong
         if (TextUtils.isEmpty(inputTinggi)){
             isEmpetyFields=true;
             edtTinggi.setError("Jangan dibiarin Kosong Ya!");
         }
         if (TextUtils.isEmpty(inputPanjang)){
             isEmpetyFields=true;
             edtPanjang.setError("Jangan dikosongin dong!");
         }
         if (TextUtils.isEmpty(inputLebar)){
             isEmpetyFields=true;
             edtLebar.setError("Isi donk!!!");
         }

         if (!isEmpetyFields){
             double volume = Double.valueOf(inputPanjang)*Double.valueOf(inputLebar)*Double.valueOf(inputTinggi);
             tvHasil.setText(String.valueOf(volume));
         }
        }
    }
}
