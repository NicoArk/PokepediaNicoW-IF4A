<?php
require("koneksi.php");

$response = array();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
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

    // Convert the base64 image strings to image files
    // $fotopokemon = saveBase64Image($fotopokemon, "fotopokemon");
    // $fotoevo = saveBase64Image($fotoevo, "fotoevo");

    $perintah = "INSERT INTO tbl_pokemon (name, entry, type, ability, hp, atk, def, spa, spd, spe, move1, move2, move3, move4, namaevo, fotopokemon, fotoevo) VALUES ('$name', '$entry', '$type', '$ability', '$hp', '$atk', '$def', '$spa', '$spd', '$spe', '$move1', '$move2', '$move3', '$move4', '$namaevo', '$fotopokemon', '$fotoevo')";
    $eksekusi = mysqli_query($connect, $perintah);
    $cek = mysqli_affected_rows($connect);

    if ($cek > 0) {
        $response["kode"] = 1;
        $response["pesan"] = "Sukses Menyimpan Data";
    } else {
        $response["kode"] = 0;
        $response["pesan"] = "Ada Kesalahan Menyimpan Data";
    }
} else {
    $response["kode"] = 0;
    $response["pesan"] = "Tidak Ada Post Data";
}
echo json_encode($response);
mysqli_close($connect);

// function saveBase64Image($base64Image, $prefix)
// {
//     $img = explode(',', $base64Image);
//     $data = base64_decode($img[1]);

//     $filename = $prefix . "_" . uniqid() . ".jpg";
//     $file = fopen($filename, 'wb');
//     fwrite($file, $data);
//     fclose($file);

//     return $filename;
// }
