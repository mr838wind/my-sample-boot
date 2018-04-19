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
    	function goUrl(url) {
    		location.href=url;
    	}
    </script>
</head>

    <h1>list</h1>
    
	<table>
	  <thead>
	    <tr>
	      <th >id</th>
	      <th >name</th>
	      <th >contents count</th>
	    </tr>
	  </thead>
	  <tbody>
	  	
	  	<!-- normal -->
	  	<c:if test="${ ! empty result.records }">
	  		<c:forEach items="${result.records}" var="item" >
	  			<c:set var="url" value="/sample/detail/${item.id}" />
			    <tr >
			      <td ><a href="${url}" >${item.id}</a></td>
			      <td onclick="javascript:goUrl('${url}');" >${item.name}</td>
			      <td data-hello="${item.id}" >${item.contentsCount}</td>  
			    </tr>
		    </c:forEach>
		</c:if>
	  	
	  	<!-- empty -->
	  	<c:if test="${ empty result.records }">
		  	<tr >
		      <td colspan="3">no itmes</td>
		    </tr>
	  	</c:if>
	  	
	  </tbody>
	</table>
    
</html>