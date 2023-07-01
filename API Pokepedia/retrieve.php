<?php
require("koneksi.php");
$perintah = "SELECT * FROM tbl_pokemon";
$eksekusi = mysqli_query($connect, $perintah);
$cek = mysqli_affected_rows($connect);
if ($cek > 0) {
    $response["kode"] = 1;
    $response["pesan"] = "Data Tersedia";
    $response["data"] = array();

    while ($get = mysqli_fetch_object($eksekusi)) {
        $var["id"] = $get->id;
        $var["name"] = $get->name;
        $var["entry"] = $get->entry;
        $var["type"] = $get->type;
        $var["ability"] = $get->ability;
        $var["hp"] = $get->hp;
        $var["atk"] = $get->atk;
        $var["def"] = $get->def;
        $var["spa"] = $get->spa;
        $var["spd"] = $get->spd;
        $var["spe"] = $get->spe;
        $var["move1"] = $get->move1;
        $var["move2"] = $get->move2;
        $var["move3"] = $get->move3;
        $var["move4"] = $get->move4;
        $var["namaevo"] = $get->namaevo;
        $var["fotopokemon"] = $get->fotopokemon; // Include the column fotopokemon
        $var["fotoevo"] = $get->fotoevo; // Include the column fotoevo

        array_push($response["data"], $var);
    }
} else {
    $response["kode"] = 0;
    $response["pesan"] = "Data Tidak Tersedia";
}

echo json_encode($response);
mysqli_close($connect);
