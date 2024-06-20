<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib uri="jakarta.tags.core" prefix="c"  %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>${pageInfo.title}</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
     <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
       <style>
        body {
            background: grey;
        }
.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 18rem;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.card-img-top {
  width: 100%;
  height: auto;
}

.card-body {
  padding: 2px 16px;
}

.card-title {
  font-size: 1.2em;
}

.card-text,
.card-price,
.card-disscount,
.card-status {
  margin-bottom: 15px;
}

.add-to-cart-btn {
  margin-top: 10px;
}

        
        .side-menu p{
	display: inline-block;
}
        .form-inline {
            display: inline-block;
        }
        .navbar-header.col {
            padding: 0 !important;
        }
        .navbar {		
            background: #fff;
            padding-left: 16px;
            padding-right: 16px;
            border-bottom: 1px solid #d6d6d6;
            box-shadow: 0 0 4px rgba(0,0,0,.1);
        }
        .nav-link img {
            border-radius: 50%;
            width: 36px;
            height: 36px;
            margin: -8px 0;
            float: left;
            margin-right: 10px;
        }
        .navbar .navbar-brand {
            color: #555;
            padding-left: 0;
            padding-right: 50px;
            font-family: 'Merienda One', sans-serif;
        }
        .navbar .navbar-brand i {
            font-size: 20px;
            margin-right: 5px;
        }
        .search-box {
            position: relative;
        }	
        .search-box input {
            box-shadow: none;
            padding-right: 35px;
            border-radius: 3px !important;
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 7px;
            height: 100%;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
        }
        .navbar .nav-item i {
            font-size: 18px;
        }
        .navbar .dropdown-item i {
            font-size: 16px;
            min-width: 22px;
        }
        .navbar .nav-item.open > a {
            background: none !important;
        }
        .navbar .dropdown-menu {
            border-radius: 1px;
            border-color: #e5e5e5;
            box-shadow: 0 2px 8px rgba(0,0,0,.05);
        }
        .navbar .dropdown-menu a {
            color: #777;
            padding: 8px 20px;
            line-height: normal;
        }
        .navbar .dropdown-menu a:hover, .navbar .dropdown-menu a:active {
            color: #333;
        }	
        .navbar .dropdown-item .material-icons {
            font-size: 21px;
            line-height: 16px;
            vertical-align: middle;
            margin-top: -2px;
        }
        .navbar .badge {
            color: #fff;
            background: #f44336;
            font-size: 11px;
            border-radius: 20px;
            position: absolute;
            min-width: 10px;
            padding: 4px 6px 0;
            min-height: 18px;
            top: 5px;
        }
        .navbar a.notifications, .navbar a.messages {
            position: relative;
            margin-right: 10px;
        }
        .navbar a.messages {
            margin-right: 20px;
        }
        .navbar a.notifications .badge {
            margin-left: -8px;
        }
        .navbar a.messages .badge {
            margin-left: -4px;
        }	
        .navbar .active a, .navbar .active a:hover, .navbar .active a:focus {
            background: transparent !important;
        }
        @media (min-width: 1200px){
            .form-inline .input-group {
                width: 300px;
                margin-left: 30px;
            }
        }
        @media (max-width: 1199px){
            .form-inline {
                display: block;
                margin-bottom: 10px;
            }
            .input-group {
                width: 100%;
            }
        }
        h2 {
	color: #000;
	font-size: 26px;
	font-weight: 300;
	text-align: center;
	text-transform: uppercase;
	position: relative;
	margin: 30px 0 60px;
}
h2::after {
	content: "";
	width: 100px;
	position: absolute;
	margin: 0 auto;
	height: 4px;
	border-radius: 1px;
	background: #7ac400;
	left: 0;
	right: 0;
	bottom: -20px;
}

.carousel .thumb-content .btn:hover, .carousel .thumb-content .btn:focus {
	color: #fff;
	background: #7ac400;
	box-shadow: none;
}

.carousel-control-prev, .carousel-control-next {
	height: 44px;
	width: 40px;
	background: #7ac400;	
	margin: auto 0;
	border-radius: 4px;
	opacity: 0.8;
}
.carousel-control-prev:hover, .carousel-control-next:hover {
	background: #78bf00;
	opacity: 1;
}


        </style>
        <script>

$(document).ready(function(){
	$(".wish-icon i").click(function(){
		$(this).toggleClass("fa-heart fa-heart-o");
	});
});	
// Arccodion
$(document).ready(function(){
	// Add minus icon for collapse element which is open by default
	$(".collapse.show").each(function(){
		$(this).siblings(".card-header").find(".btn i").html("remove");
	});
	
	// Toggle plus minus icon on show hide of collapse element
	$(".collapse").on('show.bs.collapse', function(){
		$(this).parent().find(".card-header .btn i").html("remove");
	}).on('hide.bs.collapse', function(){
		$(this).parent().find(".card-header .btn i").html("add");
	});
});
</script>
        </script>
