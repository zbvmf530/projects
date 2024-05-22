<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
<!-- NAVBAR -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
      <div class="container">
    
        <!-- Brand -->
        <a class="navbar-brand" href="./overview.html">
          Shopper.
        </a>
    
        <!-- Toggler -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="navbarCollapse">
    
          <!-- Nav -->
          <ul class="navbar-nav mx-auto">
            
             <c:forEach var="category" items="${totalList}">
 
	            <li class="nav-item dropdown position-static">    
	              <!-- Toggle -->
	              <a class="nav-link" data-bs-toggle="dropdown" href="#">${category.key}</a>
	   
	              <!-- Menu -->
	              <div class="dropdown-menu w-100">
	                <!-- Tab content -->
	                <div class="card card-lg">
	                  <div class="card-body">
	                    <div class="tab-content">
	                      <div class="tab-pane fade show active" id="navTab">
	                        <div class="container">
	                          <div class="row">
	                            <div class="col-6 col-md">
	                              <!-- Heading -->
	                              <div class="mb-5 fw-bold">${category.key}</div>
	                              <!-- Links -->
	                              <ul class="list-styled mb-6 mb-md-0 fs-sm">
	                              <c:forEach var="subCat" items="${category.value}">
	                                <li class="list-styled-item">
	                                  <a class="list-styled-link" href="./shop.html">${subCat}</a></li>
	                                  </c:forEach>
	                              </ul>
	              
	                            </div>
	                            
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                </div>
	              
	              </div>
	            </li>
            </c:forEach>
          </ul>
    
          <!-- Nav -->
          <ul class="navbar-nav flex-row">
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="offcanvas" href="#modalSearch">
                <i class="fe fe-search"></i>
              </a>
            </li>
            <li class="nav-item ms-lg-n4">
              <a class="nav-link" href="./account-orders.html">
                <i class="fe fe-user"></i>
              </a>
            </li>
            <li class="nav-item ms-lg-n4">
              <a class="nav-link" data-bs-toggle="offcanvas" href="#modalShoppingCart">
                <span data-cart-items="2">
                  <i class="fe fe-shopping-cart"></i>
                </span>
              </a>
            </li>
          </ul>
    
        </div>
    
      </div>
    </nav>

    <!-- PROMO -->
    <div class="py-3 bg-dark bg-pattern ">
      <div class="container">
        <div class="row">
          <div class="col-12">
    
            <!-- Text -->
            <div class="text-center text-white">
              <span class="heading-xxs letter-spacing-xl">
                ⚡️ Happy Holiday Deals on Everything ⚡️
              </span>
            </div>
    
          </div>
        </div>
      </div>
    </div>

    <!-- BREADCRUMB -->
    <nav class="my-5">
      <div class="container">
        <div class="row">
          <div class="col-12">
          </div>
        </div>
      </div>
    </nav>    
<section class="py-12" id="howItWorks">
      <div class="container">
        <div class="row">
          <div class="col-12">

            <!-- Heading -->
            <h2 class="mb-10 text-center">
              Test
            </h2>

          </div>
        </div>
        <div class="row">
        <c:forEach var="category" items="${totalList}">
          <div class="col-24 col-md-2">
            <!-- Card -->
            <div class="card bg-none mb-7 mb-md-0">
              <!-- Image -->
              <div class="card-img-top position-relative mx-auto" style="max-width: 120px;">
                <!-- Image -->
                <img class="img-fluid rounded-circle" src="imgs/saucedak.png" alt="...">
              </div>
              <!-- Body -->
              <div class="card-body text-center">
                <!-- Heading -->
                <h6 class="mb-4">
                  ${category.key}
                </h6>
              </div>
            </div>
          </div>
          </c:forEach>
        </div>
        
        <section class="py-12">
      <div class="container">
        <div class="row">
          <div class="col-12">

            <!-- Heading -->
            <h2 class="mb-10 text-center">
              추천상품
            </h2>

          </div>
        </div>
        <div class="row">
        <c:forEach var="product" items="${bestProducts}" begin="1" end="3" step="1">
        <div class="col-12 col-md-4 col-lg-3">
			        <div class="card">
					  <div class="card-img">
					    <!-- Image -->
					    <img class="card-img-top" src="./assets/img/products/product-6.jpg" alt="...">
					
					    <!-- Actions -->
					    <div class="card-actions">
					      <span class="card-action">
					        <button class="btn btn-xs btn-circle btn-white-primary" data-toggle="button">
					          <i class="fe fe-shopping-cart"></i>
					        </button>
					      </span>
					      <span class="card-action">
					        <button class="btn btn-xs btn-circle btn-white-primary" data-toggle="button">
					          <i class="fe fe-heart"></i>
					        </button>
					      </span>
					    </div>
					  </div>
					  <!-- Body -->
		              <div class="card-body fw-bold text-center">
		                <a class="text-body" href="#!">${product.productName}</a>
		                <div class="text-muted">price</div>
		              </div>
					</div>
				</div>
        </c:forEach>
        </div>
        
      </div>
    </section>
      </div>
    </section>