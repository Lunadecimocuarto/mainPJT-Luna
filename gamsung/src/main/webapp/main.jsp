<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en-US" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--  
    Document Title
    =============================================
    -->
    <title>GamsungCamp</title>
    <!--  
    Favicons
    =============================================
    -->
    <link rel="apple-touch-icon" sizes="57x57" href="resources/images/favicons/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="resources/images/favicons/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="resources/images/favicons/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="resources/images/favicons/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="resources/images/favicons/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="resources/images/favicons/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="resources/images/favicons/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="resources/images/favicons/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="resources/images/favicons/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="resources/images/favicons/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="resources/images/favicons/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicons/favicon-16x16.png">
    <!-- <link rel="manifest" href="/manifest.json"> -->
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="resources/images/favicons/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!--  
    Stylesheets
    =============================================
    
    -->
    <!-- Default stylesheets-->
    <link href="resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Template specific stylesheets-->
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Volkhov:400i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link href="resources/lib/animate.css/animate.css" rel="stylesheet">
    <link href="resources/lib/components-font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/lib/et-line-font/et-line-font.css" rel="stylesheet">
    <link href="resources/lib/flexslider/flexslider.css" rel="stylesheet">
    <link href="resources/lib/owl.carousel/dist/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="resources/lib/owl.carousel/dist/assets/owl.theme.default.min.css" rel="stylesheet">
    <link href="resources/lib/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link href="resources/lib/simple-text-rotator/simpletextrotator.css" rel="stylesheet">
    <!-- Main stylesheet and color file-->
    <link href="resources/css/style.css" rel="stylesheet">
    <link id="color-scheme" href="resources/css/colors/default.css" rel="stylesheet">
  </head>
  <body data-spy="scroll" data-target=".onpage-navigation" data-offset="60">
    <main>
      <div class="page-loader">
        <div class="loader">Loading...</div>
      </div>
      <!-- header -->
      <jsp:include page="/view/common/header.jsp"/>
      <!-- header End -->
      <!-- Search -->
      <jsp:include page="/view/camp/campSearch.jsp"/>
      <!-- Search End -->
      </section>
      <div class="main showcase-page">
        <section class="module-extra-small bg-dark">
          <div class="container">
            <div class="row">
              <div class="col-sm-6 col-md-8 col-lg-9">
                <div class="callout-text font-alt">
                  <h4 style="margin-top: 0px;">Start Creating Beautiful Websites</h4>
                  <p style="margin-bottom: 0px;">Download Titan Free today!</p>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3">
                <div class="callout-btn-box"><a class="btn btn-border-w btn-circle" href="https://themewagon.com/themes/titan/">Downlaod Free</a></div>
              </div>
            </div>
          </div>
        </section>
        <section class="module-medium" id="demos">
          <div class="container">
            <div class="row multi-columns-row">
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_mp_fullscreen_video_background.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/main_demo.jpg" alt="Main Demo"></div>
                  <h3 class="content-box-title font-serif">Main Demo</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_agency.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/agency.jpg" alt="Agency"></div>
                  <h3 class="content-box-title font-serif">Agency</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_portfolio.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/portfolio.jpg" alt="Portfolio"></div>
                  <h3 class="content-box-title font-serif">Portfolio</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_restaurant.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/restaurant.jpg" alt="Restaurant"></div>
                  <h3 class="content-box-title font-serif">Restaurant</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_finance.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/finance.jpg" alt="Finance"></div>
                  <h3 class="content-box-title font-serif">Finance</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_landing.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/landing.jpg" alt="Landing"></div>
                  <h3 class="content-box-title font-serif">Landing</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_photography.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/photography.jpg" alt="Photography"></div>
                  <h3 class="content-box-title font-serif">Photography</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_shop.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/shop.jpg" alt="Shop"></div>
                  <h3 class="content-box-title font-serif">Shop</h3></a></div>
              <div class="col-md-4 col-sm-6 col-xs-12"><a class="content-box" href="index_op_fullscreen_gradient_overlay.html">
                  <div class="content-box-image"><img src="resources/images/screenshots/one_page.jpg" alt="One Page"></div>
                  <h3 class="content-box-title font-serif">One Page</h3></a></div>
            </div>
          </div>
        </section>
        <hr class="divider-w">
         <section class="module">
          <div class="container">
            <div class="row">
              <div class="col-sm-6 col-sm-offset-3">
                <h2 class="module-title font-alt">추천 경매 상품</h2>
                <div class="module-subtitle font-serif">선착순 12개의 상품이 올라옵니다.</div>
              </div>
            </div>
            <div class="row">
              <div class="owl-carousel text-center" data-items="5" data-pagination="false" data-navigation="false">
                <div class="owl-item">
                  <div class="col-sm-12">
                    <div class="ex-product"><a href="#"><img src="../../resources/images/shop/product-1.jpg" alt="Leather belt"/></a>
                      <h4 class="shop-item-title font-alt"><a href="#">Leather belt</a></h4>£12.00
                    </div>
                  </div>
                </div>
                <div class="owl-item">
                  <div class="col-sm-12">
                    <div class="ex-product"><a href="#"><img src="../../resources/images/shop/product-2.jpg" alt="Derby shoes"/></a>
                      <h4 class="shop-item-title font-alt"><a href="#">Derby shoes</a></h4>£54.00
                    </div>
                  </div>
                </div>
                <div class="owl-item">
                  <div class="col-sm-12">
                    <div class="ex-product"><a href="#"><img src="../../resources/images/shop/product-3.jpg" alt="Leather belt"/></a>
                      <h4 class="shop-item-title font-alt"><a href="#">Leather belt</a></h4>£19.00
                    </div>
                  </div>
                </div>
                <div class="owl-item">
                  <div class="col-sm-12">
                    <div class="ex-product"><a href="#"><img src="../../resources/images/shop/product-4.jpg" alt="Leather belt"/></a>
                      <h4 class="shop-item-title font-alt"><a href="#">Leather belt</a></h4>£14.00
                    </div>
                  </div>
                </div>
                <div class="owl-item">
                  <div class="col-sm-12">
                    <div class="ex-product"><a href="#"><img src="../../resources/images/shop/product-5.jpg" alt="Chelsea boots"/></a>
                      <h4 class="shop-item-title font-alt"><a href="#">Chelsea boots</a></h4>£44.00
                    </div>
                  </div>
                </div>
                <div class="owl-item">
                  <div class="col-sm-12">
                    <div class="ex-product"><a href="#"><img src="../../resources/images/shop/product-6.jpg" alt="Leather belt"/></a>
                      <h4 class="shop-item-title font-alt"><a href="#">Leather belt</a></h4>£19.00
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        <hr class="divider-w">
        <section class="module-extra-small bg-dark">
          <div class="container">
            <div class="row">
              <div class="col-sm-6 col-md-8 col-lg-9">
                <div class="callout-text font-alt">
                  <h4 style="margin-top: 0px;">Start Creating Beautiful Websites</h4>
                  <p style="margin-bottom: 0px;">Download Titan Free today!</p>
                </div>
              </div>
              <div class="col-sm-6 col-md-4 col-lg-3">
                <div class="callout-btn-box"><a class="btn btn-border-w btn-circle" href="https://themewagon.com/themes/titan/">Downlaod Free</a></div>
              </div>
            </div>
          </div>
        </section>
        
      </div>
      <div class="scroll-up"><a href="#totop"><i class="fa fa-angle-double-up"></i></a></div>
    </main>
    <!--  
    JavaScripts
    =============================================
    -->
    <script src="resources/lib/jquery/jquery.js"></script>
    <script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/lib/wow/wow.js"></script>
    <script src="resources/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js"></script>
    <script src="resources/lib/isotope/isotope.pkgd.js"></script>
    <script src="resources/lib/imagesloaded/imagesloaded.pkgd.js"></script>
    <script src="resources/lib/flexslider/jquery.flexslider.js"></script>
    <script src="resources/lib/owl.carousel/dist/owl.carousel.min.js"></script>
    <script src="resources/lib/smoothscroll.js"></script>
    <script src="resources/lib/magnific-popup/magnific-popup.js"></script>
    <script src="resources/lib/simple-text-rotator/jquery.simple-text-rotator.min.js"></script>
    <script src="resources/js/plugins.js"></script>
    <script src="resources/js/main.js"></script>
  </body>
</html>