<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

$message = '';



if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['name']) and isset($_POST['dept'])and isset($_POST['charge'])and isset($_POST['mob'])and isset($_POST['image'])){
		
		$db = new DbOperations(); 
     
      $branch = $_POST['dept'];
      if ($branch == "Tool and Die") {
         $br = "TD";
      }elseif ($branch == "Computer Engineering") {
         $br = "CT";
      }else {
         $br = "EC";
      }

      $path = "http://192.168.43.150/android/v1/image/";
      $picture = $_POST['image'];
      $image = $path .''. $picture;
      

		$result = $db->createStaff($_POST['name'], $_POST['dept'], $_POST['charge'], $_POST['mob'], $image, $br);
		if($result == 1){
			$response['error'] = false; 
         $response['message'] = "Staff registered successfully";
         $message = "Staff registered successfully";
		}elseif($result == 2){
			$response['error'] = true; 
         $response['message'] = "Some error occurred please try again";		
         $message = "Some error occurred please try again";		
		}elseif($result == 0){
			$response['error'] = true; 
         $response['message'] = "It seems you are already registered";	
         $message = "It seems you are already registered";					
		}

	}else{
		$response['error'] = true; 
      $response['message'] = "Required fields are missing";
      $message = "Required fields are missing";	
	}
}else{
	$response['error'] = true; 
	$response['message'] = "Invalid Request";
}

?>

<html>
   
   <head>
      <title>Insert Staff</title>
      
       <link rel="stylesheet" type="text/css" href="style.css">
       <meta name="viewport" content="width=device-width, initial-scale=1" /> 

   </head>
   
   <body bgcolor = "#FFFFFF">
	
      <div align = "center">
         <div style = "width:300px; border: solid 1px #333333; " align = "left">
            <div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Staff Add</b></div>
				
            <div style = "margin:30px">
               
               <form action = "" method = "post">
			   
				  <label>Name  :</label></br><input type = "text" name = "name" class = "box"/><br /><br />
              <label for="dept">Dept	:</label></br><select id="dept" name = "dept" class = "box"  >
							  <option  value="Tool and Die">Tool and Die</option>							  
							  <option  value="Computer Engineering">Computer Engineering</option>
							  <option  value="Electronics and Communication">Electronics and Communication</option>
							 
						</select></br></br>
				  <label>Charge  :</label></br><input type = "text" name = "charge" class = "box"/><br /><br />
				  <label>MOB  :</label></br><input type = "text" name = "mob" class = "box"/><br /><br />
				  <label>Image  :</label></br><input type = "file" name = "image" class = "box"/><br /><br />
              <input type = "submit" value = " Submit "class = "button"/><br />
              </form>
              
              <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $message;  ?></div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>