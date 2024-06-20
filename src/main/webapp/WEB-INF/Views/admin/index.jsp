<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
 <title>${pageInfo.title}</title>
<!-- Thêm Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
 <form action="/admin/home" method="post">
      <main class="container-fluid">
                <!-- Nav tabs -->
       <nav class="navbar navbar-expand-sm navbar-light bg-light col">
        <a class="navbar-brand" href="/admin/CategoryManagerServlet">Adminstration</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/home">Home <span class="sr-only"></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/home"><i class="fa fa-info" aria-hidden="true"></i>Products</a>
                </li>
                
                    <a href="/admin/CategoryManagerServlet" class="nav-link"><i class="fa fa-id-card" aria-hidden="true"></i> Categories</a>
               
          
                <div class="nav-item">
                    <a href="ReportServlet" class="nav-link"><i class="fa fa-comments" aria-hidden="true"></i> Reports</a>
                
                </div>
          
            </ul>
          
        </div>
       </nav>
           
           <section class="row">
			<div class="col">
			<jsp:include page="${pageInfo.contentUrl}"></jsp:include>
			</div>
           </section>
          
            <footer class="row"></footer>
        
      </main>
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
      <c:if test="${not empty pageInfo.scriptUrl}">
  <jsp:include page="${pageInfo.scriptUrl}"></jsp:include>
  </c:if>



<script>
//Lưu tab đang kích hoạt vào localStorage khi người dùng click vào tab
$('.nav-item a').on('click', function(e) {
  e.preventDefault();
  $(this).tab('show');
  localStorage.setItem('activeTab', $(this).attr('href'));
});

// Khi tải lại trang, kích hoạt tab đã lưu
var activeTab = localStorage.getItem('activeTab');
if(activeTab){
  $('.nav-item a[href="' + activeTab + '"]').tab('show');
}
</script>

</body>
</html>
