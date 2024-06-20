<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="jakarta.tags.core" prefix="c"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Add or edit</h1>
<form:form action="/categories/list" modelAttribute="item" method="post">

<form:input path="categoryId" placeholder="Category Id?"/>
<form:input path="name" placeholder="Category Name?"/>
<hr>
<button formaction="/admin/categories/saveOrUpdate">Create</button>
<button formaction="/admin/categories/saveOrUpdate">Update</button>
<a href="/admin/categories/delete/${categoryId}">Delete</a>
<a href="/admin/home">Reset</a>
</form:form>
