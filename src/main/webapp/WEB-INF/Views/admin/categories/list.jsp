<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>CATEGORY MANAGEMENT</h3>
<jsp:include page="addOrEdit.jsp"></jsp:include>
<hr>
<table border="1" style="width: 100%">
	<tr>
		<th>CategoryId</th>
		<th>Name</th>
		<th></th>
	</tr>
	<c:forEach var="item" items="${page.content}">
		<tr>
			<td>${item.categoryId}</td>
			<td>${item.name}</td>
			<td><a href="/admin/categories/edit/${item.categoryId}">Edit</a></td>
		</tr>
	</c:forEach>
</table>
<div class="clearfix">
	<div class="hint-text">
		Showing <b>${page.numberOfElements}</b> out of <b>${page.totalElements}</b>
		entries
	</div>
	<ul class="pagination">
		<li class="page-item"><a href="/admin/categories/page?p=0"
			class="page-link">First</a></li>
		<li class="page-item ${page.number == 0 ? 'disabled' : ''}"><a
			href="/admin/categories/page?p=${page.number-1}" class="page-link">Previous</a>
		</li>

		<li
			class="page-item ${page.number+1 >= page.totalPages ? 'disabled' : ''}">
			<a
			href="/admin/categories/page?p=${page.number+1 >= page.totalPages ? page.number : page.number+1}"
			class="page-link">Next</a>
		</li>

		<li class="page-item"><a
			href="/admin/categories/page?p=${page.totalPages-1}"
			class="page-link">Last</a></li>
	</ul>
</div>
<ul>
	<li>Số thực thể hiện tại: ${page.numberOfElements}</li>
	<li>Trang số: ${page.number}</li>
	<li>Kích thước trang: ${page.size}</li>
	<li>Tổng số thực thể: ${page.totalElements}</li>
	<li>Tổng số trang: ${page.totalPages}</li>
</ul>