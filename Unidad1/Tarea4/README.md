# Tarea 4

## Indice


### Ejercicio 1

Dado un fichero ops.csv con columnas:

z1,z2,op

donde:

op ∈ {suma, resta, producto, division}

Se debe calcular z1 (op) z2 y generar como salida un fichero resultado.csv.

### Codigo

```php
<?php
if(!file_exists("resultado.csv")){
    $file=fopen("ops.csv","r");
    $file2=fopen("resultado.csv","w");
    fwrite($file2,"z1,z2,op,resultado\n");
    $arrfile=(explode("\n",file_get_contents("ops.csv")));
    foreach ($arrfile as $line) {
        if($line!="z1,z2,op"){
        $file2=fopen("resultado.csv","a");
        $arr=explode(",",$line);
            if($arr[2]=="suma"){
                fwrite($file2,$line.",".($arr[0]+$arr[1])."\n");
            }
            if($arr[2]=="resta"){
                fwrite($file2,$line.",".($arr[0]-$arr[1])."\n");
            }
            if($arr[2]=="producto"){
                fwrite($file2,$line.",".($arr[0]*$arr[1])."\n");
            }
            if($arr[2]=="division"){
                if($arr[0]!=0 && $arr[1]!=0){
                    fwrite($file2,$line.",".($arr[0]/$arr[1])."\n");
                }else{
                    fwrite($file2,$line.",ERROR\n");

                }
            }
        }
    }
}else{
    $file=fopen("ops.csv","r");
    $file2=fopen("resultado.csv","a");
    $arrfile=(explode("\n",file_get_contents("ops.csv")));

    foreach ($arrfile as $line) {
        
        if($line!="z1,z2,op"){
        $file2=fopen("resultado.csv","a");
        $arr=explode(",",$line);
            if($arr[2]=="suma"){
                fwrite($file2,$line.",".($arr[0]+$arr[1])."\n");
            }
            if($arr[2]=="resta"){
                fwrite($file2,$line.",".($arr[0]-$arr[1])."\n");
            }
            if($arr[2]=="producto"){
                fwrite($file2,$line.",".($arr[0]*$arr[1])."\n");
            }
            if($arr[2]=="division"){
                if($arr[1]!=0){
                    fwrite($file2,$line.",".($arr[0]/$arr[1])."\n");
                }else{
                    fwrite($file2,$line.",ERROR\n");

                }
            }
        }
    }
}
?>
```

## Ejercicio 2

Dado un fichero texto.txt, contar cuántas palabras hay en total y cuántas veces aparece cada palabra.

La salida se debe guardar en estadisticas.csv con el formato:

palabra,frecuencia

Reglas:

Ignorar mayúsculas/minúsculas (ejemplo: PHP y php cuentan como la misma palabra).

Ignorar signos de puntuación.


### Codigo

```php
<?php



?>
```