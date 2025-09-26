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
        fwrite($file, $nombre . PHP_EOL);
    }
    fclose($file);
}

echo file_get_contents("nombres.txt");

?>
```


## [Ejercicio 5](#indice)



### Codigo:
```
<?php

?>
```
### Resultado:

## [Ejercicio 7](#indice)



### Codigo:
```
<?php

?>
```


## [Ejercicio 8](#indice)


### Codigo:
```
<?php

?>
```

## [Ejercicio 9](#indice)



### Codigo:
```
<?php

?>

```


## [Ejercicio 10](#indice)


### Codigo:
```
<?php

?>

```


## [Ejercicio 11](#indice)


### Codigo:
```
<?php

?>
```


## [Ejercicio 12](#indice)



### Codigo:
```
<?php

?>
```


## [Ejercicio 13](#indice)




### Codigo:
```
<?php

?>
```
### Resultado:



## [Ejercicio 14](#indice)


### Codigo:
```
<?php

?>
```
### Resultado:


## [Ejercicio 15](#indice)




### Codigo:
```
<?php

?>
```


## [Ejercicio 16](#indice)



### Codigo:
```
<?php

?>
```

## [Ejercicio 17](#indice)




### Codigo:
```
<?php

?>
```


## [Ejercicio 18](#indice)



### Codigo:
```
<?php

?>
```


## [Ejercicio 19](#indice)




### Codigo:
```

```


## [Ejercicio 20](#indice)



### Codigo:
```
<?php

?>
```
