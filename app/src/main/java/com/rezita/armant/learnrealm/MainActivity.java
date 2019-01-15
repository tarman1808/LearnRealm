package com.rezita.armant.learnrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSimpan, btnTampil;
    EditText nim, nama;
    String sNama;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi

        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);


        //set up Realm

        Realm.init(MainActivity.this);
        RealmConfiguration configuration = new RealmConfiguration().Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }

    @Override
    public  void OnClick(View v){
        if (v == btnSimpan){
            sNim = Integer.parseInt(nim.getText().toString());
            sNama = nama.getText().toString();

            if (!sNim.equals(("") && !sNama.isEmpty())){
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(MainActivity.this, "Berhasil Di Simpan", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
            }else {
                Toast.makeText(MainActivity.this, "Terdapat Inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if(v == btnTampil){
            startActivity(new Intent(MainActivity.this, MahasiswaActivity.class));
        }
    }
}
