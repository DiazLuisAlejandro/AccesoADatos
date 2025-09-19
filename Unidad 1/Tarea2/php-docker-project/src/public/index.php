<?php
function esCapicua(int $n,int $m):void {
    $arr=[];
    $contador=0;
    $string="";
    while ($contador <$n) {
    for ($i=0; $i < $n; $i++) { 
        if($i==$n/$m){
            array_push($arr,"*");
        }else{
            array_push($arr," ");

        }
    }


    foreach($arr as $posarr){
        $string=strrev((string)$posarr).;
        echo $posarr;
        echo $string;
    }
    echo "<br>";
    $contador++;
}
}

esCapicua(4,2)

?>