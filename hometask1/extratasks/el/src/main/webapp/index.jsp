<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting page</title>
    <meta charset="UTF-8">
</head>
<body>
    <a href="${pageContext.request.contextPath}/artist/create">Create NEW Artist</a><br><br>
    <form action="${pageContext.request.contextPath}/artist" method="get">Нати по id
        <label for="id">Artist's ID</label>
        <input type="text" name="id" id="id">
        <button type="submit">Search</button>
    </form><br>
    <br>
    <a href="${pageContext.request.contextPath}/artists">Show all artists</a><br>

</body>
</html>
