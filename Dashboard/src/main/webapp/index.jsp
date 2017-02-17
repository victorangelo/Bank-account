<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
	     <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <title>Parse Transactions</title>
		  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
		  <link rel="stylesheet" type="text/css" href="css/style.css">
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		  <script src="javascript/script.js"></script>
	</head>
	<body style="background-color: lightblue;">
	 
 	<div>
 			Problem to solve:
 			<br/>
 			This Java Web Application scans a folder for transactions.xml file importing all transactions to the database.
 			<br/><br/><br/><br/>
 	</div>	
	 
	 <div>
	 	<div class="upperDiv"><input type="file" webkitdirectory multiple id="folder1" style="display:none">
     		 <a href="#" onclick="openFolderOption();return;">OPEN FOLDER DIALOG </a></br>
        </div>
		<div  id="progressbar"  class="upperDiv"></div>
	</div> 
	
	<br/><br/><br/><br/>
	//adding the Log History here
	
	 	
	</body>
</html>