# Introducción a Php, uso de funciones


## Indice
|Ejercicios|Realizados|Dificultad|
|----------|----------|----------|
|[Ejercicio 1](#ejercicio-1)|✔️|1|
|[Ejercicio 2](#ejercicio-2)|✔️|1|
|[Ejercicio 3](#ejercicio-3)|✔️|1|
|[Ejercicio 4](#ejercicio-4)|✔️|1|
|[Ejercicio 5](#ejercicio-5)|✔️|1|

## [Ejercicio 1](#indice)

Implementa una función esCapicua(int $n): bool que determine si un número entero positivo es capicúa.

Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.


### Codigo:

```
<?php
function esCapicua(int $n):bool {
    $num= (int)strrev((String)$n);
    if($n==$num){
        return true;
    }
    return false;
}
if(esCapicua(313)){
    echo "True";
}else{
    echo "False";
}
?>
```

#### Reslutado:

![](imagenes_tarea/ejercicio1.png)

## [Ejercicio 2](#indice)

Implementa una función montañaAsteriscos(int $n, $m): void que imprima una escalera de asteriscos de altura N y el tamaño M.

La primera fila contiene 1 asterisco, la segunda 2, y así hasta N, M veces.

### Codigo:

```
<?php

?>
```

#### Reslutado:

## [Ejercicio 3](#indice)

Implementa una función sumaDigitos(int $n): int que calcule la suma de los dígitos de un número entero positivo.

Descompón el número en dígitos y súmalos.

### Codigo:

#### Reslutado:

## [Ejercicio 4](#indice)

Implementa una función multiplosTresOCinco(int $n): array que devuelva todos los múltiplos de 3 o 5 menores que N.

Además, calcula la suma de dichos múltiplos.


### Codigo:

#### Reslutado:

## [Ejercicio 5](#indice)

Implementa una función secuenciaCollatz(int $n): array que genere la secuencia de Collatz a partir de un entero positivo.

Si el número es par → dividir entre 2.

Si es impar → multiplicar por 3 y sumar 1.

Repetir hasta llegar a 1.


### Codigo:

#### Reslutado: