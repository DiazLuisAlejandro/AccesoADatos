<?php

if (!file_exists("datos_numericos.txt")) {
    $file = fopen("datos_numericos.txt", "w");
    fwrite($file, "10,20,30,40");
    fclose($file);
}

$string = file_get_contents("datos_numericos.txt");
$numbers = explode(",", $string);
$sum = array_sum($numbers);

echo "La suma de los números es: " . $sum."\n";

?>