<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <b>${uri}</b>
<c:forEach var="item" items="${categories}">
<ul>
<li>${item.name}</li>
</ul>
</c:forEach>