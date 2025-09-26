<?php

if (!file_exists("texto.txt")) {
    $file = fopen("texto.txt", "w");
    fwrite($file, "PHP es muy divertido y potente.");
    fclose($file);
}
    $num=str_word_count(file_get_contents("texto.txt"));

    echo "El archivo tiene $num palabras. \n";
?>