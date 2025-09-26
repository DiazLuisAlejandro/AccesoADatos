<?php
if(file_exists("ranking.txt")){
    $file=fopen("ranking.txt","r");

    $arrfile=(explode(":"(explode("\n", file_get_contents("ranking.txt")))));
   
    sort($arrfile);
    echo print_r($arrfile);
   
    fclose($file);
}

?>