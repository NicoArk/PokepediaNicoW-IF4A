package com.if4a.nicholasw.pokepedianicow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.if4a.nicholasw.pokepedianicow.R;

import pl.droidsonroids.gif.GifImageButton;

public class DetailActivity extends AppCompatActivity {
    TextView tvId, tvName, tvEntry, tvType, tvAbility, tvHP, tvATK, tvDEF, tvSpA, tvSpD, tvSPE,
            tvMove1, tvMove2, tvMove3, tvMove4, tvNamaEvo;

    ImageView ivPokemon, ivEvo;


    GifImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPokemon = findViewById(R.id.iv_pokemon);
        tvName = findViewById(R.id.tv_name);
        tvEntry = findViewById(R.id.tv_entry);
        tvType = findViewById(R.id.tv_type);
        tvAbility = findViewById(R.id.tv_ability);
        tvHP = findViewById(R.id.tv_hp);
        tvATK = findViewById(R.id.tv_atk);
        tvDEF = findViewById(R.id.tv_def);
        tvSpA = findViewById(R.id.tv_spa);
        tvSpD = findViewById(R.id.tv_spd);
        tvSPE = findViewById(R.id.tv_spe);
        tvMove1 = findViewById(R.id.tv_move1);
        tvMove2 = findViewById(R.id.tv_move2);
        tvMove3 = findViewById(R.id.tv_move3);
        tvMove4 = findViewById(R.id.tv_move4);
        ivEvo = findViewById(R.id.iv_evo);
        tvNamaEvo = findViewById(R.id.tv_namaevo);
        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, MainActivity.class));
            }
        });

        Intent intent = getIntent();
        String FotoPokemon = intent.getStringExtra("varFotoPokemon");
        String Name = intent.getStringExtra("varName");
        String Entry = intent.getStringExtra("varEntry");
        String Type = intent.getStringExtra("varType");
        String Ability = intent.getStringExtra("varAbility");
        String HP = intent.getStringExtra("varHp");
        String ATK = intent.getStringExtra("varAtk");
        String DEF = intent.getStringExtra("varDef");
        String SpA = intent.getStringExtra("varSpa");
        String SpD = intent.getStringExtra("varSpd");
        String SPE = intent.getStringExtra("varSpe");
        String Move1 = intent.getStringExtra("varMove1");
        String Move2 = intent.getStringExtra("varMove2");
        String Move3 = intent.getStringExtra("varMove3");
        String Move4 = intent.getStringExtra("varMove4");
        String FotoEvo = intent.getStringExtra("varFotoEvo");
        String NamaEvo = intent.getStringExtra("varNamaEvo");
       
        setTitle(Name);
        Glide.with(this)
                .load(FotoPokemon)
                .into(ivPokemon);

        tvName.setText(Name);
        tvEntry.setText(Entry);
        tvType.setText(Type);
        tvAbility.setText(Ability);
        tvHP.setText(HP);
        tvATK.setText(ATK);
        tvDEF.setText(DEF);
        tvSpA.setText(SpA);
        tvSpD.setText(SpD);
        tvSPE.setText(SPE);
        tvMove1.setText(Move1);
        tvMove2.setText(Move2);
        tvMove3.setText(Move3);
        tvMove4.setText(Move4);
        Glide.with(this)
                .load(FotoEvo)
                .into(ivEvo);

        tvNamaEvo.setText(NamaEvo);


    }
}