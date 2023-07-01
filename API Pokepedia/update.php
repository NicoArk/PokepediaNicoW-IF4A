<?php
require("koneksi.php");

$response = array();

if($_SERVER["REQUEST_METHOD"] == "POST"){
      $id = $_POST["id"];
     $name = $_POST["name"];
    $entry = $_POST["entry"];
     $type = $_POST["type"];
    $ability = $_POST["ability"];
     $hp = $_POST["hp"];
    $atk = $_POST["atk"];
    $def = $_POST["def"];
     $spa = $_POST["spa"];
    $spd = $_POST["spd"];
     $spe = $_POST["spe"];
    $move1 = $_POST["move1"];
     $move2 = $_POST["move2"];
    $move3 = $_POST["move3"];
    $move4 = $_POST["move4"];
    $namaevo = $_POST["namaevo"];
        $fotopokemon = $_POST["fotopokemon"];
    $fotoevo = $_POST["fotoevo"];
   
    $perintah = "UPDATE tbl_pokemon SET fotopokemon = '$fotopokemon', name = '$name', entry = '$entry', type = '$type', ability = '$ability', hp = '$hp', atk = '$atk', def = '$def', spa = '$spa', spd = '$spd', spe = '$spe', move1 = '$move1', move2 = '$move2', move3 = '$move3', move4 = '$move4', fotoevo = '$fotoevo', namaevo = '$namaevo' WHERE id = '$id'";
    $eksekusi = mysqli_query($connect, $perintah);
    $cek = mysqli_affected_rows($connect);
   
    if($cek>0){
        $response["kode"] = 1;
        $response["pesan"] = "Sukses Mengubah Data";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Ada Kesalahan Mengubah Data";
    }
}
else{
    $response["kode"] = 0 ;
    $response["pesan"] = "Tidak Ada Post Data";
}
echo json_encode($response);
mysqli_close($connect);
