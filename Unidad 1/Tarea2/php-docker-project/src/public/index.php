<?php
function secuenciaCollatz(int $n): array{
    $resultado=[];
    while ($n!=1) {
        $resultado[]=$n;
        if ($n%2==0) {
            $n=$n/2;
        } else {
            $n=3*$n+1;
        }
    }
    $resultado[] = 1;
    return $resultado;
}
print_r(secuenciaCollatz(10));
?>