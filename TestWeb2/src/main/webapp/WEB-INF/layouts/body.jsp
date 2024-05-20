<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HEADER -->
    <div class="pt-7">
      <div class="container">
        <div class="row">
          <div class="col-12">

            <!-- Heading -->
            <h3 class="mb-10 text-center">Women's Clothing</h3>

            <!-- Slider -->
            <div class="flickity-buttons-lg flickity-buttons-offset px-lg-12" data-flickity='{"prevNextButtons": true}'>

              <!-- Item -->
              <div class="col px-4" style="max-width: 200px;">
                <div class="card">

                  <!-- Image -->
                  <img class="card-img-top" src="assets/img/products/product-25.jpg" alt="...">

                  <!-- Body -->
                  <div class="card-body py-4 px-0 text-center">

                    <!-- Heading -->
                    <a class="stretched-link text-body" href="#!">
                      <h6>Dresses <small>(58)</small></h6>
                    </a>

                  </div>

                </div>
              </div>

              <!-- Item -->
              <div class="col px-4" style="max-width: 200px;">
                <div class="card">

                  <!-- Image -->
                  <img class="card-img-top" src="assets/img/products/product-26.jpg" alt="...">

                  <!-- Body -->
                  <div class="card-body py-4 px-0 text-center">

                    <!-- Heading -->
                    <a class="stretched-link text-body" href="#!">
                      <h6>Tops <small>(35)</small></h6>
                    </a>

                  </div>

                </div>
              </div>

              <!-- Item -->
              <div class="col px-4" style="max-width: 200px;">
                <div class="card">

                  <!-- Image -->
                  <img class="card-img-top" src="assets/img/products/product-27.jpg" alt="...">

                  <!-- Body -->
                  <div class="card-body py-4 px-0 text-center">

                    <!-- Heading -->
                    <a class="stretched-link text-body" href="#!">
                      <h6>T-shirts <small>(27)</small></h6>
                    </a>

                  </div>

                </div>
              </div>

              <!-- Item -->
              <div class="col px-4" style="max-width: 200px;">
                <div class="card">

                  <!-- Image -->
                  <img class="card-img-top" src="assets/img/products/product-28.jpg" alt="...">

                  <!-- Body -->
                  <div class="card-body py-4 px-0 text-center">

                    <!-- Heading -->
                    <a class="stretched-link text-body" href="#!">
                      <h6>Shoes <small>(64)</small></h6>
                    </a>

                  </div>

                </div>
              </div>

              <!-- Item -->
              <div class="col px-4" style="max-width: 200px;">
                <div class="card">

                  <!-- Image -->
                  <img class="card-img-top" src="assets/img/products/product-29.jpg" alt="...">

                  <!-- Body -->
                  <div class="card-body py-4 px-0 text-center">

                    <!-- Heading -->
                    <a class="stretched-link text-body" href="#!">
                      <h6>Jeans <small>(12)</small></h6>
                    </a>

                  </div>

                </div>
              </div>

              <!-- Item -->
              <div class="col px-4" style="max-width: 200px;">
                <div class="card">

                  <!-- Image -->
                  <img class="card-img-top" src="assets/img/products/product-14.jpg" alt="...">

                  <!-- Body -->
                  <div class="card-body py-4 px-0 text-center">

                    <!-- Heading -->
                    <a class="stretched-link text-body" href="#!">
                      <h6>Misc <small>(19)</small></h6>
                    </a>

                  </div>

                </div>
              </div>

            </div>

          </div>
        </div>
      </div>
    </div>

    <!-- CONTENT -->
    <section class="py-12">
      <div class="container">
        <div class="row">
          <div class="col-12">

            <!-- Filters -->
            <div class="btn-group-justified btn-group-expand-lg mb-10" role="group">
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Sort by
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Form group -->
                      <div class="form-group-overflow">
                        <div class="form-check form-check-text mb-3">
                          <input class="form-check-input" id="sortOne" name="sort" type="radio" value="Default">
                          <label class="form-check-label" for="sortOne">Default</label>
                        </div>
                        <div class="form-check form-check-text mb-3">
                          <input class="form-check-input" id="sortTwo" name="sort" type="radio" value="Newest">
                          <label class="form-check-label" for="sortTwo">Newest</label>
                        </div>
                        <div class="form-check form-check-text mb-3">
                          <input class="form-check-input" id="sortThree" name="sort" type="radio" value="Most Popular">
                          <label class="form-check-label" for="sortThree">Most Popular</label>
                        </div>
                        <div class="form-check form-check-text mb-3">
                          <input class="form-check-input" id="sortFour" name="sort" type="radio" value="Default Price">
                          <label class="form-check-label" for="sortFour">Default Price</label>
                        </div>
                        <div class="form-check form-check-text">
                          <input class="form-check-input" id="sortFive" name="sort" type="radio" value="Highest Price">
                          <label class="form-check-label" for="sortFive">Highest Price</label>
                        </div>
                      </div>

                    </div>
                  </div>
                </form>

              </div>
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Category
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Form group -->
                      <div class="form-group-overflow">
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categoryOne" name="category" type="checkbox" value="All Products">
                          <label class="form-check-label" for="categoryOne">All Products</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categoryTwo" name="category" type="checkbox" value="Blouses and Shirts">
                          <label class="form-check-label" for="categoryTwo">Blouses and Shirts</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categoryThree" name="category" type="checkbox" value="Coats and Jackets">
                          <label class="form-check-label" for="categoryThree">Coats and Jackets</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categoryFour" name="category" type="checkbox" value="Dresses">
                          <label class="form-check-label" for="categoryFour">Dresses</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categoryFive" name="category" type="checkbox" value="Hoodies and Sweats">
                          <label class="form-check-label" for="categoryFive">Hoodies and Sweats</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categorySix" name="category" type="checkbox" value="Denim">
                          <label class="form-check-label" for="categorySix">Denim</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categorySeven" name="category" type="checkbox" value="Hoodies and Sweats">
                          <label class="form-check-label" for="categorySeven">Hoodies and Sweats</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="categoryEight" name="category" type="checkbox" value="Jeans">
                          <label class="form-check-label" for="categoryEight">Jeans</label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" id="categoryNine" name="category" type="checkbox" value="Jumpers and Cardigans">
                          <label class="form-check-label" for="categoryNine">Jumpers and Cardigans</label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" id="categoryTen" name="category" type="checkbox" value="Leggings">
                          <label class="form-check-label" for="categoryTen">Leggings</label>
                        </div>
                      </div>

                    </div>
                    <div class="card-footer d-flex flex-nowrap border-top">

                      <!-- Buttons -->
                      <button class="btn btn-outline-dark btn-sm" type="reset">
                        Clear
                      </button>
                      <button class="btn btn-dark btn-sm ms-2" type="submit">
                        Show Results
                      </button>

                    </div>
                  </div>
                </form>

              </div>
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Season
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Form group -->
                      <div class="form-group-overflow">
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="seasonOne" name="category" type="checkbox" value="Summer">
                          <label class="form-check-label" for="seasonOne">Summer</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="seasonTwo" name="category" type="checkbox" value="Winter">
                          <label class="form-check-label" for="seasonTwo">Winter</label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="seasonThree" name="category" type="checkbox" value="Spring & Fall">
                          <label class="form-check-label" for="seasonThree">Spring & Fall</label>
                        </div>
                      </div>

                    </div>
                    <div class="card-footer d-flex flex-nowrap border-top">

                      <!-- Buttons -->
                      <button class="btn btn-outline-dark btn-sm" type="reset">
                        Clear
                      </button>
                      <button class="btn btn-dark btn-sm ms-2" type="submit">
                        Show Results
                      </button>

                    </div>
                  </div>
                </form>

              </div>
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Size
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Form group -->
                      <div class="form-group-overflow">
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeOne" type="checkbox">
                          <label class="form-check-label" for="sizeOne">
                            3XS
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeTwo" type="checkbox" disabled>
                          <label class="form-check-label" for="sizeTwo">
                            2XS
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeThree" type="checkbox">
                          <label class="form-check-label" for="sizeThree">
                            XS
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeFour" type="checkbox">
                          <label class="form-check-label" for="sizeFour">
                            S
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeFive" type="checkbox">
                          <label class="form-check-label" for="sizeFive">
                            M
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeSix" type="checkbox">
                          <label class="form-check-label" for="sizeSix">
                            L
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeSeven" type="checkbox">
                          <label class="form-check-label" for="sizeSeven">
                            XL
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeEight" type="checkbox" disabled>
                          <label class="form-check-label" for="sizeEight">
                            2XL
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeNine" type="checkbox">
                          <label class="form-check-label" for="sizeNine">
                            3XL
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeTen" type="checkbox">
                          <label class="form-check-label" for="sizeTen">
                            4XL
                          </label>
                        </div>
                        <div class="form-check form-check-inline form-check-size mb-2">
                          <input class="form-check-input" id="sizeEleven" type="checkbox">
                          <label class="form-check-label" for="sizeEleven">
                            One Size
                          </label>
                        </div>
                      </div>

                    </div>
                    <div class="card-footer d-flex flex-nowrap border-top">

                      <!-- Buttons -->
                      <button class="btn btn-outline-dark btn-sm" type="reset">
                        Clear
                      </button>
                      <button class="btn btn-dark btn-sm ms-2" type="submit">
                        Show Results
                      </button>

                    </div>
                  </div>
                </form>

              </div>
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Color
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Form group -->
                      <div class="form-group-overflow">
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorOne" type="checkbox" style="background-color: #1f1f1f">
                          <label class="form-check-label text-body" for="colorOne">
                            Black
                          </label>
                        </div>
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorTwo" type="checkbox" style="background-color: #f9f9f9">
                          <label class="form-check-label text-body" for="colorTwo">
                            White
                          </label>
                        </div>
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorThree" type="checkbox" style="background-color: #3b86ff">
                          <label class="form-check-label text-body" for="colorThree">
                            Blue
                          </label>
                        </div>
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorFour" type="checkbox" style="background-color: #ff6f61">
                          <label class="form-check-label text-body" for="colorFour">
                            Red
                          </label>
                        </div>
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorFive" type="checkbox" style="background-color: #795548" disabled>
                          <label class="form-check-label text-body" for="colorFive">
                            Brown
                          </label>
                        </div>
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorSix" type="checkbox" style="background-color: #bababa">
                          <label class="form-check-label text-body" for="colorSix">
                            Gray
                          </label>
                        </div>
                        <div class="form-check form-check-color mb-3">
                          <input class="form-check-input" id="colorSeven" type="checkbox" style="background-color: #17a2b8">
                          <label class="form-check-label text-body" for="colorSeven">
                            Cyan
                          </label>
                        </div>
                        <div class="form-check form-check-color">
                          <input class="form-check-input" id="colorEight" type="checkbox" style="background-color: #e83e8c">
                          <label class="form-check-label text-body" for="colorEight">
                            Pink
                          </label>
                        </div>
                      </div>

                    </div>
                    <div class="card-footer d-flex flex-nowrap border-top">

                      <!-- Buttons -->
                      <button class="btn btn-outline-dark btn-sm" type="reset">
                        Clear
                      </button>
                      <button class="btn btn-dark btn-sm ms-2" type="submit">
                        Show Results
                      </button>

                    </div>
                  </div>
                </form>

              </div>
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Brand
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Search -->
                      <div data-list='{"valueNames": ["name"]}'>

                        <!-- Input group -->
                        <div class="input-group input-group-merge mb-6">
                          <input class="form-control form-control-xs search" type="search" placeholder="Search Brand">

                          <!-- Button -->
                          <div class="input-group-append">
                            <button class="btn btn-outline-border btn-xs">
                              <i class="fe fe-search"></i>
                            </button>
                          </div>

                        </div>

                        <!-- Form group -->
                        <div class="form-group-overflow" id="brandGroup">
                          <div class="list">
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandOne" type="checkbox">
                              <label class="form-check-label name" for="brandOne">
                                Dsquared2
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandTwo" type="checkbox" disabled>
                              <label class="form-check-label name" for="brandTwo">
                                Alexander McQueen
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandThree" type="checkbox">
                              <label class="form-check-label name" for="brandThree">
                                Balenciaga
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandFour" type="checkbox">
                              <label class="form-check-label name" for="brandFour">
                                Adidas
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandFive" type="checkbox">
                              <label class="form-check-label name" for="brandFive">
                                Balmain
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandSix" type="checkbox">
                              <label class="form-check-label name" for="brandSix">
                                Burberry
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandSeven" type="checkbox">
                              <label class="form-check-label name" for="brandSeven">
                                Chloé
                              </label>
                            </div>
                            <div class="form-check mb-3">
                              <input class="form-check-input" id="brandEight" type="checkbox">
                              <label class="form-check-label name" for="brandEight">
                                Kenzo
                              </label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" id="brandNine" type="checkbox">
                              <label class="form-check-label name" for="brandNine">
                                Givenchy
                              </label>
                            </div>
                          </div>
                        </div>

                      </div>

                    </div>
                    <div class="card-footer d-flex flex-nowrap border-top">

                      <!-- Buttons -->
                      <button class="btn btn-outline-dark btn-sm" type="reset">
                        Clear
                      </button>
                      <button class="btn btn-dark btn-sm ms-2" type="submit">
                        Show Results
                      </button>

                    </div>
                  </div>
                </form>

              </div>
              <div class="btn-group dropdown">

                <!-- Toggle -->
                <button class="btn btn-sm w-100 btn-outline-border dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" data-bs-auto-close="outside">
                  Price
                </button>

                <!-- Menu -->
                <form class="dropdown-menu">
                  <div class="card">
                    <div class="card-body">

                      <!-- Form group -->
                      <div class="form-group-overflow">
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="priceOne" type="checkbox">
                          <label class="form-check-label" for="priceOne">
                            $10.00 - $49.00
                          </label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="priceTwo" type="checkbox">
                          <label class="form-check-label" for="priceTwo">
                            $50.00 - $99.00
                          </label>
                        </div>
                        <div class="form-check mb-3">
                          <input class="form-check-input" id="priceThree" type="checkbox">
                          <label class="form-check-label" for="priceThree">
                            $100.00 - $199.00
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" id="priceFour" type="checkbox">
                          <label class="form-check-label" for="priceFour">
                            $200.00 and Up
                          </label>
                        </div>
                      </div>

                    </div>
                    <div class="card-footer d-flex flex-nowrap border-top">

                      <!-- Buttons -->
                      <button class="btn btn-outline-dark btn-sm" type="reset">
                        Clear
                      </button>
                      <button class="btn btn-dark btn-sm ms-2" type="submit">
                        Show Results
                      </button>

                    </div>
                  </div>
                </form>

              </div>
            </div>

          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-6.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Cotton floral print Dress</a>
                <div class="text-muted">$40.00</div>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Badge -->
                <span class="badge bg-dark card-badge card-badge-start text-uppercase">
                  Sale
                </span>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-10.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Suede cross body Bag</a>
                <div>
                  <span class="fs-xs text-gray-350 text-decoration-line-through">$85.00</span>
                  <span class="text-primary">$49.00</span>
                </div>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-32.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Cotton leaf print Shirt</a>
                <div class="text-muted">$65.00</div>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-7.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Leather Sneakers</a>
                <a class="text-primary" href="#">Select Options</a>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-11.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Another fine dress</a>
                <div class="text-muted">$99.00</div>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-33.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Baseball Cap</a>
                <div class="text-muted">$10.00</div>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-49.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Leather sneakers</a>
                <div class="text-muted">$19.00</div>
              </div>

            </div>

          </div>
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Card -->
            <div class="card mb-7">

              <!-- Image -->
              <div class="card-img">

                <!-- Action -->
                <button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end" data-toggle="button">
                  <i class="fe fe-heart"></i>
                </button>

                <!-- Button -->
                <button class="btn btn-xs w-100 btn-dark card-btn">
                  <i class="fe fe-eye me-2 mb-1"></i> Quick View
                </button>

                <!-- Image -->
                <img class="card-img-top" src="assets/img/products/product-48.jpg" alt="...">

              </div>

              <!-- Body -->
              <div class="card-body fw-bold text-center">
                <a class="text-body" href="#!">Sweatshirt with Pocket</a>
                <div class="text-muted">$39.00</div>
              </div>

            </div>

          </div>
        </div>
        <div class="row">
          <div class="col-12">

            <!-- Progress -->
            <div class="row justify-content-center mt-7">
              <div class="col-12 text-center">

                <!-- Caption -->
                <p class="fs-sm text-muted">
                  Showing 16 of 24 products
                </p>

                <!-- Progress -->
                <div class="progress mx-auto mb-7" style="max-width: 250px;">
                  <div class="progress-bar bg-dark" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
                </div>

                <!-- Button -->
                <a class="btn btn-sm btn-outline-dark" href="#!">
                  Load more
                </a>

              </div>
            </div>

          </div>
        </div>
      </div>
    </section>