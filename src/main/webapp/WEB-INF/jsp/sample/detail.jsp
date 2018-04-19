<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script  >
    </script>
</head>

    <h1>detail</h1>
    
	<table>
	  <thead>
	    <tr>
	      <th >Name</th>
	      <th >Price</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr >
	      <td >${result.id}</td>
	      <td >${result.name}</td>
	    </tr>
	  </tbody>
	</table>
    
</html>