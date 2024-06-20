<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<!-- Edit Modal HTML -->
<form class="form-inline mb-4" action="/admin/products/search"
	class="d-flex" method="post">
	<div class="form-group mb-2">
		<label for="staticEmail2" class="sr-only">Search By Price</label>

	</div>
	<div class="form-group mx-sm-3 mb-2"></div>
	<button type="submit" class="btn btn-primary mb-2">Search</button>
</form>
<form:form action="admin/products/saveOrUpdate" method="post"
	modelAttribute="productItem" enctype="multipart/form-data">
	<div class="table-title">
		<div class="row">
			<div class="col-sm-6">
				<h2>
					Manage <b>Product</b>
				</h2>
			</div>
			<div class="col-sm-6">
				<button formaction="/admin/products/saveOrUpdate"
					class="btn btn-success">
					<i class="material-icons">&#xE147;</i> <span>Add New Product</span>
				</button>
				<button formaction="/admin/products/saveOrUpdate"
					class="btn btn-success">
					<i class="material-icons">&#xE147;</i> <span>Update Product</span></button>
				<button formaction="/admin/products/delete/${productItem.productId}" class="btn btn-danger">
				<i class="material-icons">&#xE15C;</i> <span>Delete</span></button>
			</div>
		</div>
	</div>
	<div class="modal-header">
		<h4 class="modal-title">Update Product</h4>
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
	</div>
	<div class="form-group"></div>
	<div class="form-group">
		<label for="category">Category</label> <select name="categories"
			id="categoryId">
			<c:forEach items="${categories}" var="category">
				<option value="${category.categoryId}"
					${category.categoryId == productItem.category.categoryId ? 'selected' : ''}>${category.name}</option>
				<br>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label>Name</label>
		<form:input path="name" type="text" />
	</div>
	<div class="form-group">
		<label>Id</label>
		<form:input path="productId" type="number" />
	</div>
	<div class="form-group">
		<label>Quantity</label>
		<form:input path="quantity" type="number" />
	</div>
	<div class="form-group">
		<label>Price</label>
		<form:input path="unitPrice" type="number" />
	</div>
	<div class="form-group">
		<label>Description</label>
		<form:textarea path="description" />

	</div>
	<div class="form-group">
		<label>Discount</label>
		<form:input path="discount" type="number" />

	</div>
	<div class="form-group">
		<label>EnterDate</label>
		<form:input path="enteredDate" type="date" />
	</div>
	<div class="form-group">
		<label>Image: ${productItem.imageUrl}</label> <input name="image"
			type="file">

	</div>
	<div class="form-group">
		<label for="productStatus">Product Status</label>
		<form:select path="productStatus" id="productStatus">
			<form:options items="${productStatusValues}" />
		</form:select>
	</div>
</form:form>


