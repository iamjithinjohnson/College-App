<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

// Create an array that contains another 
// array with key value pair 
//if($_SERVER['REQUEST_METHOD']=='POST'){
		$db = new DbOperations(); 
$arr = array ( 
      
    // Every array will be converted 
    // to an object 
    array( 
        "name" => "Pankaj Singh", 
        "age" => "20"
    ), 
    array( 
        "name" => "Arun Yadav", 
        "age" => "21"
    ), 
    array( 
        "name" => "Apeksha Jaiswal", 
        "age" => "20"
    ) 
); 
//}else{
	//$response['error'] = true; 
	//$response['message'] = "Invalid Request";
//}
  
// Function to convert array into JSON 
echo json_encode($arr); 
  
?> 