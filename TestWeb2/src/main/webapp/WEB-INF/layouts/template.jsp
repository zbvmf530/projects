<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    
    <!-- Favicon -->
    <link rel="shortcut icon" href="./assets/favicon/favicon.ico" type="image/x-icon" />
    
    <!-- Libs CSS -->
    <link rel="stylesheet" href="./assets/css/libs.bundle.css" />
    
    <!-- Theme CSS -->
    <link rel="stylesheet" href="./assets/css/theme.bundle.css" />
    
    <!-- Title -->
    <title>Shopper</title>
  </head>
  <body>
    <tiles:insertAttribute name = "header"></tiles:insertAttribute>
	<tiles:insertAttribute name = "body"></tiles:insertAttribute>
	<tiles:insertAttribute name = "footer"></tiles:insertAttribute>



    <!-- JAVASCRIPT -->
    <!-- Map (replace the API key to enable) -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnKt8_N4-FKOnhI_pSaDL7g_g-XI1-R9E"></script>
    
    <!-- Vendor JS -->
    <script src="./assets/js/mainpage/vendor.bundle.js"></script>
    
    <!-- Theme JS -->
    <script src="./assets/js/mainpage/theme.bundle.js"></script>

  </body>
</html>