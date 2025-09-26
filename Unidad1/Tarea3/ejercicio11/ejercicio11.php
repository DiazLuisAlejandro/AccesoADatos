<?php

if(!file_exists("diario.txt")){
    $file=fopen("diario.txt","w");

    fwrite($file, date("[Y-m-d H:i:s]")." Avance la tarea.");
    fwrite($file, "\n");
    fclose($file);
}else{
     $file=fopen("diario.txt","a");

    fwrite($file, date("[Y-m-d H:i:s]")." Complete el ejercicio.");
    fwrite($file, "\n");
    fclose($file);
}

echo file_get_contents("diario.txt");

?>