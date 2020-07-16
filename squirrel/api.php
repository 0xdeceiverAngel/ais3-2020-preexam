{"output":"<?php

header('Content-Type: application\/json');

if ($file = @$_GET['get']) {
    $output = shell_exec(\"cat '$file'\");
    
    if ($output !== null) {
        echo json_encode([
            'output' => $output
        ]);
    } else {
        echo json_encode([
            'error' => 'cannot get file'
        ]);
    }
} else {
    echo json_encode([
        'error' => 'empty file path'
    ]);
}
"}