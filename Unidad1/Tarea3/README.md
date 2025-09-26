# Ficheros

Trabajo con fichero en php
## Indice
|Ejercicios |Realizados|Dificultad|
|----------|------------|----------|
|[Ejercicio 1](#ejercicio-1)|✔️|1|
[Ejercicio 2](#ejercicio-2)|✔️|1|
[Ejercicio 3](#ejercicio-3)|✔️|1|
|[Ejercicio 4](#ejercicio-4)|✔️|1|
|[Ejercicio 5](#ejercicio-5)|✔️|1|
|[Ejercicio 6](#ejercicio-6)|✔️|1|
|[Ejercicio 7](#ejercicio-7)|✔️|1|
|[Ejercicio 8](#ejercicio-8)|✔️|1|
|[Ejercicio 9](#ejercicio-9)|✔️|1|
|[Ejercicio 10](#ejercicio-10)|✔️|1|
|[Ejercicio 11](#ejercicio-11)|✔️|2|
|[Ejercicio 12](#ejercicio-12)|✔️|3|
|[Ejercicio 13](#ejercicio-13)|✔️|1|
|[Ejercicio 14](#ejercicio-14)|✔️|1|
|[Ejercicio 15](#ejercicio-15)|✔️|7|
|[Ejercicio 16](#ejercicio-16)|✔️|3|
|[Ejercicio 17](#ejercicio-17)|✔️|4|
|[Ejercicio 18](#ejercicio-18)|✔️|2|
|[Ejercicio 19](#ejercicio-19)|✔️|5|
|[Ejercicio 20](#ejercicio-20)|✔️|2|


## [Ejercicio 1](#indice)

Crea un fichero datos.txt con el texto "Hola Mundo desde PHP" y, a continuación, léelo y muestra su contenido por pantalla.

### Codigo:
```php
<?php
if (!file_exists("datos.txt")) {
    $file = fopen("datos.txt", "w");
    fwrite($file, "Hola Mundo desde PHP");
    fclose($file);
}

echo file_get_contents("datos.txt");

?>
```

## [Ejercicio 2](#indice)

Almacena en numeros.txt los números del 1 al 10 (cada número en una línea). Luego léelo y muestra todos los números.


### Codigo:

```php
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
```


## [Ejercicio 3](#indice)

Escribe un texto en texto.txt, luego haz que tu programa cuente cuántas palabras contiene ese archivo.

### Codigo:
```php
<?php

if (!file_exists("texto.txt")) {
    $file = fopen("texto.txt", "w");
    fwrite($file, "PHP es muy divertido y potente.");
    fclose($file);
}
    $num=str_word_count(file_get_contents("texto.txt"));

    echo "El archivo tiene $num palabras. \n";
?>
```



## [Ejercicio 4](#indice)

Guarda un array de nombres en nombres.txt (uno por línea). Después, léelo y muéstralos en lista numerada.

### Codigo:
```php
<?php

if (!file_exists("nombres.txt")) {
    $file = fopen("nombres.txt", "w");
    $arrat = ["Ana", "Luis", "Pedro", "María", "Marta", "Alejandro"];
    foreach ($arrat as $nombre) {
        fwrite($file, $nombre."\n");
    }
    fclose($file);
}

echo file_get_contents("nombres.txt");

?>
```


## [Ejercicio 5](#indice)

Copia el contenido de origen.txt en un archivo copia.txt.

### Codigo:
```php
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
```
## [Ejercicio 6](#indice)

Lee frase.txt, invierte el texto y guarda el resultado en frase_invertida.txt.

### Codigo:
```php
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
```


## [Ejercicio 7](#indice)

Guarda números separados por comas en datos_numericos.txt. Léelos y calcula su suma.

### Codigo:
```php
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
```


## [Ejercicio 8](#indice)

Genera la tabla del 5 y guárdala en tabla5.txt. Luego muéstrala.

### Codigo:
```php
<?php
if (!file_exists("tabla5.txt")) {
    $file = fopen("tabla5.txt", "w");
    for ($i = 1; $i <= 10; $i++) {
        $line="5x$i=".(5 * $i)."\n";
        fwrite($file, $line);
    }
    fclose($file);
}

echo file_get_contents("tabla5.txt");
?>
```

## [Ejercicio 9](#indice)

Guarda los nombres recibidos en un formulario dentro de usuarios.txt (cada nombre en una línea). Luego muéstralos.

### Codigo:
```php
<?php

$nombre = "Alejandro";
if (!file_exists("usuarios.txt")) {
    $file = fopen("usuarios.txt", "w");
    if ($nombre) {
    $file = fopen("usuarios.txt", "a");
    fwrite($file, $nombre . "\n");
    fclose($file);
    }
    fclose($file);
} else {
    if ($nombre) {
    $file = fopen("usuarios.txt", "a");
    fwrite($file, $nombre . "\n");
    fclose($file);
}
}
echo file_get_contents("usuarios.txt");
?>

```


## [Ejercicio 10](#indice)

Crea datos.json con información de personas (nombre y edad). Haz que el programa lo lea y muestre los datos.

### Codigo:
```php
<?php
if(!file_exists("datos.json")){
    $file=fopen("datos.json", "w");
    $datos = [
        ["nombre" => "Ana", "edad" => 25],
        ["nombre" => "Luis", "edad" => 30]
    ];
    fwrite($file, "[\n");
    foreach ($datos as $persona) {
        fwrite($file, json_encode($persona));
        if ($persona !== end($datos)) {
            fwrite($file, ",\n");
        }
    }
    fwrite($file, "\n]");
    fclose($file);
}

echo file_get_contents("datos.json");
?>

```


## [Ejercicio 11](#indice)


### Codigo:
```php
<?php

?>
```


## [Ejercicio 12](#indice)



### Codigo:
```php
<?php

?>
```


## [Ejercicio 13](#indice)




### Codigo:
```php
<?php

?>
```
### Resultado:



## [Ejercicio 14](#indice)


### Codigo:
```php
<?php

?>
```
### Resultado:


## [Ejercicio 15](#indice)




### Codigo:
```php
<?php

?>
```


## [Ejercicio 16](#indice)



### Codigo:
```php
<?php

?>
```

## [Ejercicio 17](#indice)




### Codigo:
```php
<?php

?>
```


## [Ejercicio 18](#indice)



### Codigo:
```php
<?php

?>
```


## [Ejercicio 19](#indice)




### Codigo:
```php
<?php

?>
```


## [Ejercicio 20](#indice)



### Codigo:
```php
<?php

?>
```
