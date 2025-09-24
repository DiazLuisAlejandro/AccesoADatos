<?php

if (!file_exists("datos.txt")) {
    $file = fopen("datos.txt", "w");
    fwrite($file, "Hola Mundo desde PHP");
    fclose($file);
}

echo file_get_contents("datos.txt")."\n";

?>