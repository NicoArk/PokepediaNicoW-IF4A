package com.if4a.nicholasw.pokepedianicow.Model;

import android.media.Image;

public class ModelPokemon {
    private String id, name, entry, type, ability, hp, atk, def, spa, spd, spe
            , move1, move2, move3, move4, namaevo, fotopokemon, fotoevo;


    public ModelPokemon(String fotopokemon, String fotoevo) {
        this.fotopokemon = fotopokemon;
        this.fotoevo = fotoevo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEntry() {
        return entry;
    }

    public String getType() {
        return type;
    }

    public String getAbility() {
        return ability;
    }

    public String getHp() {
        return hp;
    }

    public String getAtk() {
        return atk;
    }

    public String getDef() {
        return def;
    }

    public String getSpa() {
        return spa;
    }

    public String getSpd() {
        return spd;
    }

    public String getSpe() {
        return spe;
    }

    public String getMove1() {
        return move1;
    }

    public String getMove2() {
        return move2;
    }

    public String getMove3() {
        return move3;
    }

    public String getMove4() {
        return move4;
    }

    public String getNamaevo() {
        return namaevo;
    }

    public String getFotopokemon() {
        return fotopokemon;
    }

    public String getFotoevo() {
        return fotoevo;
    }
}
