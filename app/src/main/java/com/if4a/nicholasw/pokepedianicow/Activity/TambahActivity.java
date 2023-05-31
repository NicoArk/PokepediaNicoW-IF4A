package com.if4a.nicholasw.pokepedianicow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.if4a.nicholasw.pokepedianicow.API.APIRequestData;
import com.if4a.nicholasw.pokepedianicow.API.RetroServer;
import com.if4a.nicholasw.pokepedianicow.Model.ModelResponse;
import com.if4a.nicholasw.pokepedianicow.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etId, etName, etEntry, etType, etAbility, etHP, etATK, etDEF, etSpA, etSpD, etSPE,
            etMove1, etMove2, etMove3, etMove4, etNamaEvo;
    private Button btnSimpan;
    private String id, entry, name, type, ability, hp, atk, def, spa, spd, spe
            , move1, move2, move3, move4, namaevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etEntry = findViewById(R.id.et_entry);
        etType = findViewById(R.id.et_type);
        etAbility = findViewById(R.id.et_Ability);
        etHP = findViewById(R.id.et_HP);
        etATK = findViewById(R.id.et_ATK);
        etDEF = findViewById(R.id.et_DEF);
        etSpA = findViewById(R.id.et_SpA);
        etSpD = findViewById(R.id.et_SpD);
        etSPE = findViewById(R.id.et_SPE);
        etMove1 = findViewById(R.id.et_Move1);
        etMove2 = findViewById(R.id.et_Move2);
        etMove3 = findViewById(R.id.et_Move3);
        etMove4 = findViewById(R.id.et_Move4);
        etNamaEvo = findViewById(R.id.et_Evoname);
        btnSimpan = findViewById(R.id.btn_tambah);

        btnSimpan = findViewById(R.id.btn_tambah);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Id = etId.getText().toString();
                name = etName.getText().toString();
                entry = etEntry.getText().toString();
                type = etType.getText().toString();
                ability =etAbility.getText().toString();
                hp = etHP.getText().toString();
                atk = etATK.getText().toString();
                def = etDEF.getText().toString();
                spa = etSpA.getText().toString();
                spd = etSpD.getText().toString();
                spe = etSPE.getText().toString();
                move1 = etMove1.getText().toString();
                move2 = etMove2.getText().toString();
                move3 = etMove3.getText().toString();
                move4 = etMove4.getText().toString();
                namaevo = etNamaEvo.getText().toString();




                if(name.trim().isEmpty())
                {
                    etName.setError("Nama Tidak Boleh Kosong");
                }
                else if (entry.trim().isEmpty())
                {
                    etEntry.setError("Entry Tidak Boleh Kosong");
                }
                else if (type.trim().isEmpty())
                {
                    etType.setError("Type Tidak Boleh Kosong");
                }
                else if (ability.trim().isEmpty())
                {
                    etAbility.setError("Ability Tidak Boleh Kosong");
                }
                else if (hp.trim().isEmpty())
                {
                    etHP.setError("HP Tidak Boleh Kosong");
                }else if (atk.trim().isEmpty())
                {
                    etATK.setError("ATK Tidak Boleh Kosong");
                }
                else if (def.trim().isEmpty())
                {
                    etDEF.setError("DEF Tidak Boleh Kosong");
                }
                else if (spa.trim().isEmpty())
                {
                    etSpA.setError("SPA Tidak Boleh Kosong");
                }
                else if (spd.trim().isEmpty())
                {
                    etSpD.setError("SPD Tidak Boleh Kosong");
                }
                else if (spe.trim().isEmpty())
                {
                    etSPE.setError("SPE Tidak Boleh Kosong");
                }
                else if (move1.trim().isEmpty())
                {
                    etMove1.setError("Move pertama Tidak Boleh Kosong");
                }else if (move2.trim().isEmpty())
                {
                    etMove2.setError("Move kedua Tidak Boleh Kosong");
                }
                else if (move3.trim().isEmpty())
                {
                    etMove3.setError("Move ketiga Tidak Boleh Kosong");
                }
                else if (move4.trim().isEmpty())
                {
                    etMove4.setError("Move keempat Tidak Boleh Kosong");
                }
                else if (namaevo.trim().isEmpty())
                {
                    etNamaEvo.setError("Nama Evolution Tidak Boleh Kosong");
                }


                else {
                    tambahKuliner();
                }
            }
        });
    }

    private void tambahKuliner()
    {
        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = ARD.ardCreate(name, entry, type, ability, hp, atk, def, spa,
                spd,
                spe
                , move1, move2, move3, move4, namaevo);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this, "Kode: " + kode + "Pesan: " +pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal menghubungi server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}