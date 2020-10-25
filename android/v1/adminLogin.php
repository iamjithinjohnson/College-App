<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['username']) and isset($_POST['password'])){
		$db = new DbOperations(); 

		if($db->adminLogin($_POST['username'], $_POST['password'])){
			$admin = $db->getAdminByUsername	($_POST['username']);
			$response['error'] = false; 
			//$response['id'] = $admin['id'];
			//$response['password'] = $admin['password'];
			//$response['username'] = $admin['username'];
			// <href = "registerUser.php"/>
			 
			header("location: allpage1.html");
			$response['message'] = 'successfull';
		}else{
			$response['error'] = true; 
			$response['message'] = "Invalid username or password";			
		}

	}else{
		$response['error'] = true; 
		$response['message'] = "Required fields are missing";
	}
}

//echo json_encode($response);

?>

<html>
   
   <head>
      <title>Admin Login Page</title>
      
      <link rel="stylesheet" type="text/css" href="style.css">

      <meta name="viewport" content="width=device-width, initial-scale=1" /> 
      
   </head>
   
   <body bgcolor = "#FFFFFF">
	
      <div align = "center">
         <div style = "width:300px; border: solid 1px #333333; " align = "left">
            <div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Admin Login</b></div>
				
            <div style = "margin:30px">
               
               <form action = "" method = "post">
                  <label>UserName  :</label><input type = "text" name = "username" class = "box"/><br /><br />
				  <label>Password  :</label><input type = "password" name = "password" class = "box" /><br/><br />
                  <input type = "submit" value = " Submit "/><br />
               </form>
               
               <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo json_encode($response);  ?></div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>