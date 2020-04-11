package com.firdausdev.singlefighter.bfaa.meintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //#1 move without data (intent Explicit
        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        //#2 move with data (intent Explicit
        Button btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        /*
        POJO (Plain Old Java Object)  = class
        Data Classes, menyimpan model data suatu objek, memiliki properti/variabel dan
        metode setter-getter
        u/ aplikasi kompleks
        #3 move with object
         */
        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        //https://developer.android.com/reference/android/content/Intent.html

        //-----------------------------------------------------------------------------------------
        //Inten Implicit
        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                /*
                #1.2 Intent pindah activity
                context = untuk mengakses resource dr activity, mengambil data dari resource,
                mengakses SystemService, mendapatkan ApplicationInfo dll
                https://medium.com/swlh/context-and-memory-leaks-in-android-82a39ed33002
                constructor Inten
                */
                Intent moveIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(moveIntent);
                //menjalankan activity tanpa membawa data Object [moveInten]
                //startActivities(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                /*
                #1.3 mengirim data
                putExtra() mengirim data dengan intent

                 */
                Intent moveWithDataIntent= new Intent(MainActivity.this, MoveWithData.class);
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, "DocodingAcademy FatherMan");
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE,30);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person person =new Person();
                person.setName("DicodingAcademy");
                person.setAge(30);
                person.setEmail("academy@dicoding.com");
                person.setCity("Bandung");

                //obyek Person bernama person parcelable
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObject.class);
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
                /*
                Row of Data
                arraylist dan metode putParcelableArrayListExtra
                ArrayList<Person> persons = new ArrayList<>();
                ...
                moveWithObjectIntent.putParcelableArrayListExtra(KEY,persons);
                untum mengambil datanya
                ArrayList<Person> persons = getIntent().getParcelableArrayListExtra(KEY);
                 */
                break;
            case R.id.btn_dial_number:
                String phoneNumber="082208426785";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}
