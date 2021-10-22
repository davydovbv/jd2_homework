<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
       <tr>
        <th>ID</th>
        <th>Artist Name</th>
        <th>Language</th>
       </tr>
    </thead>
    <tbody>
        <c:forEach var="artist" items="${requestScope.artists}">
            <tr>
                <td><a href="${pageContext.request.contextPath}/artist?id=${artist.id}">ID</a></td>
                <td>${artist.name}</td>
                <td>${artist.language}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>