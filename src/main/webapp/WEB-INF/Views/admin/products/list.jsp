<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<div class="container-xl">

	<div class="table-responsive">
		<div class="table-wrapper">

			<div><jsp:include page="addOrUpdate.jsp"></jsp:include></div>

			<form:form action="/admin/products/soft"
				enctype="multipart/form-data" method="post">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll"> <label for="selectAll"></label>
							</span></th>
							<th><a href="/admin/products/sort?field=id">Id</a></th>
							<th><a href="/admin/products/sort?field=name">Name</a></th>
							<th>Quantity</th>
							<th><a href="/admin/products/sort?field=price">Price</a></th>>
							<th>Description</th>
							<th>Discount</th>
							<th><a href="/admin/products/sort?field=createDate">Date</a></th>
							<th>Image</th>
							<th>Status</th>
							<th>Category</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.content}" var="item">
							<tr>
								<td><span class="custom-checkbox"> <input
										type="checkbox" id="checkbox1" name="options[]" value="1">
										<label for="checkbox1"></label>
								</span></td>
								<td>${item.productId}</td>
								<td>${item.name}</td>
								<td>${item.quantity}</td>
								<td>${item.unitPrice}</td>
								<td>${item.description}</td>
								<td>${item.discount}</td>
								<td>${item.enteredDate}</td>
								<td><img style="width: 70px; height: 70px" src="/images/${item.imageUrl}"
									alt="Product Image"></td>
								<td>${item.productStatus}</td>
								<td>${item.getCategory().getName()}</td>
								<td><button
										formaction="/admin/products/edit/${item.productId}"
										class="edit btn mb-1">
										<i class="material-icons" title="Edit">&#xE254;</i>
									</button>
									<button formaction="/admin/products/delete/${item.productId}"
										class="delete btn btn-dangẻr">
										<i class="material-icons" title="Delete">&#xE872;</i>
									</button></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</form:form>

			<div class="clearfix">
				<div class="hint-text">
					Showing <b>${page.numberOfElements}</b> out of <b>${page.totalElements}</b>
					entries
				</div>
				<ul class="pagination">
					<li class="page-item"><a href="/admin/products/page?p=0"
						class="page-link">First</a></li>
					<li class="page-item ${page.number == 0 ? 'disabled' : ''}"><a
						href="/admin/products/page?p=${page.number-1}" class="page-link">Previous</a>
					</li>

					<li
						class="page-item ${page.number+1 >= page.totalPages ? 'disabled' : ''}">
						<a
						href="/admin/products/page?p=${page.number+1 >= page.totalPages ? page.number : page.number+1}"
						class="page-link">Next</a>
					</li>
					<li class="page-item"><a
						href="/admin/products/page?p=${page.totalPages-1}"
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
		</div>
	</div>
</div>