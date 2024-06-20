<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="jakarta.tags.core" prefix="c"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
				<form class="form-inline">
  <div class="form-group mb-2" action="/admin/products/search" class="d-flex">
    <label for="staticEmail2" class="sr-only">Search By Price</label>
 
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <input class="mx-1" type="number"  value="${param.min}" name="min" placeholder="minprice">
	<input class="mx-1" type="number"  value="${param.max}" name="max" placeholder="maxprice">
  </div>
  <button type="submit" class="btn btn-primary mb-2">Search</button>
</form>