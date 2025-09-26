<?php

$nombre = "Alejandro";

if (!file_exists("usuarios.txt")) {
    $file = fopen("usuarios.txt", "w");
    if ($nombre) {
    $file = fopen("usuarios.txt", "a");
    fwrite($file, $nombre . "\n");
    fclose($file);
    }
    fclose($file);
} else {
    if ($nombre) {
    $file = fopen("usuarios.txt", "a");
    fwrite($file, $nombre . "\n");
    fclose($file);
}
}


echo file_get_contents("usuarios.txt");

?>