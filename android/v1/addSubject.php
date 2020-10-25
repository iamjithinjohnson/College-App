




<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

$message = '';

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['subjectid']) and isset($_POST['subjectname']) and isset($_POST['totalclasses'])and isset($_POST['dept'])and isset($_POST['semester']))
		{
		//operate the data further 

		$db = new DbOperations(); 

		$br = $_POST['dept'];
		if ($br == "Tool and Die") {
			$branch = "TD";
		}elseif ($br == "Computer Engineering") {
			$branch = "CT";
		}else {
			$branch = "EC";
		}

		$result = $db->addsubject($_POST['subjectid'], $_POST['subjectname'], $_POST['totalclasses'], $_POST['dept'], $_POST['semester'], $branch);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "User subjectided successfully";
			$message = "User register successfully";					

		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred please try again";
			$message = "Some error occurred please try again";					
			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "It seems you are already registered, please choose a different register number";	
			$message = "It seems you are already registered, please choose a different register number";					
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
      <title>Add Subject</title>
      
	  <link rel="stylesheet" type="text/css" href="style.css">

	  <meta name="viewport" content="width=device-width, initial-scale=1" /> 
      
   </head>
   
   <body bgcolor = "#FFFFFF">
	
      <div align = "center">
         <div style = "width:300px; border: solid 1px #333333; " align = "left">
            <div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Add subject</b></div>
				
            <div style = "margin:30px">
               
               <form action = "" method = "post">
                  <label>Subject ID :</label><br/><input type = "text" name = "subjectid" class = "box"  /><br /><br />
				  <label>Subject name  :</label><br/><input type = "text" name = "subjectname" class = "box"/><br/><br />
				  <label>Total classes</label><br/><input type = "text" name = "totalclasses" class = "box" /><br/><br />
				  <label for="dept">Dept	:</label></br><select id="dept" name = "dept" class = "box"  >
							  <option value="Tool and Die">Tool and Die</option>							  
							  <option value="Computer Engineering">Computer Engineering</option>
							  <option value="Electronics and Communication">Electronics and Communication</option>
							 
						</select></br></br>
				 
				  
				   <label for="Semester">Semester	:	</label><select id="semester" name = "semester" class = "box">
							  <option value="1">1</option>							  
							  <option value="2">2</option>
							  <option value="3">3</option>
							  <option value="4">4</option>
							  <option value="5">5</option>
							  <option value="6">6</option>
							 
						</select></br></br>								  
                  <input type = "submit" value = " Submit " class = "button"/><br /><br />
				 
			   </form>

			   <button onClick="window.location='';"  class="button" >Modification</button></br>
               
               <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $message;  ?></div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>