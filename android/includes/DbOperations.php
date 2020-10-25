<?php 

	class DbOperations{

		private $con; 

		function __construct(){

			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();

		}

		/*CRUD -> C -> CREATE */

		public function createUser($register, $date, $name, $dept, $semester, $address, $gender, $branch){
			if($this->isUserExist($register)){
				return 0; 
			}else{
				$stmt = $this->con->prepare("INSERT INTO `user` (`id`, `register`, `date`, `name`, `dept`, `semester`, `address`, `gender`, `branch`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?);");
				$stmt->bind_param("ssssssss",$register, $date, $name, $dept, $semester, $address, $gender, $branch);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}

		public function userLogin($register, $date){
			$stmt = $this->con->prepare("SELECT id FROM user WHERE register = ? AND date = ?");
			$stmt->bind_param("ss",$register,$date);
			$stmt->execute();
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

		public function getUserByregister($register){
			$stmt = $this->con->prepare("SELECT * FROM user WHERE register = ?");
			$stmt->bind_param("s",$register);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}
		

		private function isUserExist($register){
			$stmt = $this->con->prepare("SELECT id FROM user WHERE register = ?");
			$stmt->bind_param("s", $register);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}
		
		public function adminLogin($register, $date){
			$stmt = $this->con->prepare("SELECT id FROM admin WHERE username = ? AND password = ?");
			$stmt->bind_param("ss",$register,$date);
			$stmt->execute();
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}
		public function getAdminByUsername($register){
			$stmt = $this->con->prepare("SELECT * FROM admin WHERE username = ?");
			$stmt->bind_param("s",$register);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}
		
		public function getStaffList(){
			$stmt = $this->con->prepare("SELECT * FROM stafflist");
			$stmt->execute();
			$stmt->bind_result("ssssss",$id,$name,$dept,$charge,$mob,$image);
			return $stmt->get_result()->fetch_assoc();
		}
		
		public function createStaff($name, $dept, $charge, $mob, $image, $branch){
			if($this->isStaffExist($mob)){
				return 0; 
			}else{
				$stmt = $this->con->prepare("INSERT INTO `stafflist` (`id`, `name`, `dept`, `charge`, `mob`, `image`, `branch`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
				$stmt->bind_param("ssssss",$name, $dept, $charge ,$mob, $image, $branch);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}
		private function isStaffExist($mob){
			$stmt = $this->con->prepare("SELECT id FROM stafflist WHERE mob = ?");
			$stmt->bind_param("s", $mob);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}	
		
		public function deleteUser($register){
			if($this->isUserExist($register)){
				$stmt = $this->con->prepare("DELETE FROM user WHERE register = ?");
				$stmt->bind_param("s",$register);
				if($stmt->execute())
					return 3; 
				else
					return 4; 		
				$stmt->store_result(); 
				return $stmt->num_rows > 0;
			 }else{
				return 1;
			}
			
		
		}

		public function updateUser($register, $date, $name, $dept, $semester, $address, $gender, $branch){
			if($this->isUserExist($register)){
				$stmt = $this->con->prepare("UPDATE user SET date = ?, name = ?, dept = ?, semester = ?, address = ?, gender = ?, branch = ?  WHERE register = ?");
				$stmt->bind_param("ssssssss",$date, $name, $dept, $semester, $address, $gender, $branch, $register);
				if($stmt->execute())
					return 3; 
				else
					return 4; 	
				$stmt->store_result(); 
				return $stmt->num_rows > 0; 				 
			}else{
				return 1;
			}

			
		}

		public function addsubject($subjectid, $subjectname, $totalclasses, $dept, $semester, $branch){
			if($this->subjectExist($subjectid)){
				return 0; 
			}else{
				$stmt = $this->con->prepare("INSERT INTO `addsubject` (`id`, `subjectid`, `subjectname`, `totalclasses`, `dept`, `semester`, `branch`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
				$stmt->bind_param("ssssss",$subjectid, $subjectname, $totalclasses, $dept, $semester, $branch);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}

		private function subjectExist($subjectid){
			$stmt = $this->con->prepare("SELECT id FROM addsubject WHERE subjectid = ?");
			$stmt->bind_param("s", $subjectid);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

		public function createNotify($address, $date, $topic){
				$stmt = $this->con->prepare("INSERT INTO `notification` (`id`, `notify`, `topic`, `date`) VALUES (NULL, ?, ?, ?);");
				$stmt->bind_param("sss",$address, $date, $topic);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			
		}
		public function insertlib($register, $bookid, $bookname, $issuedon, $issuedtill){
			if($this->isUserExist($register)){
				$stmt = $this->con->prepare("INSERT INTO `library` (`id`, `register`, `book_id`, `book_name`, `issued_on`, `issued_till`, `returned_on`, `fine`) VALUES (NULL, ?, ?, ?, ?, ?, NULL, NULL);");
				$stmt->bind_param("sssss",$register, $bookid, $bookname, $issuedon, $issuedtill);
	
				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
				
			}else {
				return 0; 
			}
		
		
	}
	private function isBookExist($bookid){
		$stmt = $this->con->prepare("SELECT id FROM library WHERE book_id = ?");
		$stmt->bind_param("s", $bookid);
		$stmt->execute(); 
		$stmt->store_result(); 
		return $stmt->num_rows > 0; 
	}

	public function getUserBylibrary($bookid){
		if($this->isBookExist($bookid)){
			$stmt = $this->con->prepare("SELECT * FROM library WHERE book_id = ?");
			$stmt->bind_param("s",$bookid);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}else {
			return 0;
		}
	
	}

	public function libraryupdate($bookid, $returnon, $fine){
		if($this->isBookExist($bookid)){
			$stmt = $this->con->prepare("UPDATE library SET returned_on = ?, fine = ? WHERE book_id = ?");
			$stmt->bind_param("sss", $returnon, $fine, $bookid);
			if($stmt->execute()){
				return 3; 
			}else{
				return 4; 
			}
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}else {
			return 1;
		}
	
	}

	public function createQuest($register, $date, $name, $dept, $semester, $address){
	
	
		$stmt = $this->con->prepare("INSERT INTO `question` (`id`, `subject`, `code`, `paper`, `url`, `branch`, `semester`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
		$stmt->bind_param("ssssss",$register, $date, $name, $dept, $semester, $address);

		if($stmt->execute()){
			return 1; 
		}else{
			return 2; 
		}
	
	}

		

	}