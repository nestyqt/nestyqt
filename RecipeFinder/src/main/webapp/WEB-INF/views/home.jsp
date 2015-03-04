<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h2>Contact Manager</h2>

<form action="showrecipe"  method="post" commandName="inputForm" >

    	
    <div>Fridge CSV
    	<input type="text" name="fridgeFilePath" >
    </div>
    <div>JSON file
    	<input type="text" name="recipeFilePath">
    </div>
    
    <input type="submit" value="Submit">
	</p>
</form>

</body>
</html>