</head>
<body>
    <nav class="navbar navbar-expand-xl navbar-light bg-light" >
        <a href="#" class="navbar-brand"><i class="fa fa-cube"></i>Tech<b>Bar</b></a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
            <div class="navbar-nav">
                <a href="/home/index" class="nav-item nav-link active">Home</a>
                <a href="#" class="nav-item nav-link">About</a>
                <a href="#FAQ" class="nav-item nav-link">FAQ</a>
                <a href="/home/contact" class="nav-item nav-link">Contact</a>
            </div>
            <form action="home/search" class="navbar-form form-inline">
                <div class="input-group search-box">								
                    <input type="text" value="Laptop" id="search" class="form-control" placeholder="Search by Name">
                    <a href="/home/search"><span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span></a>
                </div>
            </form>
            <div class="navbar-nav ml-auto">
                <a href="#" class="nav-item nav-link notifications"><i class="fa fa-bell-o"></i><span class="badge">1</span></a>
                <a href="#" class="nav-item nav-link messages"><i class="fa fa-envelope-o"></i><span class="badge">10</span></a></a>
                <c:if test="${curentUser.getRole().Admin}">
											<button class="btn btn-secondary "><a class="dropdown-item"
												href="/admin/home">Quản trị</a></button>
										</c:if>
										<div class="btn-group">
							<a type="button" class="btn btn-secondary dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">My
								Account</a>
							<ul class="dropdown-menu dropdown-menu-end">
								<c:choose>
									<c:when test="${not isLogin and empty currentUser}">
									
										<li><a class="dropdown-item"
											href="/account/login">Đăng
												nhập/Đăng kí</a></li>
									</c:when>
									<c:otherwise>

    									<li><a href="/home/editprofie" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a></a></li>
										<li><a class="dropdown-item"
											href="/AssignmentJava4_Gd1/Admin/users/ChangePassword.jsp">Đổi mật
												khẩu</a></li>
										<li><a class="dropdown-item" href="/home/logoff">Logout</a></li>
										
										<!-- Thêm dòng này -->
										
									</c:otherwise>
								</c:choose>

							</ul>
						</div>
                
                <a href="/shoppingCart/listShoppingCart" class="side-menu">
                    <i class="fa fa-shopping-bag"></i>
                    <p>My Cart</p>
                </a>
             
            </div>
        </div>
    </nav>
    <!-- product navbar -->
  
<!-- list product -->
    <div id="carouselExampleCaptions" class="carousel slide mb-2"  style=" max-width:100%; max-height: 550px;" data-ride="carousel" >
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="/images/banner1.png" style="max-width:100%; max-height: 550px" class="d-block" alt="...">
            <div class="carousel-caption d-none d-md-block " >
            </div>
          </div>
          <div class="carousel-item ">
            <img src="/images/banner2.jpg" style="max-width:100%; max-height: 550px " class="d-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
       
            </div>
          </div>
          <div class="carousel-item ">
            <img src="/images/banner3.jpg" style="max-width:100%; max-height: 550px" class="d-block" alt="...">
            <div class="carousel-caption d-none d-md-block">
  
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-target="#carouselExampleCaptions" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-target="#carouselExampleCaptions" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </button>
        </div>
        <section class=" container-fluid d-flex flex-row">
			<div class="me-1 mb-3 row">
			<div class="col-3"><jsp:include page="${pageInfo.contentUrl}"></jsp:include></div>
			</div>
           </section>
                        
   
      	
    <!-- Fooot -->
    <footer class="text-center text-lg-start text-muted bg-primary mt-3">
        <!-- Section: Links  -->
        <section class="">
          <div class="container text-center text-md-start pt-4 pb-4">
            <!-- Grid row -->
            <div class="row mt-3">
              <!-- Grid column -->
              <div class="col-12 col-lg-3 col-sm-12 mb-2">
                <!-- Content -->
                <a href="https://mdbootstrap.com/" target="_blank" class="text-white h2">
                  MDB
                </a>
                <p class="mt-1 text-white">
                  © 2023 Copyright: TechBar.com
                </p>
              </div>
            </div>
            <!-- Grid row -->
          </div>
        </section>
        <!-- Section: Links  -->
      
        <div class="">
          <div class="container-fluid">
            <div class="d-flex justify-content-between py-4 border-top">
              <!--- payment --->
              <div>
                <i class="fab fa-lg fa-cc-visa text-white"></i>
                <i class="fab fa-lg fa-cc-amex text-white"></i>
                <i class="fab fa-lg fa-cc-mastercard text-white"></i>
                <i class="fab fa-lg fa-cc-paypal text-white"></i>
              </div>
              
              
              <script type="text/javascript">
              ${pageInfo.scriptUrl}
              </script>
            </div>
          </div>
        </div>
      </footer>
</body>
</html>