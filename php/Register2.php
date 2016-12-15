<?php

    
    require_once('dbConnect.php');
    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];

     
    function usernameUsed() {
        global $con, $username;
        /*$statement = mysqli_prepare($connect, "SELECT username FROM Ausers WHERE username = ?"); */
         
        $q = "SELECT username FROM  users   WHERE username = '$username'";
        $result = mysqli_query($con, $q);
        return (mysqli_num_rows($result) > 0);


    }
    function registerUser() {
        global $con, $name, $age, $username, $password;
        //$passwordHash = password_hash($password, PASSWORD_DEFAULT);
        $statement = mysqli_prepare($con, "INSERT INTO users (name, username, age, password) VALUES (?, ?, ?, ?)");
        mysqli_stmt_bind_param($statement, "ssis", $name,  $username, $age, $password);
        mysqli_stmt_execute($statement);
        mysqli_stmt_close($statement);     
    }


    $response = array();
    $response["success"] = false;  

    if (!usernameUsed()){
        registerUser();
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>