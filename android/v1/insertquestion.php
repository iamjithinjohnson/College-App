<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

$message = '';



if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['subject']) and isset($_POST['code'])and isset($_POST['year'])and isset($_POST['file'])and isset($_POST['dept'])and isset($_POST['semester'])){
		
		$db = new DbOperations(); 
     
      $branch = $_POST['dept'];
      if ($branch == "Tool and Die") {
         $br = "TD";
      }elseif ($branch == "Computer Engineering") {
         $br = "CT";
      }else {
         $br = "EC";
      }

      $path = "http://192.168.43.150/android/v1/questionpaper/";
      $picture = $_POST['file'];
      $image = $path .''. $picture;
      

		$result = $db->createQuest($_POST['subject'], $_POST['code'], $_POST['year'], $image, $br, $_POST['semester']);
		if($result == 1){
			$response['error'] = false; 
         $response['message'] = "Staff registered successfully";
         $message = "Question Paper uploaded";
		}elseif($result == 2){
			$response['error'] = true; 
         $response['message'] = "Some error occurred please try again";		
         $message = "Some error occurred please try again";		
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
      <title>Add Question Paper</title>
      
       <link rel="stylesheet" type="text/css" href="style.css">
       <meta name="viewport" content="width=device-width, initial-scale=1" /> 

   </head>
   
   <body bgcolor = "#FFFFFF">
	
      <div align = "center">
         <div style = "width:300px; border: solid 1px #333333; " align = "left">
            <div style = "background-color:#333333; color:#FFFFFF; padding:3px;"><b>Add Question paper</b></div>
				
            <div style = "margin:30px">
               
               <form action = "" method = "post">
			   
				  <label>Subject  :</label></br><input type = "text" name = "subject" class = "box"/><br /><br />
                  <label>Subject Code :</label></br><input type = "number" name = "code" class = "box"/><br /><br />

                  <label>Paper year  :</label></br><input type = "text" name = "year" class = "box"/><br /><br />

                  <label>File  :</label></br><input type = "file" name = "file" class = "box"/><br /><br />

                  <label for="dept">Dept	:</label></br><select id="dept" name = "dept" class = "box"  >
							  <option  value="Tool and Die">Tool and Die</option>							  
							  <option  value="Computer Engineering">Computer Engineering</option>
							  <option  value="Electronics and Communication">Electronics and Communication</option>
							 </select></br></br>
                  <label for="Semester">Semester	:	</label><select id="semester" name = "semester" class = "box">
							  <option value="1">1</option>							  
							  <option value="2">2</option>
							  <option value="3">3</option>
							  <option value="4">4</option>
							  <option value="5">5</option>
							  <option value="6">6</option>
							 
						</select></br></br>					
              <input type = "submit" value = " Submit "class = "button"/><br />
              </form>
              
              <div style = "font-size:11px; color:#cc0000; margin-top:10px"><?php echo $message;  ?></div>
					
            </div>
				
         </div>
			
      </div>

   </body>
</html>