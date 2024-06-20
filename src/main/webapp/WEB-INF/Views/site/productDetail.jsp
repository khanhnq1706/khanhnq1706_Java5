<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
     <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<style>
     body {
            background: grey;
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
</style>
<body>
    <nav class="navbar navbar-expand-xl navbar-light bg-light" >
        <a href="#" class="navbar-brand"><i class="fa fa-cube"></i>Tech<b>Bar</b></a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link active">Home</a>
                <a href="#" class="nav-item nav-link">About</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Services</a>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item">Web Design</a>
                        <a href="#" class="dropdown-item">Web Development</a>
                        <a href="#" class="dropdown-item">Graphic Design</a>
                        <a href="#" class="dropdown-item">Digital Marketing</a>
                    </div>
                </div>
                <a href="#FAQ" class="nav-item nav-link">FAQ</a>
                <a href="contact.html" class="nav-item nav-link">Contact</a>
            </div>
            <form class="navbar-form form-inline">
                <div class="input-group search-box">								
                    <input type="text" id="search" class="form-control" placeholder="Search by Name">
                    <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                </div>
            </form>
            <div class="navbar-nav ml-auto">
                <a href="#" class="nav-item nav-link notifications"><i class="fa fa-bell-o"></i><span class="badge">1</span></a>
                <a href="#" class="nav-item nav-link messages"><i class="fa fa-envelope-o"></i><span class="badge">10</span></a></a>
                <div class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="/image/hainham.jpg" class="avatar" alt="Avatar"> Paula Wilson <b class="caret"></b></a>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a></a>
                        <a href="#" class="dropdown-item"><i class="fa fa-calendar-o"></i> Calendar</a></a>
                        <a href="#" class="dropdown-item"><i class="fa fa-sliders"></i> Settings</a></a>
                        <div class="dropdown-divider"></div>
                        <a href="#" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Logout</a></a>
                    </div>
                </div>
                <a href="shoppingcart.html" class="side-menu">
                    <i class="fa fa-shopping-bag"></i>
                    <p>My Cart</p>
                </a>
             
            </div>
        </div>
    </nav>

      </div>
    <section style="background-color: #eee;">
        <div class="container py-5">
          <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6 col-xl-4">
              <div class="card" style="border-radius: 15px;">
                <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light"
                  data-mdb-ripple-color="light">
                  <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/12.webp"
                    style="border-top-left-radius: 15px; border-top-right-radius: 15px;" class="img-fluid"
                    alt="Laptop" />
                  <a href="#!">
                    <div class="mask"></div>
                  </a>
                </div>
                <div class="card-body pb-0">
                  <div class="d-flex justify-content-between">
                    <div>
                      <p><a href="#!" class="text-dark">Dell Xtreme 270</a></p>
                      <p class="small text-muted">Laptops</p>
                    </div>
                    <div>
                      <div class="d-flex flex-row justify-content-end mt-1 mb-4 text-danger">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                      </div>
                      <p class="small text-muted">Rated 4.0/5</p>
                    </div>
                  </div>
                </div>
                <hr class="my-0" />
                <div class="card-body pb-0">
                  <div class="d-flex justify-content-between">
                    <p><a href="#!" class="text-dark">$3,999</a></p>
                    <p class="text-dark">#### 8787</p>
                  </div>
                  <p class="small text-muted">VISA Platinum</p>
                </div>
                <hr class="my-0" />
                <div class="card-body">
                  <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
                    <a href="#!" class="text-dark fw-bold">Cancel</a>
                    <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary">Buy now</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
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
          <div class="container">
            <div class="d-flex justify-content-between py-4 border-top">
              <!--- payment --->
              <div>
                <i class="fab fa-lg fa-cc-visa text-white"></i>
                <i class="fab fa-lg fa-cc-amex text-white"></i>
                <i class="fab fa-lg fa-cc-mastercard text-white"></i>
                <i class="fab fa-lg fa-cc-paypal text-white"></i>
              </div>
              <!--- payment --->
      
              <!--- language selector --->
              <div class="dropdown dropup">
                <a class="dropdown-toggle text-white" href="#" id="Dropdown" role="button" data-mdb-toggle="dropdown" aria-expanded="false"> <i class="flag-united-kingdom flag m-0 me-1"></i>English </a>
      
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="Dropdown">
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-united-kingdom flag"></i>English <i class="fa fa-check text-success ms-2"></i></a>
                  </li>
                  <li><hr class="dropdown-divider" /></li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-poland flag"></i>Polski</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-china flag"></i>中文</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-japan flag"></i>日本語</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-germany flag"></i>Deutsch</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-france flag"></i>Français</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-spain flag"></i>Español</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-russia flag"></i>Русский</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#"><i class="flag-portugal flag"></i>Português</a>
                  </li>
                </ul>
              </div>
              <!--- language selector --->
            </div>
          </div>
        </div>
      </footer>
</body>
</html>