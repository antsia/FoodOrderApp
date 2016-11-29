<?php
   include("password.php");

    $connect = mysqli_connect("db.if.ktu.lt", "antsia", "ohf9iD7Eophaetho", "antsia");
    
    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];

     
    function usernameUsed() {
        global $connect, $username;
        /*$statement = mysqli_prepare($connect, "SELECT username FROM Ausers WHERE username = ?"); */
         
        $q = "SELECT username FROM  Ausers   WHERE username = '$username'";
        $result = mysqli_query($connect, $q);
        return (mysqli_num_rows($result) > 0);


    }
    function registerUser() {
        global $connect, $name, $age, $username, $password;
        //$passwordHash = password_hash($password, PASSWORD_DEFAULT);
        $statement = mysqli_prepare($connect, "INSERT INTO Ausers (name, username, age, password) VALUES (?, ?, ?, ?)");
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