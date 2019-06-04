<%--
  Created by IntelliJ IDEA.
  User: Oliver
  Date: 2019/6/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>转账账号</th>
        <th>收款账号</th>
        <th>转账金额</th>
    </tr>
    <c:forEach items="${pageinfo.list}" var="log">
        <tr>
            <td>${log.accOut}</td>
            <td>${log.accIn}</td>
            <td>${log.money}</td>
        </tr>
    </c:forEach>
</table>
<a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber-1}" <c:if  test="${pageinfo.pageNumber<=1}"> tonclick="javascript: return false;"</c:if>>上一页</a>
<a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber+1}" <c:if  test="${pageinfo.pageNumber>=pageinfo.total}"> tonclick="javascript: return false;"</c:if>>下一页</a>
</body>
</html>
