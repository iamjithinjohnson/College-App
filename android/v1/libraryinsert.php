




<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

$message = '';

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['register']) and isset($_POST['book_id']) and isset($_POST['book_name'])and isset($_POST['issued_on'])and isset($_POST['issued_till']))
		{
		//operate the data further 

		$db = new DbOperations(); 


		$result = $db->insertlib($_POST['register'], $_POST['book_id'], $_POST['book_name'], $_POST['issued_on'], $_POST['issued_till']);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "User registered successfully";
			$message = "User registered successfully";					

		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred please try again";
			$message = "Some error occurred please try again";					
			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "It seems you are already registered, please choose a different register number";	
			$message = "Entered register number is NotExist";					
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
      <title>Library</title>
      
	  <link rel="stylesheet" type="text/css" href="style.css">

	  <meta name="viewport" content="width=device-width, initial-scale=1" /> 
      
   </head>
   
   <body bgcolor = "#FFFFFF">
	
      <div align = "center">
         <div style = "width:300px; border: solid 1px #333333; " align = "left">
            <div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Library</b></div>
				
            <div style = "margin:30px">
               
               <form action = "" method = "post">
                  <label>Register  Number :</label><br/><input type = "number" name = "register" class = "box"  /><br /><br />
				  <label>Book ID  :</label><br/><input type = "number" name = "book_id" class = "box"/><br/><br />
				  <label>Book Name  :</label><br/><input type = "text" name = "book_name" class = "box" /><br/><br />
				  <label>Issued On  :</label><br/><input type = "date" name = "issued_on" class = "box" /><br/><br />
                  <label>Issued Till  :</label><br/><input type = "date" name = "issued_till" class = "box" /><br/><br />
                  
				 	
			      						  
                  <input type = "submit" value = " Submit " class = "button"/><br /><br />
				 
			   </form>

			   <button onClick="window.location='librarysearch.php';"  class="button" >Show</button>
               <button onClick="window.location='libraryupdate.php';"  class="button" >Update</button></br>
               
               <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $message;  ?></div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>