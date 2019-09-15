<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<link  rel="stylesheet " href="views/w3.css">
<link  rel="stylesheet " href="views/font-awesome.min.css">
<script type="text/javascript" src="views/jquery.min.js"></script>
<script type="text/javascript" src="views/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function() {
      $("#bookForm").validate({
    	  rules: {
    	  bookName: {
          required: true
        },
        bookPrice: {
          required: true
        },
        bookAuthor: {
          required: true
        }
      },
      messages: {
    	  bookName: {
          required: "&nbsp;Book Name is a required field!!!"
        },
        bookPrice: {
          required: "&nbsp;Book Price is a required field!!!"
        },
        bookAuthor: {
          required: "&nbsp;Book Author is a required field!!!"
        }
          }
      });
});
</script>

<style type="text/css">
h1 {
	color: red;
	text-align: center;
}
.error {
      color: red;
   }

</style>
</head>
<body>
<div class="w3-container w3-card-4 w3-dark-gray" style="width:500px;margin: 0px auto">
<h1>Books Details</h1>
<font style="color:green">${msg }</font>
<form:form action="bookReg" method="POST" modelAttribute="books" id="bookForm">
<p>
<label>Book Id::</label>
<form:input  class="w3-input w3-border" path="bookId"/> 
</p>
<p>
<label>Book Name::</label>
<form:input  class="w3-input w3-border" path="bookName"/> 
</p>
<p><label>Book Price::</label>
<form:input class="w3-input w3-border"  path="bookPrice"/> 
</p>
<p><label>Book Author::</label>
<form:input  class="w3-input w3-border"  path="bookAuthor"/> 
</p> 
<p class="w3-center"><input type="reset" value="reset" class="w3-button w3-red w3-large w3-hover-orange">
<input type="submit" value="submit" class="w3-button w3-green w3-large w3-hover-lime">
 </p>
</form:form>
</div>
<hr>
<div class="w3-container">
<c:if test="${! empty booksList}">
<table border="1" class="w3-table" >
<tr class="w3-teal">
<th>Book Id</th>
<th>Book Name</th>
<th>Book Price</th>
<th>Book Author</th>
<th>Action</th>
</tr>
<c:forEach var="book" items="${booksList}" >
<tr>
<td>${book.bookId }</td>
<td>${book.bookName }</td>
<td>${book.bookPrice }</td>
<td>${book.bookAuthor }</td>
<td>
<a href="/editBook?id=${book.bookId }" class="w3-blue w3-button">Edit</a>
<a href="/delete?id=${book.bookId }" class="w3-red w3-button" onclick="return confirm('Are U Sure U want to delete?')" >Delete</a>
</td>
</tr>
</c:forEach>
</table>
</c:if>
</div>
</body>
</html>