<?php
if (!file_exists("tabla5.txt")) {
    $file = fopen("tabla5.txt", "w");
    for ($i = 1; $i <= 10; $i++) {
        $line = "5 x $i = " . (5 * $i) . PHP_EOL;
        fwrite($file, $line);
    }
    fclose($file);
}

echo file_get_contents("tabla5.txt");
?>