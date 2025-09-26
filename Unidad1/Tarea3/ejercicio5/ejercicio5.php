<?php


if (!file_exists("orignal.txt")) {
    $file = fopen("original.txt", "w");
    fwrite($file, "Este es el archivo original.");
    fclose($file);
}

echo file_get_contents("original.txt")."\n";

if (!file_exists("copia.txt")) {
    $file = fopen("copia.txt", "w");
    fwrite($file, file_get_contents("original.txt"));
    fclose($file);
}else {
    unlink("copia.txt");
    $file = fopen("copia.txt", "w");
    fwrite($file, file_get_contents("original.txt"));
    fclose($file);
}


echo file_get_contents("copia.txt")."\n";

?>