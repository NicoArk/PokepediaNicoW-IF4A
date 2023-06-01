package com.if4a.nicholasw.pokepedianicow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.if4a.nicholasw.pokepedianicow.API.APIRequestData;
import com.if4a.nicholasw.pokepedianicow.API.RetroServer;
import com.if4a.nicholasw.pokepedianicow.Adapter.AdapterPokemon;
import com.if4a.nicholasw.pokepedianicow.Model.ModelPokemon;
import com.if4a.nicholasw.pokepedianicow.Model.ModelResponse;
import com.if4a.nicholasw.pokepedianicow.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabTambah;
    private ProgressBar pbPokemon;
    private RecyclerView rvPokemon;
    private RecyclerView.Adapter adPokemon;
    private RecyclerView.LayoutManager lmPokemon;
    private List<ModelPokemon> listPokemon = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPokemon = findViewById(R.id.rv_pokemon);
        pbPokemon= findViewById(R.id.pb_pokemon);
        lmPokemon = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPokemon.setLayoutManager(lmPokemon);
        fabTambah = findViewById(R.id.fab_tambah);

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrievePokemon();
    }
    //        fabTambah = findViewById(R.id.fab_tambah);
//        fabTambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, TambahActivity.class));
//            }


    public void retrievePokemon()
    {
        pbPokemon.setVisibility(View.VISIBLE);
        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = ARD.ardRetrieve();

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listPokemon = response.body().getData();

                adPokemon = new AdapterPokemon(MainActivity.this, listPokemon);
                rvPokemon.setAdapter(adPokemon);
                adPokemon.notifyDataSetChanged();

                pbPokemon.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
                pbPokemon.setVisibility(View.GONE);
            }

        });
    }


}