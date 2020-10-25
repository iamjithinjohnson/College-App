<?php 

require_once '../includes/DbOperations.php';

$response = array(); 
$register = $bookname = $message = $issuedon = $issuedtill = $name = $semester = $branch= "";
if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['save'])){
		$update = false;
		$db = new DbOperations(); 

		
			$user = $db->getUserBylibrary($_POST['book_id']);
			if ($user == 0) {
				$message = "Entered Book ID NotExist";
			}else {
				$response['error'] = false; 
				$bookname = $user['book_name'];
				$issuedon = $user['issued_on'];
				$issuedtill = $user['issued_till'];
				$register = $user['register'];
				$person = $db->getUserByregister($register);
				$name = $person['name'];
				$semester = $person['semester'];
				$branch = $person['branch'];
				
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
					
				
				   		<input type = "submit" value = " Search " name = "save"class = "button"/><br /><br />
				  
				   
				  <label>Register  Number :</label>   <span class="label success"><?php echo $register;  ?></span><br/><br/>
				  
				  <label>Name  :</label>    &emsp;&emsp;&emsp;<span class="label success"><?php echo $name;  ?></span><br/><br/>

				  <label>Semester  :</label>    &emsp;&emsp;&nbsp;<span class="label success"><?php echo $semester;  ?></span><br/><br/>

				  <label>Branch  :</label>    &emsp;&emsp;&emsp;&nbsp;<span class="label success"><?php echo $branch;  ?></span><br/><br/>
				
				 
				  <label>Book Name  :</label>  &emsp;&nbsp;<span class="label success"><?php echo $bookname;  ?></span><br/><br/>
				  
				  <label>Issued On  :</label>    &emsp;&emsp;<span class="label success"><?php echo $issuedon;  ?></span><br/><br/>
				  
				  <label>Issued Till  :</label>   &emsp;&emsp;<span class="label success"><?php echo $issuedtill;  ?></span><br/><br/>
				  
				
				 	
				  
				
                  
				 	
			      						  
                
			   </form>

			 

              
               
               <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $message;  ?>	</div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>