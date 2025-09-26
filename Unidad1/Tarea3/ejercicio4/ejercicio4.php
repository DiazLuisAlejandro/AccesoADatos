<?php

if (!file_exists("nombres.txt")) {
    $file = fopen("nombres.txt", "w");
    $arrat = ["Ana", "Luis", "Pedro", "María", "Marta", "Alejandro"];
    foreach ($arrat as $nombre) {
        fwrite($file, $nombre . PHP_EOL);
    }
    fclose($file);
}

echo file_get_contents("nombres.txt");

?>