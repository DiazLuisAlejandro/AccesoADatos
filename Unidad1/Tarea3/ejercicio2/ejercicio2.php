<?php

if (!file_exists("numeros.txt")) {
    $file = fopen("numeros.txt", "w");
    for ($i=1; $i <=10 ; $i++) { 
        fwrite($file, "$i"."\n");
    }
    fclose($file);
}

echo file_get_contents("numeros.txt")

?>