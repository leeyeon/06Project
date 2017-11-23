<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value = "EUC-KR" />

<html>
<head>
<title>열어본 상품 보기</title>
</head>

<body>
	<center>< 열어본 상품 목록 ></center><br><br>

<c:forEach var="i" items="${history}">
	<a href="/getProduct.do?prodNo=${i}&menu=search" target="rightFrame">${i}</a><br>
</c:forEach>

</body>
</html>