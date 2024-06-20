<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <form action="/shoppingCart/" method="post">
        <div class="col-lag-3">
        <c:forEach items="${page.content}" var="item">
   <div class="col-lg-3 card mb-2 px-2" style="max-width: 18rem">
  <img src="/images/${item.imageUrl}" class="card-img-top" style="max-width: 100px;" alt="${item.name}">
  <div class="card-body">
    <h5 class="card-title">${item.name}</h5>
    <p class="card-text">Thể loại: ${item.getCategory().getName()}</p>
    <div class="row ">
      <p class="col-sm-12 card-price">${item.unitPrice}</p>
      <p class="col-sm-12 card-disscount">${item.description}</p>
      <p class="col-sm-12 card-status">${item.productStatus}</p>
      <button class="btn btn-primary add-to-cart-btn"><a href="/shoppingCart/add/${item.productId}" class="text-light">Add to Cart</a></button>
    </div>
  </div>
</div>
 </c:forEach>
        </div>
    
              </form>
              <div class="contaier">
              <ul class="pagination">
		<li class="page-item"><a href="/home/index?p=0"
			class="page-link">First</a></li>
		<li class="page-item ${page.number == 0 ? 'disabled' : ''}"><a
			href="/home/page?last&p=${page.number-1}" class="page-link">Previous</a>
		</li>

		<li
			class="page-item ${page.number+1 >= page.totalPages ? 'disabled' : ''}">
			<a
			href="/home/page?last&p=${page.number+1 >= page.totalPages ? page.number : page.number+1}"
			class="page-link">Next</a>
		</li>

		<li class="page-item"><a
			href="/home/page?last&p=${page.totalPages-1}"
			class="page-link">Last</a></li>
	</ul>
	
              </div>


 