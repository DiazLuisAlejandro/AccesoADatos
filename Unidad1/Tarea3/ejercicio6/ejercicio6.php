<?php
if (!file_exists("frase.txt")) {
    $file = fopen("frase.txt", "w");
    fwrite($file, "Hola PHP");
    fclose($file);
}

$string= file_get_contents("frase.txt");

if (!file_exists("frase_invertida.txt")) {
    $file = fopen("frase_invertida.txt", "w");
    fwrite($file, strrev($string));
    fclose($file);
}else{
    unlink("frase_invertida.txt");
    $file = fopen("frase_invertida.txt", "w");
    fwrite($file, strrev($string));
    fclose($file);
}

echo file_get_contents("frase.txt")."\n";
echo file_get_contents("frase_invertida.txt")."\n";

?>