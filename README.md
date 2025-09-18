# Introduccion_PHP

## Ejercicio 1

Pide dos números y muestra cuál es mayor o si son iguales.

### Codigo:
```
<?php
$numero1=10;
$numero2=8;

if($numero1>$numero2){
    echo "$numero1 es mayor que $numero2"; 
}
if($numero1<$numero2){
    echo "$numero2 es mayor que $numero1"; 
}
?>
```
### Resultado:

![](imagenes_tarea/ejercicio1.png)


## Ejercicio 2

Pide la edad de una persona y muestra:

    "Eres menor de edad" si es < 18.
    "Eres mayor de edad" si es ≥ 18.


### Codigo:

```
<?php
/*Mayor de dos numeros */

$edad=19;


if($edad>=18){
    echo "Eres mayor de edad"; 
}
echo "<br>";
$edad=17;
if($edad<18){
    echo "Eres menor de edad"; 
}

?>
```
### Resultado:

![](imagenes_tarea/ejercicio2.png)

## Ejercicio 3

Positivo, negativo o cero
<br/>
Comprueba si un número almacenado en una variable es positivo, negativo o cero.

### Codigo:
```
<?php
$numero=5;
if($numero>=1){
    echo "Es un numero positivo"; 
}
echo "<br>";
$numero=-1;
if($numero<0){
   echo "Es un numero negativo"; 
}
echo "<br>";
$numero=0;
if($numero==0){
   echo "Es cero"; 
}
?>
```
### Resultado:

![](imagenes_tarea/ejercicio3.png)
