 <?php

 require_once('dbConnect.php');


//die("bybis");

 $statement =  "SELECT * FROM categories";




$query = mysqli_query($con, $statement);
 //die(var_dump($query));
 $response = array();

 while ($row = mysqli_fetch_array($query)) {
 		$response[] = array("id"=>$row['id'],
 						"name"=>$row['name'],
 						"description"=>$row['description']);
 }
 echo json_encode(array("result"=>$response));
 mysqli_close($con);