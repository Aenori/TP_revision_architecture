<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   </head> 
   <body>
      <form action = "" method = "POST">
         Date: <input type = "text" name = "date"><br />
         Sujet: <input type = "text" name = "sujet" /><br />
         Formateur: <input type = "text" name = "formateur" /><br />
         PaieFormateur: <input type = "integer" name = "paieFormateur" /><br />
         <input type = "submit" value = "Submit" />
      </form>
   </body>
</html>