<?php

    //Login for with hashed passwords
    include("password.php");

    $con = mysqli_connect("db.if.ktu.lt", "antsia", "ohf9iD7Eophaetho", "antsia");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM Ausers WHERE username = ?");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $colUserID, $colName, $colUsername, $colAge, $colPassword);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        if ($password == $colPassword) {
            $response["success"] = true;  
            $response["name"] = $colName;
            $response["age"] = $colAge;
        }
    }

    echo json_encode($response);
?>