<?php 

require_once '../includes/DbOperations.php';

$response = array(); 
$message= "";
if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['save'])){
		
		$db = new DbOperations(); 

		
			$user = $db->libraryupdate($_POST['book_id'],$_POST['return_on'],$_POST['fine']);
			if ($user == 3) {
				$message = "Updated";
			}
			if ($user == 4) {
				$message = "Some error occurred please try again";	
			}
			if ($user == 1) {
				$message = "Entered Book ID NotExist";	
			
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




echo json_encode($response);

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
			   		
					<label>Book ID  :</label><br/><input type = "number" name = "book_id" class = "box"/><br/><br />
								  
				  <label>Return On  :</label> <input type = "date" name = "return_on" class = "box" /><br/><br />

				  <label>Fine  :</label> <input type = "number" name = "fine" class = "box" /><br/><br />

				  <input type = "submit" value = " Submit " name = "save"class = "button"/><br /><br />
				  
				 	
				  
				
                  
				 	
			      						  
                
			   </form>

			 

              
               
               <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $message;  ?>	</div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>