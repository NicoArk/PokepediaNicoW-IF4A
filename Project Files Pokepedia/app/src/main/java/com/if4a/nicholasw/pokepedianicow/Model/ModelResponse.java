package com.if4a.nicholasw.pokepedianicow.Model;

import java.util.List;

public class ModelResponse {
    private String kode, pesan;
    private List<ModelPokemon> data;

    public String getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }

    public List<ModelPokemon> getData() {
        return data;
    }

}
