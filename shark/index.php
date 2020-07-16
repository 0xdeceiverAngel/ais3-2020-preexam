<?php

    if ($path = @$_GET['path']) {
        if (preg_match('/^(\.|\/)/', $path)) {
            // disallow /path/like/this and ../this
            die('<pre>[forbidden]</pre>');
        }
        $content = @file_get_contents($path, FALSE, NULL, 0, 1000);
        die('<pre>' . ($content ? htmlentities($content) : '[empty]') . '</pre>');
    }

?><!DOCTYPE html>
<head>
    <title>🦈🦈🦈</title>
    <meta charset="utf-8">
</head>
<body>
    <h1>🦈🦈🦈</h1>
    <a href="?path=hint.txt">Shark never cries?</a>
</body>

